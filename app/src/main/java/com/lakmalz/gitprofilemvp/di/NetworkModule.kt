package com.lakmalz.gitprofilemvp.di

import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.cache.http.HttpCachePolicy
import com.apollographql.apollo.cache.http.ApolloHttpCache
import com.apollographql.apollo.cache.http.DiskLruHttpCacheStore
import com.lakmalz.gitprofilemvp.util.AuthorizationInterceptor
import com.lakmalz.gitprofilemvp.util.BASE_URL
import com.lakmalz.gitprofilemvp.util.CACHE_DIR
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideDiskLruHttpCacheStore(@ApplicationContext context: Context): DiskLruHttpCacheStore {
        val file = File(context.cacheDir, CACHE_DIR)
        val sizeInMegaBytes: Long = 1024 * 1024 * 1
        return DiskLruHttpCacheStore(file, sizeInMegaBytes)
    }

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor())
            .build()
    }

    @Singleton
    @Provides
    fun provideApolloClient(
        okHttp: OkHttpClient,
        diskLruHttpCacheStore: DiskLruHttpCacheStore
    ): ApolloClient {
        return ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttp)
            .httpCache(ApolloHttpCache(diskLruHttpCacheStore))
            .defaultHttpCachePolicy(HttpCachePolicy.CACHE_FIRST.expireAfter(1, TimeUnit.MINUTES))
            .build()
    }
}
package com.lakmalz.gitprofilemvp.di

import com.lakmalz.gitprofilemvp.datasource.repository.UserRepository
import com.lakmalz.gitprofilemvp.ui.MainContract
import com.lakmalz.gitprofilemvp.ui.MainPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import io.reactivex.disposables.CompositeDisposable

@Module
@InstallIn(ActivityComponent::class)
class MainModule {
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
    @Provides
    fun provideMainPresenter(userRepository: UserRepository, compositeDisposable:CompositeDisposable): MainContract.Presenter {
        return MainPresenter(userRepository, compositeDisposable)
    }
}
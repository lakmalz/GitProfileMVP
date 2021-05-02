package com.lakmalz.gitprofilemvp.datasource.repository

import com.apollographql.apollo.api.Response
import com.lakmalz.gitprofilemvp.GetUserProfileQuery
import com.lakmalz.gitprofilemvp.datasource.DataSource
import com.lakmalz.gitprofilemvp.datasource.repository.remote.RemoteData
import io.reactivex.Observable
import javax.inject.Inject

class UserRepository @Inject constructor(private val remoteData: RemoteData /*, localData here*/) :
    DataSource {
    override fun getUserProfile(name: String): Observable<Response<GetUserProfileQuery.Data>> =
        remoteData.getUserProfile(name)
//        flow {
//            when (val result = remoteData.getUserProfile(name)) {
//                is AppResult.Success -> {
//                    result.data?.let {
//                        it.mapToDomainModel().apply {
//                            emit(AppResult.Success(this))
//                        }
//                    }
//                }
//                is AppResult.Error -> {
//                    emit(AppResult.Error(result.exception))
//                }
//            }
//        }.onStart { emit(AppResult.Loading)  }
//        val result = remoteData.getUserProfile(name)


}
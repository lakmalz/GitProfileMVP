package com.lakmalz.gitprofilemvp.datasource.repository.remote

import com.apollographql.apollo.api.Response
import com.lakmalz.gitprofilemvp.GetUserProfileQuery
import com.lakmalz.gitprofilemvp.datasource.network.GraphqlServices
import io.reactivex.Observable
import javax.inject.Inject

class RemoteData @Inject constructor(private val mGraphqlService: GraphqlServices) {
    fun getUserProfile(name: String): Observable<Response<GetUserProfileQuery.Data>> =
        mGraphqlService.getUserProfile(name)

}
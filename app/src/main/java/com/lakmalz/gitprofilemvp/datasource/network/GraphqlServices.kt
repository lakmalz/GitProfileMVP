package com.lakmalz.gitprofilemvp.datasource.network

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.ApolloQueryCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.rx2.rxQuery
import com.lakmalz.gitprofilemvp.GetUserProfileQuery
import io.reactivex.Observable
import javax.inject.Inject

class GraphqlServices @Inject constructor(private val apolloClient: ApolloClient) {
    fun getUserProfile(name: String): Observable<Response<GetUserProfileQuery.Data>> =
        apolloClient.rxQuery(GetUserProfileQuery(name))



}

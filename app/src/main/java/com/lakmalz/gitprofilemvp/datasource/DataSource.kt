package com.lakmalz.gitprofilemvp.datasource

import com.apollographql.apollo.api.Response
import com.lakmalz.gitprofilemvp.GetUserProfileQuery
import io.reactivex.Observable

interface DataSource {
    fun getUserProfile(name: String): Observable<Response<GetUserProfileQuery.Data>>
}
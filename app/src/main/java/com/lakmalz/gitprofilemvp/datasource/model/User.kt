package com.lakmalz.gitprofilemvp.datasource.model

import com.lakmalz.gitprofilemvp.GetUserProfileQuery

class User(
    val name: String,
    val login: String,
    val email: String,
    val avatarUrl: String,
    val followers: Int,
    val following: Int,
    val pinnedItems: List<Repository?>?,
    val topRepositories: List<Repository?>?,
    val starredRepositories: List<Repository?>?,

)

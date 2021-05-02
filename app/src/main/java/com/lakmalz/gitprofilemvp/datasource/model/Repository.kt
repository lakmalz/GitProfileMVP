package com.lakmalz.gitprofilemvp.datasource.model

class Repository(
    val id: String,
    val name: String,
    val description: String,
    val stargazerCount: Int,
    val owner: Owner,
    val primaryLanguage: PrimaryLanguage
)
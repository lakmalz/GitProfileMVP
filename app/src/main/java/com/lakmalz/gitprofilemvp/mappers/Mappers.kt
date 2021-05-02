package com.lakmalz.gitprofilemvp.mappers

import com.lakmalz.gitprofilemvp.GetUserProfileQuery
import com.lakmalz.gitprofilemvp.datasource.model.*
import com.lakmalz.gitprofilemvp.fragment.RepositoryFragment

fun GetUserProfileQuery.User.mapToDomainModel() =
    pinnedItems.mapToDomainModel()?.let { pinnedItems ->
        topRepositories.mapToDomainModel()?.let {topRepositories ->
            starredRepositories.mapToDomainModel()?.let {starredRepositories ->
                User(
                    name ?: "",
                    login,
                    email,
                    avatarUrl ?: "",
                    followers.mapToDomainModel().totalCount,
                    following.mapToDomainModel().totalCount,
                    pinnedItems.node?: emptyList(),
                    topRepositories.node?: emptyList(),
                    starredRepositories.node?: emptyList()
                )
            }
        }
    }

fun GetUserProfileQuery.Followers.mapToDomainModel() = Followers(totalCount)

fun GetUserProfileQuery.Following.mapToDomainModel() = Following(totalCount)

fun GetUserProfileQuery.PinnedItems.mapToDomainModel() = nodes?.map {
    it?.mapToDomainModel()
}?.let { Node(it) }

fun GetUserProfileQuery.StarredRepositories.mapToDomainModel() = nodes?.map {
    it?.mapToDomainModel()
}?.let { Node(it) }

fun GetUserProfileQuery.TopRepositories.mapToDomainModel() = nodes?.map {
    it?.mapToDomainModel()
}?.let { Node(it) }

fun RepositoryFragment.Owner.mapToDomainModel() = avatarUrl?.let { Owner(login, it) }

fun RepositoryFragment.PrimaryLanguage.mapToDomainModel() = color?.let { PrimaryLanguage(name, it) }

fun GetUserProfileQuery.Node.mapToDomainModel() =
    fragments.repositoryFragment?.owner?.mapToDomainModel()?.let { owner ->
        fragments.repositoryFragment.primaryLanguage?.mapToDomainModel()
            ?.let { primaryLanguage ->
                Repository(
                    fragments?.repositoryFragment?.id ?: "",
                    fragments?.repositoryFragment?.name ?: "",
                    fragments?.repositoryFragment?.description ?: "",
                    fragments?.repositoryFragment?.stargazerCount ?: 0,
                    owner,
                    primaryLanguage
                )
            }
    }

fun GetUserProfileQuery.Node1.mapToDomainModel() =
    fragments.repositoryFragment?.owner?.mapToDomainModel()?.let { owner ->
        fragments.repositoryFragment.primaryLanguage?.mapToDomainModel()
            ?.let { primaryLanguage ->
                Repository(
                    fragments?.repositoryFragment?.id ?: "",
                    fragments?.repositoryFragment?.name ?: "",
                    fragments?.repositoryFragment?.description ?: "",
                    fragments?.repositoryFragment?.stargazerCount ?: 0,
                    owner,
                    primaryLanguage
                )
            }
    }

fun GetUserProfileQuery.Node2.mapToDomainModel() =
    fragments.repositoryFragment?.owner?.mapToDomainModel()?.let { owner ->
        fragments.repositoryFragment.primaryLanguage?.mapToDomainModel()
            ?.let { primaryLanguage ->
                Repository(
                    fragments?.repositoryFragment?.id ?: "",
                    fragments?.repositoryFragment?.name ?: "",
                    fragments?.repositoryFragment?.description ?: "",
                    fragments?.repositoryFragment?.stargazerCount ?: 0,
                    owner,
                    primaryLanguage
                )
            }
    }

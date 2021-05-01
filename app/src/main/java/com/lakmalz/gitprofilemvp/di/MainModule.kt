package com.lakmalz.gitprofilemvp.di

import com.lakmalz.gitprofilemvp.ui.MainContract
import com.lakmalz.gitprofilemvp.ui.MainPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class MainModule {

    @Provides
    fun provideMainPresenter(): MainContract.Presenter {
        return MainPresenter()
    }
}
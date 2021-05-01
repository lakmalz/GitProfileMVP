package com.lakmalz.gitprofilemvp.ui

import com.lakmalz.gitprofilemvp.base.BaseContract
import com.lakmalz.gitprofilemvp.model.UserModel

class MainContract {

    interface View : BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(data: String)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadData()
    }

    interface Model {
        fun userProfileData(): UserModel
    }
}
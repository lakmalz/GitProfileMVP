package com.lakmalz.gitprofilemvp.ui

import com.lakmalz.gitprofilemvp.base.BaseContract
import com.lakmalz.gitprofilemvp.datasource.model.User
import com.lakmalz.gitprofilemvp.util.AppResult

class MainContract {

    interface View : BaseContract.View {
        fun loadDataSuccess(data: User?)
    }

    interface Presenter : BaseContract.Presenter<View> {
         fun loadData()
    }

}
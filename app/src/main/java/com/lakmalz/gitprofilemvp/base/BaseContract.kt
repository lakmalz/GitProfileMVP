package com.lakmalz.gitprofilemvp.base

class BaseContract {
    interface Presenter<in T> {
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View{
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String)
    }
}
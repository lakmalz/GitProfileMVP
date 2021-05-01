package com.lakmalz.gitprofilemvp.ui

import javax.inject.Inject

class MainPresenter @Inject constructor() : MainContract.Presenter {
    lateinit var view: MainContract.View

    override fun loadData() {
        view.loadDataSuccess("Lakmal")
    }

    override fun unsubscribe() {
        TODO("Not yet implemented")
    }

    override fun attach(view: MainContract.View) {
        this.view = view
    }
}
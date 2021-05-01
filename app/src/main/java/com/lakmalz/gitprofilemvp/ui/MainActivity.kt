package com.lakmalz.gitprofilemvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lakmalz.gitprofilemvp.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(),MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attach(this)
        presenter.loadData()
    }

    override fun showProgress(show: Boolean) {
        TODO("Not yet implemented")
    }

    override fun showErrorMessage(error: String) {
        TODO("Not yet implemented")
    }

    override fun loadDataSuccess(data: String) {
        Log.e("LKR", "$data")
    }

    override fun onDestroy() {
        presenter.unsubscribe()
        super.onDestroy()
    }
}
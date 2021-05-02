package com.lakmalz.gitprofilemvp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation
import com.lakmalz.gitprofilemvp.R
import com.lakmalz.gitprofilemvp.datasource.model.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_profile_header.*
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionBar()
        presenter.attach(this)
        presenter.loadData()
    }


    private fun actionBar() {
        setSupportActionBar(tb_view)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        txt_title?.text = getString(R.string.profile)
    }

    private fun setData() {
//        img_avatar.load("https://avatars.githubusercontent.com/u/4619855?u=47bbfcc8a2358e96d3cafcc373d61a1782bf8ca3&v=4") {
//            crossfade(true)
////            placeholder(R.drawable.image)
//            transformations(CircleCropTransformation())
//        }
    }

    override fun onDestroy() {
        presenter.unsubscribe()
        super.onDestroy()
    }

    override fun loadDataSuccess(data: User?) {
        Log.e("", "")
    }

    override fun showProgress() {
        Log.e("", "")
    }

    override fun hideProgress() {
        Log.e("", "")
    }

    override fun showErrorMessage(error: String) {
        Log.e("", "")
    }
}
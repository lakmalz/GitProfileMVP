package com.lakmalz.gitprofilemvp.ui

import com.lakmalz.gitprofilemvp.datasource.repository.UserRepository
import com.lakmalz.gitprofilemvp.fragment.RepositoryFragment
import com.lakmalz.gitprofilemvp.mappers.mapToDomainModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val userRepository: UserRepository,
    private val compositeDisposable: CompositeDisposable
) :
    MainContract.Presenter {
    private var view: MainContract.View? = null

    override  fun loadData() {
        compositeDisposable.add(userRepository.getUserProfile("Lakmalz")
            .doOnSubscribe { view?.showProgress() }
            .doOnComplete { view?.hideProgress() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (!it.hasErrors()) {
                    it.data?.user?.mapToDomainModel().apply {
                        view?.loadDataSuccess(this)
                    }
                }
//                if (it.isSuccessful && it.body() != null) {
//                   it.body().also { list ->
//                       list?.map { item->
//                           view?.loadDataSuccess("${item?.title}")
//                       }
//                   }
//                } else {
//                    view?.showErrorMessage("Error occured")
//                }
            }, {
                view?.showErrorMessage("${it.message}")
//                responseWorkingHours.postValue(null)
            })
        )


    }

    override fun unsubscribe() {
        this.view = null
        compositeDisposable.dispose()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
    }
}
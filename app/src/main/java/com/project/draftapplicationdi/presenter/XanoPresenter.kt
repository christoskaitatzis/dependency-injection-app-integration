package com.project.draftapplicationdi.presenter

import com.project.draftapplicationdi.api.XanoAPI
import com.project.draftapplicationdi.model.Technology
import com.project.draftapplicationdi.rx.RxThread
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class XanoPresenter @Inject constructor(private val api: XanoAPI, private val rxThread: RxThread) {

    private var view: View? = null
    private val disposable = CompositeDisposable()

    interface View   {
        fun showData(technologiesList: List<Technology>)
    }

    fun injectView(view: View?) {
        this.view = view
    }

    fun getXanoData() {

        disposable.add(api.getTechnologies()
            .compose(rxThread.applyAsync())
            .onErrorReturnItem(emptyList())
            .subscribe {
                view?.showData(it)
            }
        )
    }


    fun onStop() {
        disposable.clear()
    }
}
package me.androidkotlinblueprint.common.ui

import android.support.annotation.CallSuper
import com.bluelinelabs.conductor.Controller

/**
 * Base Controller, act as View in MVP
 *
 * Created by hduykhiem on 19/12/2016.
 */
abstract class BaseController : Controller(), MvpView {

    init {
        initializeController()
    }

    @CallSuper
    fun initializeController() {
        getPresenter().bindView(this)
        getPresenter().initialize(args)
    }

    abstract fun getPresenter(): Presenter<MvpView>
}

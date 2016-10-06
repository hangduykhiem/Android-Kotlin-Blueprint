package me.androidkotlinblueprint.common.ui.base

import android.support.annotation.CallSuper
import me.androidkotlinblueprint.common.ui.base.MvpView
import me.androidkotlinblueprint.common.ui.base.Presenter
import rx.Subscription
import rx.lang.kotlin.plusAssign
import rx.subscriptions.CompositeSubscription

/**
 * Created by ilyazorin on 15/09/16.
 */
abstract class BasePresenter<V : MvpView> : Presenter<V> {

    protected val subscriptions: CompositeSubscription = CompositeSubscription()
    protected var view: V? = null

    @CallSuper
    override fun bindView(view: V) {
        this.view = view
    }

    @CallSuper
    override fun unbindView() {
        this.view = null
    }

    @CallSuper
    override fun onDestroy() {
        subscriptions.clear()
    }

    fun addSubscription(subscription: Subscription) {
        subscriptions += subscription
    }
}
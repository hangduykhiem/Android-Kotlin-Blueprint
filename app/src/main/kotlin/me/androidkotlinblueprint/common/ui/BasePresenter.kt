package me.androidkotlinblueprint.common.ui

import android.os.Bundle
import android.support.annotation.CallSuper
import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by ilyazorin on 15/09/16.
 */
abstract class BasePresenter<V : MvpView> {

    protected val subscriptions: CompositeSubscription = CompositeSubscription()
    protected var view: V? = null

    @CallSuper
    fun bindView(view: V) {
        this.view = view
    }

    @CallSuper
    fun unbindView() {
        this.view = null
    }

    @CallSuper
    fun onDestroy() {
        subscriptions.clear()
    }

    fun addSubscription(subscription: Subscription) {
        subscriptions.add(subscription)
    }

    abstract fun initialize(args: Bundle)
}

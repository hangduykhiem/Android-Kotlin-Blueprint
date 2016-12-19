package me.androidkotlinblueprint.common.ui

import android.support.annotation.CallSuper
import rx.Subscription
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
        subscriptions.add(subscription)
    }
}

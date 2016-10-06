package me.androidkotlinblueprint.common.ui.base

/**
 * Created by ilyazorin on 15/09/16.
 */
interface Presenter<in V : MvpView> {

    fun bindView(view: V)

    fun unbindView()

    fun onDestroy()
}
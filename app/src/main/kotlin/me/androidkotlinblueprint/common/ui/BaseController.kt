package me.androidkotlinblueprint.common.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import me.androidkotlinblueprint.AndroidKotlinBlueprint
import me.androidkotlinblueprint.common.di.ApplicationComponent
import javax.inject.Inject

/**
 * Base Controller, act as View in MVP
 *
 * Created by hduykhiem on 19/12/2016.
 */
abstract class BaseController<V : MvpView, T : BasePresenter<V>>(args: Bundle) : Controller(args) {

    @Inject
    protected lateinit var presenter: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        injectDependencies(AndroidKotlinBlueprint.graph)
        presenter.bindView(this as V)
        return inflateView(inflater, container)
    }

    abstract fun injectDependencies(graph: ApplicationComponent)

    abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup): View



}

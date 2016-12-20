package me.androidkotlinblueprint.main.presenter

import android.os.Bundle
import me.androidkotlinblueprint.common.ui.BasePresenter
import me.androidkotlinblueprint.main.view.MainView
import javax.inject.Inject

/**
 * Main [BasePresenter] for the [MainView]
 *
 * Created by hduykhiem on 19/12/2016.
 */
class MainPresenter @Inject constructor() : BasePresenter<MainView>() {

    override fun initialize(args: Bundle) {

    }
}

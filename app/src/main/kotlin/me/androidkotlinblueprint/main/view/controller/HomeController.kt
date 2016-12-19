package me.androidkotlinblueprint.main.view.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import me.androidkotlinblueprint.R
import me.androidkotlinblueprint.main.presenter.MainPresenter
import me.androidkotlinblueprint.main.view.MainView
import javax.inject.Inject

/**
 * Controller for the mainActivity
 *
 * Created by hduykhiem on 19/12/2016.
 */
class HomeController() : Controller(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    private lateinit var mainPresenter: MainPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_home, container, false)
        (view.findViewById(R.id.tv_title) as TextView).text = "Hello World"
        return view
    }

}

package me.androidkotlinblueprint.search.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import me.androidkotlinblueprint.R

/**
 * Controller for search
 *
 * Created by hduykhiem on 20/12/2016.
 */

class SearchController() : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_search, container, false)
        (view.findViewById(R.id.tv_title) as TextView).text = "Hello World"
        return view
    }
}

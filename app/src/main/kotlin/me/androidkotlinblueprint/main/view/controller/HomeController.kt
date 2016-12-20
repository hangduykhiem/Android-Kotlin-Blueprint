package me.androidkotlinblueprint.main.view.controller

import android.support.design.widget.TabLayout
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.support.ControllerPagerAdapter
import me.androidkotlinblueprint.R
import me.androidkotlinblueprint.main.view.MainView
import me.androidkotlinblueprint.search.view.SearchController

/**
 * Controller for the mainActivity
 *
 * Created by hduykhiem on 19/12/2016.
 */
class HomeController() : Controller(), MainView {

    private var pagerAdapter: PagerAdapter

    @BindView(R.id.tab_layout) lateinit var tabLayout: TabLayout
    @BindView(R.id.view_pager) lateinit var viewPager: ViewPager
    private var unbinder: Unbinder? = null

    init {
        pagerAdapter = object : ControllerPagerAdapter(this, false) {
            override fun getItem(position: Int): Controller {
                return SearchController()
            }

            override fun getCount(): Int {
                return 2
            }

            override fun getPageTitle(position: Int): CharSequence {
                return "Page " + position
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        var v: View = inflater.inflate(R.layout.controller_home, container, false)
        unbinder = ButterKnife.bind(this, v)
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
        return v
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        viewPager.adapter = null
        unbinder?.unbind()
        unbinder = null
    }
}

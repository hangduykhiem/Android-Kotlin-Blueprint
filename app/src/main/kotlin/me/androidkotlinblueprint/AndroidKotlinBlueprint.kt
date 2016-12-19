package me.androidkotlinblueprint

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import me.androidkotlinblueprint.common.di.ApplicationComponent
import me.androidkotlinblueprint.common.di.ApplicationModule
import me.androidkotlinblueprint.common.di.DaggerApplicationComponent
import me.androidkotlinblueprint.common.di.NetworkModule
import timber.log.Timber

/**
 * Created by ilyazorin on 15/09/16.
 */
class AndroidKotlinBlueprint : Application() {

    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        initDependencyGraph()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        LeakCanary.install(this)
    }

    private fun initDependencyGraph() {
        graph = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        graph.injectTo(this)
    }
}

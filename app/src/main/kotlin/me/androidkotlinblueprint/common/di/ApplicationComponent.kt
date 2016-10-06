package me.androidkotlinblueprint.common.di

import dagger.Component
import me.androidkotlinblueprint.AndroidKotlinBlueprint
import me.androidkotlinblueprint.common.di.ApplicationModule
import me.androidkotlinblueprint.common.di.NetworkModule
import javax.inject.Singleton

/**
 * Created by ilyazorin on 15/09/16.
 */
@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class))
interface ApplicationComponent {

    fun injectTo(app: AndroidKotlinBlueprint)
}
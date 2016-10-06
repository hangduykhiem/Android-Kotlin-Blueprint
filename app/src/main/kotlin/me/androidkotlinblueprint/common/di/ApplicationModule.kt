package me.androidkotlinblueprint.common.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ilyazorin on 15/09/16.
 */
@Module
class ApplicationModule(private val app: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = app
}
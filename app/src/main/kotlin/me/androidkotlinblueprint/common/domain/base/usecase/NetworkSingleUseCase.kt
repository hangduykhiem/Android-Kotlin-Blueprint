package me.androidkotlinblueprint.common.domain.base.usecase

import android.net.ConnectivityManager
import rx.Scheduler
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by ilyazorin on 15/09/16.
 */
abstract class NetworkSingleUseCase<T>(private val connectivityManager: ConnectivityManager,
                                       subscribeOn: Scheduler = Schedulers.io(),
                                       observeOn: Scheduler = AndroidSchedulers.mainThread()): SingleUseCase<T>(subscribeOn, observeOn), NetworkUseCase {

    override fun get() = when(hasNetworkConnection()) {
        true -> super.get()
        false -> Single.error(NoConnectionException())
    }

    override fun hasNetworkConnection(): Boolean = connectivityManager.activeNetworkInfo?.isConnectedOrConnecting ?: false
}
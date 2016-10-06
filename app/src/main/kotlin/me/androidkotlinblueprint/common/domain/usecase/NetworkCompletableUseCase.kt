package me.androidkotlinblueprint.common.domain.usecase

import android.net.ConnectivityManager
import rx.Completable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by ilyazorin on 15/09/16.
 */
abstract class NetworkCompletableUseCase(private val connectivityManager: ConnectivityManager,
                                         subscribeOn: Scheduler = Schedulers.io(),
                                         observeOn: Scheduler = AndroidSchedulers.mainThread()): CompletableUseCase(subscribeOn, observeOn), NetworkUseCase {

    override fun get() = when(hasNetworkConnection()) {
        true ->  super.get()
        false -> Completable.error(NoConnectionException())
    }

    override fun hasNetworkConnection(): Boolean = connectivityManager.activeNetworkInfo?.isConnectedOrConnecting ?: false
}
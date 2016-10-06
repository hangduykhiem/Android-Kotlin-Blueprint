package me.androidkotlinblueprint.common.domain.base.usecase

import me.androidkotlinblueprint.common.domain.base.usecase.UseCase
import rx.Observable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by ilyazorin on 15/09/16.
 */
abstract class ObservableUseCase<T>(private val subscribeOn: Scheduler = Schedulers.io(),
                                    private val observeOn: Scheduler = AndroidSchedulers.mainThread()): UseCase {

    open fun get() = buildObservable()
                    .subscribeOn(subscribeOn)
                    .observeOn(observeOn)

    protected abstract fun buildObservable(): Observable<T>
}
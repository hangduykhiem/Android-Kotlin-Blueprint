package me.androidkotlinblueprint.common.domain.usecase

import rx.Completable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by ilyazorin on 15/09/16.
 */
abstract class CompletableUseCase(private val subscribeOn: Scheduler = Schedulers.io(),
                                  private val observeOn: Scheduler = AndroidSchedulers.mainThread()): UseCase {

    open fun get() = buildCompletable()
                    .subscribeOn(subscribeOn)
                    .observeOn(observeOn)

    protected abstract fun buildCompletable(): Completable
}
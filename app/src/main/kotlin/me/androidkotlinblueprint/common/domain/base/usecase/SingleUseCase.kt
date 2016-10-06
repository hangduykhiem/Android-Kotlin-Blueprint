package me.androidkotlinblueprint.common.domain.base.usecase

import rx.Scheduler
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by ilyazorin on 15/09/16.
 */
abstract class SingleUseCase<T>(private val subscribeOn: Scheduler = Schedulers.io(),
                                private val observeOn: Scheduler = AndroidSchedulers.mainThread()): UseCase {

    open fun get() = buildSingle()
                    .subscribeOn(subscribeOn)
                    .observeOn(observeOn)

    protected abstract fun buildSingle(): Single<T>
}
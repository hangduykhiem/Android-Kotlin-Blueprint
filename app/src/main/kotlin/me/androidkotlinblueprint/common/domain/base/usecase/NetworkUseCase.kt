package me.androidkotlinblueprint.common.domain.base.usecase

import me.androidkotlinblueprint.common.domain.base.usecase.UseCase

/**
 * Created by ilyazorin on 20/09/16.
 */
interface NetworkUseCase : UseCase {

    fun hasNetworkConnection(): Boolean
}

class NoConnectionException : Throwable("No network connection")
package org.seleznyoviyu.klab.webflux.da.repository

import org.seleznyoviyu.klab.webflux.da.supplier.ReactiveEntityProvider
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import kotlin.random.Random

@Component
class ReactiveListRepository {

    fun <T> listAllFromList(provider: ReactiveEntityProvider<List<T>>): Flux<T> {
        return Flux.fromIterable(provider.provide())
    }

    fun <T> inDifferentThreadRunListAll(provider: ReactiveEntityProvider<T>): Flux<T> {
        return Flux.create { sink ->
            Thread {
                var count = 0
                Thread.sleep(3000)
                while (count < 20) {
                    try {
                        if (Random.nextBoolean()) {
                            Thread.sleep(2000)
                        } else {
                            Thread.sleep(500)
                        }
                    } catch (exception: Exception) {
                        sink.error(exception)
                    }
                    sink.next(provider.provide()!!)
                    count++
                }
                sink.complete()
            }.start()
        }
    }

    fun <T> randomDelayedListAll(provider: ReactiveEntityProvider<T>): Flux<T> {
        return Flux.range(0, 20)
            .map {
                try {
                    if (Random.nextBoolean()) {
                        Thread.sleep(2000)
                    } else {
                        Thread.sleep(500)
                    }
                } catch (exception: Exception) {
                }

                provider.provide()
            }

    }
}
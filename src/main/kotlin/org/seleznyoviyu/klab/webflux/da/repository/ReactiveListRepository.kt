package org.seleznyoviyu.klab.webflux.da.repository

import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.util.function.Supplier
import kotlin.random.Random

@Component
class ReactiveListRepository {

    fun <T> listAllFromList(supplier: Supplier<List<T>>): Flux<T> {
        return Flux.fromIterable(supplier.get())
    }

    fun <T> inDifferentThreadRunListAll(supplier: Supplier<T>): Flux<T> {
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
                    sink.next(supplier.get()!!)
                    count++
                }
                sink.complete()
            }.start()
        }
    }

    fun <T> randomDelayedListAll(supplier: Supplier<T>): Flux<T> {
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

                supplier.get()
            }

    }
}
package org.seleznyoviyu.klab.webflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KLabWebfluxApplication

fun main(args: Array<String>) {
    runApplication<KLabWebfluxApplication>(*args)
}

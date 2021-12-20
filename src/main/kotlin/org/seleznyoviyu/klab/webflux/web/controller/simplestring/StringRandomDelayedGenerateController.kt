package org.seleznyoviyu.klab.webflux.web.controller.simplestring

import org.seleznyoviyu.klab.webflux.domain.service.simplestring.SimpleStringRandomDelayedListGenerateService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class StringRandomDelayedGenerateController(
    private val service: SimpleStringRandomDelayedListGenerateService
) {
    @GetMapping("/string/random-delayed-list-all", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun generate(): Flux<String> {
        return service.generate()
    }
}
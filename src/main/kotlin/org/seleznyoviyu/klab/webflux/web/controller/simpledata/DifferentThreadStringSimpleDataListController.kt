package org.seleznyoviyu.klab.webflux.web.controller.simpledata

import org.seleznyoviyu.klab.webflux.domain.service.simpledata.DifferentThreadStringSimpleDataListService
import org.seleznyoviyu.klab.webflux.web.json.simpledata.SimpleDataJson
import org.seleznyoviyu.klab.webflux.web.mapper.simpledata.StringSimpleDataJsonMapper
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class DifferentThreadStringSimpleDataListController(
    private val service: DifferentThreadStringSimpleDataListService,
    private val mapper: StringSimpleDataJsonMapper
) {
    //TODO: This code works incorrect, still waiting and waiting and waiting without any response
    @GetMapping("/simple-data/string/different-thread-random-delayed-list-all", produces = [MediaType.APPLICATION_NDJSON_VALUE])
    fun list(): Flux<SimpleDataJson<String>> {
        return service.list().map(mapper::map)
    }
}
package org.seleznyoviyu.klab.webflux.web.controller.simpledata

import org.seleznyoviyu.klab.webflux.domain.service.simpledata.StringSimpleDataRandomDelayedListService
import org.seleznyoviyu.klab.webflux.web.json.simpledata.SimpleDataJson
import org.seleznyoviyu.klab.webflux.web.mapper.simpledata.StringSimpleDataJsonMapper
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class StringSimpleDataRandomDelayedListController(
    private val service: StringSimpleDataRandomDelayedListService,
    private val mapper: StringSimpleDataJsonMapper
) {
    @GetMapping("/simple-data/string/random-delayed-list-all", produces = [MediaType.APPLICATION_NDJSON_VALUE])
    fun documentListAll(): Flux<SimpleDataJson<String>> {
        return service.list().map(mapper::map)
    }
}
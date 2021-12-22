package org.seleznyoviyu.klab.webflux.domain.service.simpledata

import org.seleznyoviyu.klab.webflux.da.repository.ReactiveListRepository
import org.seleznyoviyu.klab.webflux.domain.model.simpledata.SimpleData
import org.seleznyoviyu.klab.webflux.da.provider.StringSimpleDataEntityProvider
import org.seleznyoviyu.klab.webflux.domain.mapper.simpledata.StringSimpleDataMapper
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class StringSimpleDataRandomDelayedListService(
    private val repository: ReactiveListRepository,
    private val dataProvider: StringSimpleDataEntityProvider,
    private val mapper: StringSimpleDataMapper
) {
    fun list(): Flux<SimpleData<String>> {
        return repository.randomDelayedListAll(dataProvider).map(mapper::map)
    }
}
package org.seleznyoviyu.klab.webflux.domain.service.simpledata

import org.seleznyoviyu.klab.webflux.da.repository.ReactiveListRepository
import org.seleznyoviyu.klab.webflux.da.supplier.StringSimpleDataEntitySupplier
import org.seleznyoviyu.klab.webflux.domain.mapper.simpledata.StringSimpleDataMapper
import org.seleznyoviyu.klab.webflux.domain.model.simpledata.SimpleData
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class DifferentThreadStringSimpleDataListService(
    private val repository: ReactiveListRepository,
    private val supplier: StringSimpleDataEntitySupplier,
    private val mapper: StringSimpleDataMapper
) {
    fun list(): Flux<SimpleData<String>> {
        return repository.inDifferentThreadRunListAll(supplier).map(mapper::map)
    }
}
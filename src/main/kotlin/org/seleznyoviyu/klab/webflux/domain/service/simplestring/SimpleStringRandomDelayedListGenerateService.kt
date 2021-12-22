package org.seleznyoviyu.klab.webflux.domain.service.simplestring

import org.seleznyoviyu.klab.webflux.da.repository.ReactiveListRepository
import org.seleznyoviyu.klab.webflux.da.provider.RandomStringProvider
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class SimpleStringRandomDelayedListGenerateService(
    private val repository: ReactiveListRepository,
    private val stringProvider: RandomStringProvider
) {
    fun generate(): Flux<String> {
        return repository.randomDelayedListAll(stringProvider)
    }
}
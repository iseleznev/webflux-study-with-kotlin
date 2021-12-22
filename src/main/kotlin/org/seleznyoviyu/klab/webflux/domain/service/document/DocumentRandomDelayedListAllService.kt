package org.seleznyoviyu.klab.webflux.domain.service.document

import org.seleznyoviyu.klab.webflux.domain.model.document.Document
import org.seleznyoviyu.klab.webflux.da.repository.ReactiveListRepository
import org.seleznyoviyu.klab.webflux.da.supplier.DocumentEntityProvider
import org.seleznyoviyu.klab.webflux.domain.mapper.document.DocumentMapper
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class DocumentRandomDelayedListAllService(
    private val documentRepository: ReactiveListRepository,
    private val documentProvider: DocumentEntityProvider,
    private val mapper: DocumentMapper
) {
    fun listAll(): Flux<Document> {
        return documentRepository.randomDelayedListAll(documentProvider).map(mapper::map)
    }
}
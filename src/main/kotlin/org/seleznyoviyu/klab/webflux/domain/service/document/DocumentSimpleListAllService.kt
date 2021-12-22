package org.seleznyoviyu.klab.webflux.domain.service.document

import org.seleznyoviyu.klab.webflux.domain.model.document.Document
import org.seleznyoviyu.klab.webflux.da.repository.ReactiveListRepository
import org.seleznyoviyu.klab.webflux.da.provider.DocumentEntityListProvider
import org.seleznyoviyu.klab.webflux.domain.mapper.document.DocumentMapper
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class DocumentSimpleListAllService(
    private val documentRepository: ReactiveListRepository,
    private val documentListProvider: DocumentEntityListProvider,
    private val mapper: DocumentMapper
) {
    fun listAll(): Flux<Document> {
        return documentRepository.listAllFromList(documentListProvider).map(mapper::map)
    }
}
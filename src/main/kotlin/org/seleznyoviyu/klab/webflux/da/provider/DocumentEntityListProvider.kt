package org.seleznyoviyu.klab.webflux.da.provider

import org.seleznyoviyu.klab.webflux.da.entity.DocumentEntity
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class DocumentEntityListProvider(
    private val documentSupplier: DocumentEntityProvider
) : ReactiveEntityProvider<List<DocumentEntity>> {
    override fun provide(): List<DocumentEntity> {
        val count = Random.nextInt(100) + 3
        return (0..count).map { documentSupplier.provide() }
    }
}
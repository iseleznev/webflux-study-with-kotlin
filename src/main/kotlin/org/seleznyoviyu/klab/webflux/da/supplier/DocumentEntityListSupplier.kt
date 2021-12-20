package org.seleznyoviyu.klab.webflux.da.supplier

import org.seleznyoviyu.klab.webflux.da.entity.DocumentEntity
import org.springframework.stereotype.Service
import java.util.function.Supplier
import kotlin.random.Random

@Service
class DocumentEntityListSupplier(
    private val documentSupplier: DocumentEntitySupplier
) : Supplier<List<DocumentEntity>> {
    override fun get(): List<DocumentEntity> {
        val count = Random.nextInt(100) + 3
        return (0..count).map { documentSupplier.get() }
    }
}
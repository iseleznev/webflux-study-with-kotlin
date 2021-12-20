package org.seleznyoviyu.klab.webflux.domain.service

import org.junit.jupiter.api.Test
import org.seleznyoviyu.klab.webflux.da.supplier.DocumentEntitySupplier
import org.seleznyoviyu.klab.webflux.common.generate.MapGenerateService
import org.seleznyoviyu.klab.webflux.common.generate.StringGenerateService
import org.seleznyoviyu.klab.webflux.common.generate.UlidGenerateByCreatorService

internal class DocumentBuildServiceTest {

    @Test
    fun testGenerateDocument() {
        val stringGenerateService = StringGenerateService()
        val actual = DocumentEntitySupplier(
            UlidGenerateByCreatorService(),
            stringGenerateService,
            MapGenerateService(stringGenerateService)
        ).get()
        assert(actual != null)
        assert(actual.ulid != null)
        assert(actual.name != null)
        assert(actual.document != null)
    }
}
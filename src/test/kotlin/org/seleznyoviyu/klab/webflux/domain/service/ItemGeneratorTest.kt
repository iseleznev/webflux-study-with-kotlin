package org.seleznyoviyu.klab.webflux.domain.service

import org.junit.jupiter.api.Test
import org.seleznyoviyu.klab.webflux.common.generate.MapGenerateService
import org.seleznyoviyu.klab.webflux.common.generate.StringGenerateService

internal class ItemGeneratorTest {

    @Test
    fun testGenerateMapResult() {
        val actual = MapGenerateService(
            StringGenerateService()
        ).generateMap()
        assert(actual.isNotEmpty())
    }
}
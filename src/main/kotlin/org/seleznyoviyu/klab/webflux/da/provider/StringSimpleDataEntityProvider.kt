package org.seleznyoviyu.klab.webflux.da.provider

import org.seleznyoviyu.klab.webflux.common.util.capitalize
import org.seleznyoviyu.klab.webflux.da.entity.SimpleDataEntity
import org.seleznyoviyu.klab.webflux.common.generate.StringGenerateService
import org.springframework.stereotype.Component

@Component
class StringSimpleDataEntityProvider(
    private val stringGenerateService: StringGenerateService
) : ReactiveEntityProvider<SimpleDataEntity<String>> {
    override fun provide(): SimpleDataEntity<String> {
        return SimpleDataEntity(
            capitalize(stringGenerateService.generate())
        )
    }
}
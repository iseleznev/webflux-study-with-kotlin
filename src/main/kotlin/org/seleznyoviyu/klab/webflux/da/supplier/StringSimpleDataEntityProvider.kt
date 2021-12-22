package org.seleznyoviyu.klab.webflux.da.supplier

import org.seleznyoviyu.klab.webflux.common.util.capitalize
import org.seleznyoviyu.klab.webflux.da.entity.SimpleDataEntity
import org.seleznyoviyu.klab.webflux.common.generate.StringGenerateService
import org.springframework.stereotype.Component
import java.util.function.Supplier

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
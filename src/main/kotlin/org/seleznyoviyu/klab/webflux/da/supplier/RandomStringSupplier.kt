package org.seleznyoviyu.klab.webflux.da.supplier

import org.seleznyoviyu.klab.webflux.common.generate.StringGenerateService
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils.capitalize
import java.util.function.Supplier

@Component
class RandomStringSupplier(
    private val stringGenerateService: StringGenerateService
) : Supplier<String> {
    override fun get(): String {
        return capitalize(stringGenerateService.generate())
    }
}
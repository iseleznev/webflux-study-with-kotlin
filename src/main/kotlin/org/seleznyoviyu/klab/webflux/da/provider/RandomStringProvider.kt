package org.seleznyoviyu.klab.webflux.da.provider

import org.seleznyoviyu.klab.webflux.common.generate.StringGenerateService
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils.capitalize

@Component
class RandomStringProvider(
    private val stringGenerateService: StringGenerateService
) : ReactiveEntityProvider<String> {
    override fun provide(): String {
        return capitalize(stringGenerateService.generate())
    }
}
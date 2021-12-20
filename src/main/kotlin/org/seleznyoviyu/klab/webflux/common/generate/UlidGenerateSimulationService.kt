package org.seleznyoviyu.klab.webflux.common.generate

import org.springframework.stereotype.Service

@Service
class UlidGenerateSimulationService(
    private val stringGenerateService: StringGenerateService
) {
    fun generateUlid(): String {
        return stringGenerateService.generate()
    }
}
package org.seleznyoviyu.klab.webflux.common.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux

@EnableWebFlux
@Configuration
class ApplicationConfiguration {

    @Bean
    fun objectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.propertyNamingStrategy = PropertyNamingStrategies.KEBAB_CASE
        return objectMapper
    }
}
package org.seleznyoviyu.klab.webflux.web.mapper.simpledata

import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.seleznyoviyu.klab.webflux.domain.model.simpledata.SimpleData
import org.seleznyoviyu.klab.webflux.web.json.simpledata.SimpleDataJson

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
interface StringSimpleDataJsonMapper {
    fun map(source: SimpleData<String>): SimpleDataJson<String>
}
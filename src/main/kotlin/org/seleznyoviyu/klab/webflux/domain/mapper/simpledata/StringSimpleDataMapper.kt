package org.seleznyoviyu.klab.webflux.domain.mapper.simpledata

import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.seleznyoviyu.klab.webflux.da.entity.SimpleDataEntity
import org.seleznyoviyu.klab.webflux.domain.model.simpledata.SimpleData
import org.seleznyoviyu.klab.webflux.web.json.simpledata.SimpleDataJson

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
interface StringSimpleDataMapper {
    fun map(source: SimpleDataEntity<String>): SimpleData<String>
}
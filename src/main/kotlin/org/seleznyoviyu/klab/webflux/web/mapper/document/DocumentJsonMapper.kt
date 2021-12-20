package org.seleznyoviyu.klab.webflux.web.mapper.document

import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.seleznyoviyu.klab.webflux.domain.model.document.Document
import org.seleznyoviyu.klab.webflux.web.json.document.DocumentJson

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
interface DocumentJsonMapper {
    fun map(source: Document): DocumentJson
}
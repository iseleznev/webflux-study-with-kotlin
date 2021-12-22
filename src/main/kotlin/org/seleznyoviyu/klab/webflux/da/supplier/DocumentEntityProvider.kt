package org.seleznyoviyu.klab.webflux.da.supplier

import org.seleznyoviyu.klab.webflux.da.entity.DocumentEntity
import org.seleznyoviyu.klab.webflux.common.generate.MapGenerateService
import org.seleznyoviyu.klab.webflux.common.generate.StringGenerateService
import org.seleznyoviyu.klab.webflux.common.generate.UlidGenerateByCreatorService
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils.capitalize
import java.util.function.Supplier
import kotlin.random.Random

@Service
class DocumentEntityProvider(
    private val ulidGenerator: UlidGenerateByCreatorService,
    private val stringGenerateService: StringGenerateService,
    private val itemGenerator: MapGenerateService
) : ReactiveEntityProvider<DocumentEntity> {
    override fun provide(): DocumentEntity {
        return DocumentEntity(
            ulid = ulidGenerator.generateUlid(),
            title = capitalize(
                stringGenerateService.generate(
                    Random.nextInt(6) + 1
                )
            ),
            name = capitalize(stringGenerateService.generate()),
            document = itemGenerator.generateMap()
        )
    }
}
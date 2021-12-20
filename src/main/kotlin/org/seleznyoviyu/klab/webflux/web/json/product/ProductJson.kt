package org.seleznyoviyu.klab.webflux.web.json.product

import java.math.BigDecimal

data class ProductJson(
    val externalCode: String,
    val name: String,
    val description: String,
    val basePrice: BigDecimal,
    val actualPrice: BigDecimal,
    val minAcceptablePrice: BigDecimal,
    val category: String,
    val measureType: ProductMeasureUnitTypeJson
)

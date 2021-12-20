package org.seleznyoviyu.klab.webflux.domain.model.product

import java.math.BigDecimal

data class Product(
    val externalCode: String,
    val name: String,
    val description: String,
    val basePrice: BigDecimal,
    val actualPrice: BigDecimal,
    val minAcceptablePrice: BigDecimal,
    val category: String,
    val measureType: ProductMeasureUnitType
)

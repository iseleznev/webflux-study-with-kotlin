package org.seleznyoviyu.klab.webflux.domain.model.customer

import java.time.Instant

data class Customer(
    val externalCode: String,
    val firstName: String,
    val secondName: String,
    val surname: String,
    val patronymic: String,
    val contactInformation: Map<String, List<String>>,
    val birthday: Instant,
    val gender: CustomerGender,
    val additionalPersonalDescription: Map<String, Object>
)

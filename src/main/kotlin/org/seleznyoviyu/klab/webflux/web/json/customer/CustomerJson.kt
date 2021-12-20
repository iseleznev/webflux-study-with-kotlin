package org.seleznyoviyu.klab.webflux.web.json.customer

import java.time.Instant

data class CustomerJson(
    val externalCode: String,
    val firstName: String,
    val secondName: String,
    val surname: String,
    val patronymic: String,
    val contactInformation: Map<String, List<String>>,
    val birthday: Instant,
    val gender: CustomerGenderJson,
    val additionalPersonalDescription: Map<String, Any>
)

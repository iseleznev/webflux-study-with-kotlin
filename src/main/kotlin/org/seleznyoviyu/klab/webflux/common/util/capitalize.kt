package org.seleznyoviyu.klab.webflux.common.util

import java.util.*

fun capitalize(source: String): String {
    return source.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}
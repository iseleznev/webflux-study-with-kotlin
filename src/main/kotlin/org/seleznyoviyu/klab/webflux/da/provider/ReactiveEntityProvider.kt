package org.seleznyoviyu.klab.webflux.da.provider

interface ReactiveEntityProvider<T> {
    fun provide(): T
}
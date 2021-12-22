package org.seleznyoviyu.klab.webflux.da.supplier

interface ReactiveEntityProvider<T> {
    fun provide(): T
}
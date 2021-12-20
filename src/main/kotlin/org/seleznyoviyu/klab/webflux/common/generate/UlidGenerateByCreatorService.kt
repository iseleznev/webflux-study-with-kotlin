package org.seleznyoviyu.klab.webflux.common.generate

import com.github.f4b6a3.ulid.UlidCreator
import org.springframework.stereotype.Service

@Service
class UlidGenerateByCreatorService {
    fun generateUlid(): String {
        return UlidCreator.getUlid().toString()
    }
}
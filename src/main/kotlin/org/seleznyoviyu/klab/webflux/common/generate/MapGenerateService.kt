package org.seleznyoviyu.klab.webflux.common.generate

import org.springframework.stereotype.Service
import org.springframework.util.StringUtils.capitalize
import kotlin.random.Random

@Service
class MapGenerateService(
    private val stringGenerateService: StringGenerateService
) {

    companion object {
        private const val MAX_DEEP_SIZE = 6
        private const val FIELD_COMPOSITE_TYPE_PROBABILITY = 4
        private const val NON_OFTEN_TYPE_PROBABILITY = 3
        private const val MAX_MAP_KEYS_COUNT = 11
        private const val MAX_LIST_SIZE = 8
        private const val MAX_INT_FIELD_VALUE = 1000
    }

    fun generateMap(): Map<String, Any> {
        return generateMap(0)
    }

    fun generateList(): List<Any> {
        return generateList(0)
    }

    private fun generateMap(deep: Int): Map<String, Any> {
        return (0..Random.nextInt(MAX_MAP_KEYS_COUNT) + 1).map {
            val type =
                if (deep < MAX_DEEP_SIZE) Random.nextInt(FIELD_COMPOSITE_TYPE_PROBABILITY) else FIELD_COMPOSITE_TYPE_PROBABILITY
            val subtype = Random.nextInt(NON_OFTEN_TYPE_PROBABILITY)
            when (type) {
                0 -> when (subtype) {
                    0 -> generateList(deep + 1)
                    else -> generateMap(deep + 1)
                }
                else -> {
                    when (subtype) {
                        0 -> Random.nextInt(MAX_INT_FIELD_VALUE)
                        else -> stringGenerateService.generate()
                    }
                }
            }
        }.associateBy {
            capitalize(stringGenerateService.generate())
        }
    }

    private fun generateList(deep: Int): List<Any> {
        val type =
            if (deep < MAX_DEEP_SIZE) Random.nextInt(FIELD_COMPOSITE_TYPE_PROBABILITY) else FIELD_COMPOSITE_TYPE_PROBABILITY
        val subtype = Random.nextInt(NON_OFTEN_TYPE_PROBABILITY)
        return (0..Random.nextInt(MAX_LIST_SIZE)).map {
            when (type) {
                0 -> when (subtype) {
                    0 -> generateList(deep + 1)
                    else -> generateMap(deep + 1)
                }
                else -> when (subtype) {
                    0 -> Random.nextInt(MAX_INT_FIELD_VALUE)
                    else -> stringGenerateService.generate()
                }
            }
        }
    }
}
package org.seleznyoviyu.klab.webflux.common.generate

import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class StringGenerateService {

    companion object {
        private val CONSONANT_LETTERS = arrayOf("b", "c", "ch", "ck", "d", "f", "g", "gh", "h", "j", "k", "kh", "l", "m", "n", "p", "ph", "q", "r", "s", "sh", "t", "v", "w", "x", "z")
        private val VOWEL_LETTERS = arrayOf("a", "e", "ee", "i", "o", "ou", "u", "y")
        private val LAST_CONSONANT_LETTERS =
            arrayOf("b", "c", "ch", "ck", "d", "f", "g", "gh", "h", "k", "l", "m", "n", "p", "r", "s", "sh", "t")
        private val LAST_VOWEL_LETTERS = arrayOf("e", "ee", "ou", "y")
    }

    fun generate(wordsCount: Int): String {
        val sentence = StringBuilder()
        (0..wordsCount).forEach { wordIndex ->
            if (wordIndex != 0) {
                sentence.append(" ")
            }
            sentence.append(generate())
        }
        return sentence.toString()
    }

    fun generate(): String {
        val size = if (Random.nextInt(5) == 0) Random.nextInt(2) + 3 else Random.nextInt(4) + 5
        val word = StringBuilder()
        var previousIsVowel = false
        for (i in 0..size) {
            if ((i == 0 && Random.nextBoolean()) || !previousIsVowel) {
                word.append(vowelLetter(i, size))
                previousIsVowel = true
            } else {
                word.append(consonantLetter(i, size))
                previousIsVowel = false
            }
        }

        return word.toString()
    }

    private fun consonantLetter(index: Int, maxSize: Int): String {
        if (index == maxSize) {
            return LAST_CONSONANT_LETTERS[Random.nextInt(LAST_CONSONANT_LETTERS.size)]
        }
        return CONSONANT_LETTERS[Random.nextInt(CONSONANT_LETTERS.size)]
    }

    private fun vowelLetter(index: Int, maxSize: Int): String {
        if (index == maxSize) {
            return LAST_VOWEL_LETTERS[Random.nextInt(LAST_VOWEL_LETTERS.size)]
        }
        return VOWEL_LETTERS[Random.nextInt(VOWEL_LETTERS.size)]
    }
}
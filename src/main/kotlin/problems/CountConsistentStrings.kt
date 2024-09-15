package com.ridneto.problems

class CountConsistentStrings {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        val map = buildMap(allowed)
        var count = 0
        words.forEach pai@{ word ->
            word.forEach { c ->
                if(!map[c.code]!!){
                    return@pai
                }
            }
            count++
        }
        return count
    }

    private fun buildMap(allowed: String): Map<Int, Boolean> {
        val map = HashMap<Int, Boolean>(26)
        for (i in 97..122) {
            map[i] = false
        }
        allowed.forEach { map[it.code] = true }
        return map
    }
}
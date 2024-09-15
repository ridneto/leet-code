package com.ridneto.problems

class LongestSubstringWithoutRepeatingCharacters {
    companion object {
        fun run(){
            val a = LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba")
            val e = LongestSubstringWithoutRepeatingCharacters().donkeyLengthOfLongestSubstring("abba")


            val asd = LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(" ")
            val faef4 = LongestSubstringWithoutRepeatingCharacters().donkeyLengthOfLongestSubstring(" ")

            val b = ""
        }
    }

    fun lengthOfLongestSubstring(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        var start = 0
        var bigger = 0

        s.forEachIndexed { index, c ->
            map[c]?.let { indexFirstOccurrence ->
                if(indexFirstOccurrence < start) {
                    return@let // o caracter eh novo na substring atual
                }
                if((index - start) > bigger) {
                    bigger = (index - start)
                }
                start = indexFirstOccurrence +1
            }

            map[c] = index
        }

        return Math.max((s.length-start), bigger)
    }

    fun donkeyLengthOfLongestSubstring(s: String): Int {
        if(s == "") {
            return 0
        }

        var map = newMap()
        var bigger = 0
        var currentSize = 0

        var index = 0
        do {
            if(map[s[index].code] != null) {
                if(currentSize > bigger) {
                    bigger = currentSize
                }

                if(s[index] != s[index-1]) {
                    index = map[s[index].code]!!+1
                }

                currentSize=1
                map = newMap()
                map[s[index].code] = index
                index++
            } else {
                currentSize++
                map[s[index].code] = index
                index++
            }
        }while(index <= s.lastIndex)

        return if(currentSize > bigger) currentSize else bigger
    }

    private fun newMap(): HashMap<Int, Int?> {
        val map = hashMapOf<Int, Int?>()
        for(i in 0..150) {
            map[i] = null
        }
        return map
    }
}
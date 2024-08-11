package com.ridneto.problems

class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        var index = s.lastIndex
        var result = 0

        do {
            if(s[index] != ' '){
                result++
            }

            index--
        } while(index >= 0 && (s[index] != ' ' || result == 0))

        return result
    }
}
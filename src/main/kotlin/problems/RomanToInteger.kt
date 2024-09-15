package com.ridneto.problems

class RomanToInteger {
    private val mapValues = mutableMapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )

    fun romanToInt(s: String): Int {
        var totalSum = 0
        var index = 0
        do {
            if(index == s.lastIndex){
                totalSum+=mapValues[s[index]]!!
                break
            }

            if(mapValues[s[index]]!! < mapValues[s[index+1]]!!) {
                totalSum+=mapValues[s[index+1]]!!-mapValues[s[index]]!!
                index+=2
                continue
            }

            totalSum+=mapValues[s[index]]!!
            index++
        } while(index<=s.lastIndex)

        return totalSum
    }
}
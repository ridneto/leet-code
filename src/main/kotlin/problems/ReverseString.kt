package com.ridneto.problems

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        var r = s.size-1
        var l = 0
        while(r > l) {
            val t = s[r]
            s[r] = s[l]
            s[l] = t

            l++
            r--
        }
    }
}
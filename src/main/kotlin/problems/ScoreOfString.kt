package com.ridneto.problems

import kotlin.math.abs

class ScoreOfString {
    companion object {
        fun run(){
            val b = ScoreOfString().scoreOfString("hello")
        }
    }

    fun scoreOfString(s: String): Int {
        var score = 0
        for(i in 0..< s.length - 1) {
            score+=abs(s[i].code - s[i + 1].code)
        }
        return score
    }
}
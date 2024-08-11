package com.ridneto.problems

class KidsWithTheGreatestNumberOfCandies {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val max = candies.max()
        return candies.map { it+extraCandies > max }
    }
}
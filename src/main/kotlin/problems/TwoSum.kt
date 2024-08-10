package com.ridneto.problems

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val mapValues = hashMapOf<Int, Int>()

        for(i in nums.indices) {
            if(mapValues.containsKey(nums[i])) {
                return intArrayOf(i, mapValues[nums[i]]!!)
            }
            mapValues[target - nums[i]] = i
        }

        return intArrayOf()
    }
}
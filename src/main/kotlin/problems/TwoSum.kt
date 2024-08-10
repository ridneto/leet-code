package com.ridneto.problems

class TwoSum {

    companion object {
        fun test(){
            val b = TwoSum().twoSum(intArrayOf(9,5,1234,402394,230), 239)
            val c = ""
        }
    }

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

    fun otherTwoSum(nums: IntArray, target: Int): IntArray {
        val mapValues = hashMapOf<Int, Int>()

        nums.forEachIndexed { index, number ->
            val c = target - number
            mapValues[c]?.let {
                return intArrayOf(index, it)
            }
            mapValues[number] = index
        }

        return intArrayOf()
    }
}
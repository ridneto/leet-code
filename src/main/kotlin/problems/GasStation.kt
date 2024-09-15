package com.ridneto.problems

class GasStation {
    companion object {
        fun run() {
            val a = GasStation().canCompleteCircuit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2))
            val b = GasStation().canCompleteCircuit(intArrayOf(2,3,4), intArrayOf(3,4,3))
            ""
        }
    }

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var start = 0
        var carry = 0
        for(i in gas.indices) {
            val delta = gas[i] - cost[i] + carry
            if(delta >= 0) {
                carry += delta
            } else {
                carry = 0
                start = i+1
            }
        }

        return if(start > gas.size) -1 else start
    }
}
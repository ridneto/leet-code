package com.ridneto.problems

class PascalsTriangle {
    companion object {
        fun run(){
            val b = PascalsTriangle().generate(5).toString()
            val c = ""
        }
    }

    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        val startValue = 1

        var levelRow = 0
        do {
            val levelTriangle = mutableListOf<Int>()
            var indexColumn = 0
            do {
                if(indexColumn == 0 || indexColumn == levelRow) {
                    levelTriangle.add(startValue)
                } else {
                    levelTriangle.add(result[levelRow-1][indexColumn-1]+result[levelRow-1][indexColumn])
                }
                indexColumn++
            } while(indexColumn<=levelRow)
            result.add(levelTriangle)
            levelRow++
        } while(levelRow < numRows)

        return result
    }
}
package com.ridneto.problems

class AddTwoNumbers {
    companion object {
        private fun make(list: IntArray): ListNode {
            var result: ListNode? = null
            var head: ListNode? = null
            list.forEach{
                if(result == null) {
                    result = ListNode(it)
                    head = result
                    return@forEach
                }

                head!!.next = ListNode(it)
                head = head!!.next
            }
            return result!!
        }

        fun run(): ListNode? {
            //AddTwoNumbers().addTwoNumbers(
            //    make(intArrayOf(2, 4, 3)),
            //    make(intArrayOf(5, 6, 4)),
            //)

            return AddTwoNumbers().addTwoNumbers(
                make(intArrayOf(9,9,9,9,9,9,9)),
                make(intArrayOf(9,9,9,9)),
            )
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        fun makeStr(l: ListNode?): String{
            var headList = l
            var r = ""
            while(headList != null) {
                r = "${headList.`val`}$r"
                headList = headList.next
            }
            return r
        }

        fun data(): Triple<Int, String, String>{
            val r1 = makeStr(l1)
            val r2 = makeStr(l2)

            val max = maxOf(r1.length, r2.length)

            val pad1 = r1.padStart(max, '0')
            val pad2 = r2.padStart(max, '0')

            return Triple(max, pad1, pad2)
        }

        val (max, pad1, pad2) = data()

        var output: ListNode? = null
        var head: ListNode? = null

        var resto = 0
        for(i in max - 1 downTo 0) {
            val v1 = pad1[i].toString().toInt()
            val v2 = pad2[i].toString().toInt()

            val calcIn = v1 + v2 + resto
            resto = calcIn / 10

            if(output == null) {
                output = ListNode(calcIn % 10)
                head = output
                continue
            }

            head!!.next = ListNode(calcIn % 10)
            head = head.next
        }

        if(resto > 0) {
            head!!.next = ListNode(resto)
        }

        return output
    }
}
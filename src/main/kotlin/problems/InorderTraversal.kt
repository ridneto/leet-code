package com.ridneto.problems

import com.sun.source.tree.Tree

class InorderTraversal {

    companion object {
        fun run(){
            val root = TreeNode(1)
            root.right = TreeNode(2)
            root.right!!.left = TreeNode(3)
            val b = InorderTraversal().inorderTraversal(root)
            ""
        }
    }

    // recursive
    fun inorderTraversal(root: TreeNode): List<Int> {
        return processNode(mutableListOf(), root)
    }

    private fun processNode(loaded: MutableList<Int>, node: TreeNode?): MutableList<Int>{
        if(node == null) {
            return loaded
        }
        processNode(loaded, node.left)
        loaded.add(node.`val`)
        processNode(loaded, node.right)
        return loaded
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
package util

object Edges {

    @JvmStatic
    fun isSquare(vertex: Int, candidate: Int): Boolean {
        val sum = vertex + candidate
        val root = Math.sqrt(sum.toDouble())
        return root == Math.ceil(root)
    }
}

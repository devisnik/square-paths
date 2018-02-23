public class Edges {

    static boolean isSquare(int vertex, int candidate) {
        int sum = vertex + candidate;
        double root = Math.sqrt(sum);
        return root == Math.ceil(root);
    }
}

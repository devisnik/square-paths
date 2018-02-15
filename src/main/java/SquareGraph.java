import java.util.stream.IntStream;

public class SquareGraph {
    final int number;

    private int[][] edges;

    public SquareGraph(int number) {
        this.number = number;
        edges = new int[number][];
        IntStream.range(0, number).forEach(vertex -> {
            edges[vertex] = IntStream
                    .rangeClosed(1, number)
                    .map(v -> number - v)
                    .filter(v -> v != vertex)
                    .filter(v -> isSquare(vertex, v))
                    .map(v -> v + 1)
                    .toArray();
        });
    }

    private static boolean isSquare(int vertex, int candidate) {
        int sum = vertex + 1 + candidate + 1;
        double root = Math.sqrt(sum);
        return root == Math.ceil(root);
    }

    public int[] getNeighbors(int vertex) {
        return edges[vertex - 1];
    }

    public int degree(int vertex) {
        return edges[vertex - 1].length;
    }
}

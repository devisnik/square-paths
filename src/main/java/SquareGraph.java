import java.util.ArrayList;
import java.util.List;

public class SquareGraph {
    final int number;

    private int[][] edges;

    public SquareGraph(int number) {
        this.number = number;
        edges = new int[number][];
        for (int vertex = 0; vertex < number; vertex++) {
            List<Integer> neighbors = new ArrayList<>();
            for (int candidate = number - 1; candidate >= 0; candidate--) {
                if (vertex == candidate) continue;
                int sum = vertex + 1 + candidate + 1;
                double root = Math.sqrt(sum);
                boolean isSquare = root == Math.ceil(root);
                if (isSquare) neighbors.add(candidate);
            }
            edges[vertex] = neighbors.stream().mapToInt(v -> v + 1).toArray();
        }
    }

    public int[] getNeighbors(int vertex) {
        return edges[vertex - 1];
    }

    public int degree(int vertex) {
        return edges[vertex - 1].length;
    }
}

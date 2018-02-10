import java.util.*;

public class Pathfinder {

    private final SquareGraph graph;

    Pathfinder(int number) {
        graph = new SquareGraph(number);
    }

    public List<Integer> search() {
        ArrayList<Integer> nodesByDegree = new ArrayList<>();
        for (int i = 1; i <= graph.number; i++) {
            nodesByDegree.add(i);
        }
        Collections.sort(nodesByDegree, new Comparator<Integer>() {
            @Override
            public int compare(Integer left, Integer right) {
                return graph.degree(left) - graph.degree(right);
            }
        });

        System.out.println("tackling number = " + graph.number);
        for (int vertex : nodesByDegree) {
            System.out.println("starting fresh with vertext: " + vertex);
            Path path = new Path(graph.number);
            path.add(vertex);
            if (extend(path))
                return path.toList();
        }
        return Collections.emptyList();
    }

    private boolean extend(Path path) {
        if (path.isHamiltonian()) {
            return true;
        }
        for (int neighbor : graph.getNeighbors(path.last())) {
            if (path.contains(neighbor)) continue;
            path.add(neighbor);
            if (extend(path)) {
                return true;
            } else {
                path.removeLast();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for (int number = 15; number < 60; number++) {
            System.out.println(number + ": " + new Pathfinder(number).search());
        }
    }

}

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
            List<Integer> path = new LinkedList<>();
            path.add(vertex);
            if (extend(path))
                return path;
        }
        return Collections.emptyList();
    }

    private boolean extend(List<Integer> path) {
        if (path.size() == graph.number) {
            return true;
        }
        for (int neighbor : graph.getNeighbors(path.get(0))) {
            if (path.contains(neighbor)) continue;
            path.add(0, neighbor);
            if (extend(path)) {
                return true;
            } else {
                path.remove(0);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for (int number = 15; number < 100; number++) {
            System.out.println(number + ": " + new Pathfinder(number).search());
        }
    }

}

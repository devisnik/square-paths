import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Pathfinder {

    private final SquareGraph graph;
    private long startTimestamp;

    Pathfinder(int number) {
        graph = new SquareGraph(number);
    }

    public List<Integer> search() {
        ArrayList<Integer> nodesByDegree = new ArrayList<>();
        for (int i = 1; i <= graph.number; i++) {
            nodesByDegree.add(i);
        }

        for (int vertex : nodesByDegree) {

            startTimestamp = System.currentTimeMillis();

            Path path = new Path(graph.number);
            path.append(vertex);
            if (extend(path))
                return path.toList();
        }
        return Collections.emptyList();
    }

    private boolean extend(Path path) {
        if (path.isHamiltonian() && path.canBeClosed()) {
            return true;
        }

        if (System.currentTimeMillis() - startTimestamp > TimeUnit.MILLISECONDS.toMillis(100)) {
            return false;
        }

        for (int neighbor : graph.getNeighbors(path.last())) {
            if (path.contains(neighbor)) continue;
            path.append(neighbor);
            if (extend(path)) {
                return true;
            } else {
                path.removeLast();
            }
        }
        return false;
    }

}

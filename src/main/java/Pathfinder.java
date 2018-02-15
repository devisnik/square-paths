import java.time.Instant;
import java.util.Collections;
import java.util.List;

public class Pathfinder {

    private final SquareGraph graph;
    private Instant endTime;

    Pathfinder(int number) {
        graph = new SquareGraph(number);
    }

    public List<Integer> search() {
        for (int vertex = 1; vertex <= graph.number; vertex++) {

            // we give up for each vertex after some short time period,
            // turns out it is long enough for some vertex eventually
            endTime = Instant.now().plusMillis(100);

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

        if (Instant.now().isAfter(endTime)) return false;

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

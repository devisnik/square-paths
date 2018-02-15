import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Verifier {

    private final List<Integer> nodes;

    Verifier(int... path) {
        nodes = IntStream.of(path).boxed().collect(Collectors.toList());
    }

    boolean isHamiltonianPath() {
        boolean allNodes = IntStream.rangeClosed(1, nodes.size()).allMatch(v -> nodes.contains(v));
        boolean allSquares = IntStream.range(0, nodes.size() -1).allMatch(v -> isSquare(nodes.get(v) + nodes.get(v + 1)));
        return allNodes && allSquares;
    }

    boolean isHamiltonianCycle() {
        int number = nodes.size();
        return isHamiltonianPath() && isSquare(nodes.get(0) + nodes.get(number - 1));
    }

    private boolean isSquare(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt == Math.ceil(sqrt);
    }
}

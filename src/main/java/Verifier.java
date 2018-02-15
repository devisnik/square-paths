import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Verifier {

    private final List<Integer> nodes;

    Verifier(int... path) {
        nodes = IntStream.of(path).boxed().collect(Collectors.toList());
    }

    boolean isHamiltonianPath() {
        int number = nodes.size();
        for (int i = 1; i <= number; i++) {
            if (!nodes.contains(i)) return false;
        }
        for (int i = 0; i < number - 1; i++) {
            if (!isSquare(nodes.get(i) + nodes.get(i + 1)))
                return false;
        }
        return true;
    }

    boolean isHamiltonianCycle() {
        if (!isHamiltonianPath()) return false;
        int number = nodes.size();
        if (!isSquare(nodes.get(0) + nodes.get(number - 1)))
            return false;
        return true;
    }

    private boolean isSquare(int number) {
        return Math.sqrt(number) == Math.ceil(Math.sqrt(number));
    }
}

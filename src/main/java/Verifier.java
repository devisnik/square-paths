import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.List;

public class Verifier {

    private final List<Integer> nodes;

    Verifier(int... path) {
        nodes = Ints.asList(path);
    }

    boolean isHamiltonianPath(int number) {
        if (!(nodes.size() == number)) return false;
        for (int i = 1; i <= number; i++) {
            if (!nodes.contains(i)) return false;
        }
        for (int i = 0; i < number - 1; i++) {
            if (!isSquare(nodes.get(i) + nodes.get(i + 1)))
                return false;
        }
        return true;
    }

    boolean isHamiltonianCycle(int number) {
        if (!(nodes.size() == number)) return false;
        for (int i = 1; i <= number; i++) {
            if (!nodes.contains(i)) return false;
        }
        for (int i = 0; i < number - 1; i++) {
            if (!isSquare(nodes.get(i) + nodes.get(i + 1)))
                return false;
        }
        if (!isSquare(nodes.get(0) + nodes.get(number - 1)))
            return false;
        return true;
    }

    private boolean isSquare(int number) {
        return Math.sqrt(number) == Math.ceil(Math.sqrt(number));
    }
}

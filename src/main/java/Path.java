import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Path {

    private final int number;
    private final int[] nodes;
    private int currentTop = -1;
    private boolean[] included;

    Path(int number) {
        this.number = number;
        nodes = new int[number];
        included = new boolean[number];
    }

    public void append(int node) {
        if (included[node - 1])
            throw new IllegalStateException("vertex already in path: " + node);
        currentTop += 1;
        nodes[currentTop] = node;
        included[node - 1] = true;
    }

    public void removeLast() {
        Integer node = nodes[currentTop];
        included[node - 1] = false;
        currentTop -= 1;
    }

    public int last() {
        return nodes[currentTop];
    }

    public boolean isHamiltonian() {
        return currentTop == number - 1;
    }

    public boolean canBeClosed() {
        return isSquare(nodes[0] + nodes[currentTop]);
    }

    private boolean isSquare(int number) {
        return Math.sqrt(number) == Math.ceil(Math.sqrt(number));
    }

    public int length() {
        return currentTop + 1;
    }

    public boolean contains(int neighbor) {
        return included[neighbor - 1];
    }

    public List<Integer> toList() {
        return IntStream.of(nodes).boxed().collect(Collectors.toList());
    }
}

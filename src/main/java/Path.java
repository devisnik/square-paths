import com.google.common.primitives.Ints;

import java.util.List;

public class Path {

    private final int[] nodes;
    private int currentTop = -1;
    private int number;
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
        return Ints.asList(nodes);
    }
}

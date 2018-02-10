import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Path {

    private final List<Integer> nodes;
    private int number;
    private boolean[] included;

    Path(int number) {
        this.number = number;
        nodes = new LinkedList<Integer>();
        included = new boolean[number];
    }

    public void add(int node) {
        if (included[node - 1])
            throw new IllegalStateException("vertex already in path: " + node);
        nodes.add(0, node);
        included[node - 1] = true;
    }

    public void removeLast() {
        Integer node = nodes.remove(0);
        included[node - 1] = false;
    }

    public int last() {
        return nodes.get(0);
    }

    public boolean isHamiltonian() {
        return nodes.size() == number;
    }

    public int length() {
        return nodes.size();
    }

    public boolean contains(int neighbor) {
        return included[neighbor-1];
    }

    public List<Integer> toList() {
        return Lists.newArrayList(nodes);
    }
}

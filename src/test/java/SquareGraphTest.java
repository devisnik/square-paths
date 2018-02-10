import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.apache.commons.math3.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SquareGraphTest {

    @Test
    public void createGraph() {
        new SquareGraph(15);
    }

    @Test
    public void knowsEdgesForNode() {
        SquareGraph graph = new SquareGraph(15);

        assertArrayEquals(new int[]{3, 8, 15}, graph.getNeighbors(1));
        assertArrayEquals(new int[]{2, 9}, graph.getNeighbors(7));
        assertArrayEquals(new int[]{7}, graph.getNeighbors(9));
        assertArrayEquals(new int[]{1, 10}, graph.getNeighbors(15));
    }

    @Test
    public void knowsDegreeOfVertex() {
        SquareGraph graph = new SquareGraph(15);

        assertEquals(3, graph.degree(1));
        assertEquals(1, graph.degree(9));
        assertEquals(2, graph.degree(15));
    }
}

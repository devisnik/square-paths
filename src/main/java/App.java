import java.util.List;

public class App {

    public static void main(String[] args) {
        for (int number = 32; number <= 10_000; number++) {
            SquareGraph graph = new SquareGraph(number);
            boolean done = false;
            int searchDurationMs = 1;
            while (!done) {
                searchDurationMs *= 2;
                List<Integer> solution = new Pathfinder(graph).search(searchDurationMs);
                boolean verified = !solution.isEmpty() && new Verifier(asArray(solution)).isHamiltonianCycle(number);
                done = verified || searchDurationMs >= 1000;
                if (done) {
                    System.out.print(number + ", ");
                    System.out.print(solution);
                    System.out.println();
                    if (!verified) {
                        throw new IllegalStateException("no solution found for number " + number);
                    }
                }
            }
        }
    }

    private static int[] asArray(List<Integer> integerList) {
        return integerList.stream().mapToInt(i -> i).toArray();
    }

}

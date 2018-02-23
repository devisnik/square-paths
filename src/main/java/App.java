import java.util.List;

public class App {

    public static void main(String[] args) {
        for (int number = 32; number <= 10000; number++) {
            SquareGraph graph = new SquareGraph(number);
            List<Integer> solution = new Pathfinder(graph).search(100);
            boolean verified = new Verifier(asArray(solution)).isHamiltonianCycle();
            if (!verified) {
                System.out.println(solution);
                throw new IllegalStateException("invalid solution for number " + number);
            }
            System.out.print(number + ", ");
//            System.out.println(solution);
            if (number % 31 == 0)
                System.out.println();
        }
    }

    private static int[] asArray(List<Integer> integerList) {
        return integerList.stream().mapToInt(i -> i).toArray();
    }

}

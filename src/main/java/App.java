import java.util.List;

public class App {

    public static void main(String[] args) {
        for (int number = 32; number <= 1000; number++) {
            List<Integer> solution = new Pathfinder(number).search();
            boolean verified = new Verifier(asArray(solution)).isHamiltonianCycle(number);
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
        int[] array = new int[integerList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = integerList.get(i);
        }
        return array;
    }

}

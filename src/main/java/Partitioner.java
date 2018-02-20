import java.util.stream.IntStream;

/**
 * In how many ways can we write n*(n+1) as sum of n squares, each smaller than 2*n ?
 *
 * Note: The edges of a hamiltonian square-cycle form such a configuration.
 */
public class Partitioner {
    private final int number;
    private final int[] parts;

    public Partitioner(int number) {
        this.number = number;
        parts = IntStream.range(2, 2 * number - 1).filter(this::isSquare).toArray();
    }

    public static void main(String[] args) {
        for (int i = 5; i < 70; i++) {
            new Partitioner(i).interate();
        }
    }

    private boolean isSquare(int number) {
        double root = Math.sqrt(number);
        return Math.ceil(root) == Math.floor(root);
    }

    public void interate() {
        int[] factors = new int[parts.length];
        int[] limits = IntStream.of(parts).map(n -> Math.min((int) ((n + 1) / 2), number)).toArray();
        int counter = 0;
        int factorSum = 0;
        do {
            for (int index = 0; index < factors.length; index++) {
                int factor = factors[index];
                int limit = limits[index];
                factorSum -= factor;
                factors[index] += 1;
                factors[index] %= limit;
                factorSum += factors[index];
                if (factorSum > number) {
                    factorSum -= factors[index];
                    factors[index] = 0;
                }
                if (factors[index] != 0) break;
            }
            if (factorSum == number) {
                int sum = IntStream.range(0, parts.length).map(index -> parts[index] * factors[index]).sum();
                if (sum == (number * (number + 1))) {
//                System.out.println(sum + ": " + IntStream.of(factors).boxed().collect(Collectors.toList()));
                    counter++;
                }
            }
        }
        while (factorSum != 0);
        System.out.println(number + ": " + counter);
    }
}

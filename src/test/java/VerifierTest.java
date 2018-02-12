import org.junit.Test;

import static org.junit.Assert.*;

public class VerifierTest {

    @Test
    public void verifiedNonHamiltonianPath() {
        Verifier verifier = new Verifier(1, 2, 3, 4);

        assertFalse(verifier.isHamiltonianPath(4));
    }

    @Test
    public void verifiesPathInSolution15() {
        Verifier verifier = new Verifier(9, 7, 2, 14, 11, 5, 4, 12, 13, 3, 6, 10, 15, 1, 8);

        assertTrue(verifier.isHamiltonianPath(15));
    }

    @Test
    public void verifiesNoCycleInSolution15() {
        Verifier verifier = new Verifier(9, 7, 2, 14, 11, 5, 4, 12, 13, 3, 6, 10, 15, 1, 8);

        assertFalse(verifier.isHamiltonianCycle(15));
    }

    @Test
    public void verifiesCycleInSolution83() {
        Verifier verifier = new Verifier(
                50, 14, 2, 7, 9, 16, 20, 5, 4, 12, 13, 3, 1, 8, 17, 19, 6, 10, 15, 21, 28, 72,
                49, 32, 68, 53, 11, 70, 51, 30, 34, 47, 74, 26, 55, 66, 78, 22, 27, 37, 44,
                56, 25, 39, 42, 79, 65, 35, 29, 52, 69, 75, 46, 54, 67, 77, 23, 58, 63, 81,
                40, 60, 61, 83, 38, 43, 57, 24, 76, 45, 36, 64, 80, 41, 59, 62, 82, 18, 31,
                33, 48, 73, 71);

        assertTrue(verifier.isHamiltonianCycle(83));
    }

    @Test
    public void verifiesCycleInSolution86() {
        Verifier verifier = new Verifier(
                9, 16, 20, 5, 4, 12, 13, 3, 1, 8, 17, 19, 6, 10, 15, 21,
                28, 36, 45, 55, 26, 74, 47, 53, 11, 70, 51, 30, 34, 66, 78, 22, 27, 37, 44,
                56, 25, 39, 42, 79, 65, 35, 86, 83, 61, 60, 84, 85, 59, 41, 80, 64, 57, 43,
                38, 62, 82, 18, 7, 2, 14, 50, 31, 33, 48, 73, 71, 29, 52, 69, 75, 46, 54,
                67, 77, 23, 58, 63, 81, 40, 24, 76, 68, 32, 49, 72);

        assertTrue(verifier.isHamiltonianCycle(86));
    }
}
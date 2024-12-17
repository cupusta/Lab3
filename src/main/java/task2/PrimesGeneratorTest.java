package task2;

import java.util.Iterator;

public class PrimesGeneratorTest {

    public void runTest(int n) {
        PrimesGenerator primesGenerator = new PrimesGenerator(n);

        for (int prime : primesGenerator) {
            System.out.print(prime + " ");
        }
        System.out.println();

        Iterator<Integer> reverseIterator = primesGenerator.reverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.print(reverseIterator.next() + " ");
        }
        System.out.println();
    }
}


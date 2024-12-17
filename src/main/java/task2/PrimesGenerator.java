package task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PrimesGenerator implements Iterable<Integer> {
    private final int n;
    private final List<Integer> primes;

    public PrimesGenerator(int n) {
        this.n = n;
        this.primes = new ArrayList<>();
        generatePrimes();
    }

    private void generatePrimes() {
        int num = 2;
        while (primes.size() < n) {
            if (isPrime(num)) {
                primes.add(num);
            }
            num++;
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return primes.iterator();
    }

    public Iterator<Integer> reverseIterator() {
        return new Iterator<>() {
            private int currentIndex = primes.size() - 1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public Integer next() {
                return primes.get(currentIndex--);
            }
        };
    }
}


package task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzz {
    private int n;
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz() {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                queue.offer("fizz");
            }
        }
    }

    public void buzz() {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                queue.offer("buzz");
            }
        }
    }

    public void fizzbuzz() {
        for (int i = 15; i <= n; i += 15) {
            queue.offer("fizzbuzz");
        }
    }

    public void number() {
        for (int i = 1; i <= n; i++) {
            try {
                if (i % 3 != 0 && i % 5 != 0) {
                    System.out.println(i);
                } else {
                    System.out.println(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
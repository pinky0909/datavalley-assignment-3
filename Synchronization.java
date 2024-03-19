class Counter {
    private int count = 0;

    // Method to increment the count synchronously
    public synchronized void increment() {
        count++;
    }

    // Method to decrement the count synchronously
    public synchronized void decrement() {
        count--;
    }

    // Method to get the current count
    public synchronized int getCount() {
        return count;
    }
}

class IncrementerThread extends Thread {
    private Counter counter;

    public IncrementerThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class DecrementerThread extends Thread {
    private Counter counter;

    public DecrementerThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.decrement();
        }
    }
}

public class SynchronizationExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        IncrementerThread incrementerThread = new IncrementerThread(counter);
        DecrementerThread decrementerThread = new DecrementerThread(counter);

        incrementerThread.start();
        decrementerThread.start();

        // Wait for both threads to finish
        incrementerThread.join();
        decrementerThread.join();

        System.out.println("Final count: " + counter.getCount());
    }
}


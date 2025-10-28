package multithread;

public class Multithread {
    static int N;
    public static void main(String[] args) {
        int N = 10; // Change N as needed

        Object lock = new Object();

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= N; i += 2) {
                synchronized (lock) {
                    System.out.println("Odd: " + i);
                    lock.notify();
                    if (i + 1 <= N) {
                try {
                            lock.wait();
                } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= N; i += 2) {
                synchronized (lock) {
                    System.out.println("Even: " + i);
                    lock.notify();
                    if (i + 1 <= N) {
                try {
                            lock.wait();
                } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Finished printing numbers from 1 to " + N);
    }


    void printNumbers(){
        int count = 1;

        synchronized (this){
            while(count < N){
                while(count % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted: " + e.getMessage());
                    }
                }
                System.out.println("Even: " + count);
                count++;
                notify();
            }
        }

    }
}

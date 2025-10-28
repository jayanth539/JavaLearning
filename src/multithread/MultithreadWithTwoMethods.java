package multithread;

public class MultithreadWithTwoMethods {
    static int N;
    int count = 1;

    public static void main(String[] args) {
        N = 10; // Change N as needed

        MultithreadWithTwoMethods instance = new MultithreadWithTwoMethods();

        Thread oddThread = new Thread(instance::printOddNumbers);
        Thread evenThread = new Thread(instance::printEvenNumbers);

        oddThread.start();
        evenThread.start();


        System.out.println("Finished printing numbers from 1 to " + N);
    }

    void printOddNumbers(){
        synchronized (this){
            while(count < N){
                while (count % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                System.out.println("Odd: " + count);
                count++;
                notify();
            }
        }
    }

    void printEvenNumbers(){
        synchronized (this){
            while(count < N){
                while (count % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                System.out.println("Even: " + count);
                count++;
                notify();
            }
        }
    }
}

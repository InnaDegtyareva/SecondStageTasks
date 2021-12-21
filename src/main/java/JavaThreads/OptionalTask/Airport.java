package JavaThreads.OptionalTask;

import java.util.concurrent.Semaphore;

public class Airport extends Thread {
    public static void main(String[] args) {

        Semaphore runway = new Semaphore(5, true);
        for (int i = 1; i <= 10; i++) {
            new Airplane(i, runway).start();
        }
    }
}




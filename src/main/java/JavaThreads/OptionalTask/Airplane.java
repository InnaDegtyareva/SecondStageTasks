package JavaThreads.OptionalTask;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Airplane extends Thread {
    private int number;
    private Semaphore runway;

    public Airplane(int number, Semaphore runway) {
        this.number = number;
        this.runway = runway;
    }

    public void run() {
        try {
            runway.acquire();
            System.out.println("The airplane number " + number + " began to enter the runway");
            System.out.println("The runway took the airplane number " + number);
            TimeUnit.SECONDS.sleep(3);
            System.out.println("The airplane number " + number + " took off");
            System.out.println("The runway is free");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            runway.release();
        }
    }
}


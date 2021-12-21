package JavaThreads.MainTask;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Car extends Thread {
    private int id;
    private Semaphore parkingSpace;
    private int waitingTime;


    public Car(int id, Semaphore parkingSpace) {
        this.id = id;
        this.parkingSpace = parkingSpace;
        this.waitingTime = (int) (Math.random() * 30);
    }

    public void run() {
        int parkingTime = 10;
        System.out.printf("A car number %d arrived at the parking and can wait only %d minutes\n", id, waitingTime);
        try {
            if (parkingSpace.tryAcquire()) {
                System.out.printf("The car number %d drives into free parking space\n", id);
                TimeUnit.SECONDS.sleep(parkingTime);
                System.out.printf("The car number %d leaves the parking\n", id);
                parkingSpace.release();
            }
            else if(parkingSpace.tryAcquire(waitingTime, TimeUnit.SECONDS)) {
                System.out.printf("The car number %d drives into free parking space\n", id);
                TimeUnit.SECONDS.sleep(parkingTime);
                System.out.printf("The car number %d leaves the parking\n", id);
                parkingSpace.release();
            }
            else {
                System.out.printf("The car number %d can't wait no more and departs the parking\n", id);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

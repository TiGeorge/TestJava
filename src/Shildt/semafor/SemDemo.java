package Shildt.semafor;

import java.util.concurrent.Semaphore;

public class SemDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new Thread(new IncThread(semaphore, "A")).start();
        new Thread(new DecThread(semaphore, "B")).start();
    }
}

class Shared {
    static int count = 0;
}

class IncThread implements Runnable {

    String name;
    Semaphore semaphore;

    public IncThread(Semaphore semaphore, String name) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            System.out.println(name + " waiting for a permit");
            semaphore.acquire();
            System.out.println(name + " gets a permit");
            for (int i = 0; i < 10; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(100);
            }
            System.out.println(name + " releases the permit");
            semaphore.release();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DecThread implements Runnable {

    String name;
    Semaphore semaphore;

    public DecThread(Semaphore semaphore, String name) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            System.out.println(name + " waiting for a permit");
            semaphore.acquire();
            System.out.println(name + " gets a permit");
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(100);
            }
            System.out.println(name + " releases the permit");
            semaphore.release();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
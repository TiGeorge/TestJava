package Shildt.comunication;

import java.util.concurrent.Semaphore;
import java.util.function.Predicate;

public class PC {
    public static void main(String[] args) {
        Q q = new Q();
        new Thread(new Producer(q)).start();
        new Thread(new Consumer(q)).start();
    }
}

class Q {
    int n;
    //boolean valueSet = false;
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {

        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Got: " + n);
        semProd.release();
    }

    void put(int n) {

        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.n = n;
        System.out.println("Put: " + n);
        semCon.release();
    }
}

class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable{
    Q q;

    public Consumer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            q.get();
        }
    }
}
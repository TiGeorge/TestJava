package Shildt.suspendresume;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class SuspendResume {
    public static void main(String[] args) {
        NewThread newThread1 = new NewThread("One");
        NewThread newThread2 = new NewThread("Two");
        newThread1.thread.start();
        newThread2.thread.start();

        try {
            Thread.sleep(1000);
            newThread1.mysuspend();
            System.out.println("Suspending One");
            Thread.sleep(1000);
            newThread1.myresume();
            System.out.println("Resuming One");
            Thread.sleep(1000);
            newThread2.mysuspend();
            System.out.println("Suspending Two");
            Thread.sleep(1000);
            newThread2.myresume();
            System.out.println("Resuming Two");
        } catch (InterruptedException e) {
            System.out.println("Main interrupted.");
        }

        System.out.println("Waiting for threads to finish");
        try {
            newThread1.thread.join();
            newThread2.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread exiting");
    }
}

class NewThread implements Runnable {
    Thread thread;
    String name;
    boolean suspendFlag;

    public NewThread(String name) {
        this.name = name;
        thread = new Thread(this, name);
        suspendFlag = false;
        System.out.println("New thread = " + thread);
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + " " + i);
                Thread.sleep(400);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }

        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " exiting");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }

    @Override
    public void run() {

    }
}

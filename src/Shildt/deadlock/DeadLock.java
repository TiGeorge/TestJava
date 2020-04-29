package Shildt.deadlock;

import java.io.OutputStream;

public class DeadLock implements Runnable{
    A a = new A();
    B b = new B();
    Thread thread;

    public DeadLock() {
        Thread.currentThread().setName("MainThread");
        thread = new Thread(this, "RacingThread");
    }

    void deadLockStart() {
        thread.start();
        a.foo(b);
        System.out.println("Back in main thread.");
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.deadLockStart();
    }

    @Override
    public void run() {
        b.bar(a);
        System.out.println("Back in other thread.");
    }
}

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered A.foo.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" trying to call B.last.");
        b.last();

    }

    synchronized void last() {
        System.out.println("Inside A.last");
    }
}

class B {

    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered B.bar.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" trying to call A.last.");
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last.");
    }

}

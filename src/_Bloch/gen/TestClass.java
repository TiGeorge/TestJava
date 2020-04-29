package _Bloch.gen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

interface Birdie {
    void fly();
}

class Dino implements Birdie {
    public void fly() {
        System.out.println("Dino flies");
    }

    public void eat() {
        System.out.println("Dino eats");
    }
}

class Bino extends Dino {
    public void fly() {
        System.out.println("Bino flies");
    }

    public void eat() {
        System.out.println("Bino eats");
    }
}

public class TestClass {
    public static void main(String[] args) {
        List<Object> m = new ArrayList<>();
        m.add(new Dino());
        m.add(new Bino());
        for (Object b : m) {
            //b.fly();
            //b.eat();
        }
        var df = pick("df", new ArrayList<String>());
    }

    static <T> T pick(T a1, T a2) { return a2; }
    Object s = pick("d", new ArrayList<String>());
}
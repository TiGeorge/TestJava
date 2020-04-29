package Shildt.generics;

class Gen<T> {
    T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }

    public <T> String transform(T t) {
        return t.toString() + "-" + t.hashCode();
    }

    void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}

public class GenDemo {
    public static void main(String[] args) {

        Gen<String> gcStr = new Gen<String>("qwe");
        System.out.println(gcStr.transform(1.1)); //3

        Gen<Integer> integerGen;
        integerGen = new Gen<>(88);
        integerGen.showType();

        int v = integerGen.getOb();
        System.out.println("value= " + v);
        System.out.println();

        Gen<String> stringGen = new Gen<>("Generics test");
        stringGen.showType();
        String s = stringGen.getOb();
        System.out.println("value=" + s);

    }
}



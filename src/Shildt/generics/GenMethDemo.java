package Shildt.generics;

public class GenMethDemo {
    static <T extends Comparable<T>> boolean isIn(T x, T[] y) {
        for (T v : y) {
            if(v.equals(x)) return true;
        }
        return false;
    }

    static void met(String s) {

    }

    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5};
        System.out.println(isIn(3, nums));

        String str[] = {"qqq", "www", "eee"};
        System.out.println(isIn("qqq", str));

        //met(1.2);

    }
}

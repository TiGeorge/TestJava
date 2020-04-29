package mvccalc;

import java.util.function.Predicate;

public class Calc {
    public static void main(String[] args) {
        int[] ints = {-5, -4, -6, 1, 2, 3, 4, 5, 6};
        //Operationable operationable = n -> n % 2 == 0;
        System.out.println(sum(ints, Calc::isEven));
        System.out.println(sum(ints, Calc::isPositive));
        System.out.println("\uD83D\uDCA3");
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static boolean isPositive(int n) {
        return n > 0;
    }

    public static int sum(int[] ints, Predicate<Integer> oper) {
        int sum = 0;
        for (int anInt : ints) {
            if(!oper.test(anInt)) sum += anInt;
        }
        return sum;

    }


}


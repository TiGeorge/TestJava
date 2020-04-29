package staticInnerClass;

import java.nio.file.Path;
import java.util.logging.Logger;

public class StaticInnerClassTest {
    public static void main(String[] args) {
        var values = new Double[20];
        for (int i = 0; i < values.length; i++) {
            values[i] = 100 * Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.minmas(values);
        System.out.println("min=" + p.getFirst());
        System.out.println("max="+p.getSecond());

    }
}

class ArrayAlg{
    public static class Pair{
        private double first;
        private double second;

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }
    }

    public static Pair minmas(Double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (Double value : values) {
            if(min>value) min = value;
            if(max<value) max = value;
        }
        return new Pair(min, max);

    }
}
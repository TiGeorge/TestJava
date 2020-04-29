package codility;

import java.util.stream.IntStream;

public class test1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = 32;
        System.out.println(solution.solution(i));
    }

}
 class Multiply {
    public static Double multiply(Double a, Double b) {
        return (a * b);
    }
}

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        char[] chars = Integer.toBinaryString(N).toCharArray();
        int result = 0;
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                temp++;
            } else {
                result = Math.max(result, temp);
                temp = 0;
            }
        }

        return result;
    }
}

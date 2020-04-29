package _Bloch.staticFactoryMethods;

public class Solution {
    public static void main(String[] args) {
        Triangle triangleGreen = Triangle.getGreenTriangle();
        Triangle triangleRed = Triangle.getRedTriangle();

        Triangle tr = Triangle.getBWTriangle(true);

    }
}

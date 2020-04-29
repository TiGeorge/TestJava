package _Bloch.staticFactoryMethods;

import java.awt.*;

public class Triangle {
    private Color color;

    public Triangle(Color color) {
        this.color = color;
    }

    public static Triangle getRedTriangle() {
        return new Triangle(Color.RED);
    }
    public static Triangle getGreenTriangle() {
        return new Triangle(Color.GREEN);
    }

    public static Triangle getBWTriangle(boolean boo) {
        if(boo) return new BlackTriangle();
        else return new WhiteTriangle();
    }
}

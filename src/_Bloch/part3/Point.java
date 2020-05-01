package _Bloch.part3;

import java.awt.*;

public class Point implements Cloneable {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Point clone() throws CloneNotSupportedException {
        return (Point) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
   }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point)) return false;
        if(!(obj instanceof ColorPoint)) return super.equals(obj);
        return super.equals(obj) && ((ColorPoint) obj).color == color;
    }
}

class ColorPoint2 {

    private final Point point;
    private final Color color;

    public ColorPoint2(Point point, Color color) {
        this.point = point;
        this.color = color;
    }

    private Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColorPoint2)) return false;

        ColorPoint2 that = (ColorPoint2) o;

        if (point != null ? !point.equals(that.point) : that.point != null) return false;
        return color != null ? color.equals(that.color) : that.color == null;
    }

    @Override
    public int hashCode() {
        int result = point != null ? point.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }



}

class Test {
    public static void main(String[] args) throws CloneNotSupportedException {

        Point p = new Point(1,3);
        Point p2 = p.clone();

    }
}
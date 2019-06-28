/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

public class OverlappingRectangles {
    public static void main(String[] args) {

        int a = 1;
        int b = 2;

        int c = 4;
        int d = 3;

        int e = -2;
        int f = -1;

        int g = 0;
        int h = 4;

        Rectangle r1 = new Rectangle(a,b,c,d);
        Rectangle r2 = new Rectangle(e,f,g,h);

        boolean overlappingRectangle = isOverlappingRectangle(r1,r2);

        System.out.println(overlappingRectangle);
    }

    private static boolean isOverlappingRectangle(Rectangle r1, Rectangle r2) {

        if(Math.max(r2.getX1(), r2.getX2()) < Math.min(r1.getX1(), r1.getX2()))
            return false;

        if(Math.max(r1.getX1(), r1.getX2()) < Math.min(r2.getX1(), r2.getX2()))
            return false;

        if(Math.max(r2.getY1(), r2.getY2()) < Math.min(r1.getY1(), r1.getY2()))
            return false;

        if(Math.max(r1.getY1(), r1.getY2()) < Math.min(r2.getY1(), r2.getY2()))
            return false;

        return true;
    }
}


class Rectangle {
    private int x1, y1, x2, y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}


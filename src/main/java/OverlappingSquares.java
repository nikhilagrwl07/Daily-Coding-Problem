/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

public class OverlappingSquares {
    public static void main(String[] args) {
//        int x1 = 1;
//        int y1 = 4;
//        int x2 = -1;
//        int y2 = 3;

        int x1 = 1;
        int y1 = 4;
        int x2 =-3;
        int y2 = -2;


        boolean overlappingSquare = isOverlappingSquare(x2, y2, x1, y1);

        System.out.println(overlappingSquare);
    }

    private static boolean isOverlappingSquare(int x, int y, int a, int b) {

        int min = Math.min(x, y);
        int max = Math.max(x, y);

        if ((min <= a && a <= max) || (min <= b && b <= max))
            return true;

        return false;

    }


    class Square {
        Point p1, p2, p3, p4;

        public Square(Point p1, Point p2, Point p3, Point p4) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.p4 = p4;
        }
    }

    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}


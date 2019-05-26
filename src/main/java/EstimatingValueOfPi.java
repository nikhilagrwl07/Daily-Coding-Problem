package main.java;

public class EstimatingValueOfPi {
    private static final int randomCount = 10000;

    public static void main(String[] args) {

        System.out.println(estimatePiUsingMontoCarloMethod());
    }


    // Monto Carlo Formula => pi = 4 * (number of points inside circle)/ (number of points inside square of size 1)
    private static double estimatePiUsingMontoCarloMethod() {
        int circlePointCount = 0, squarePointCount = 0;
        double pi = 0.0;

        for (int i = 1; i <= randomCount * randomCount; i++) {
            double xRandom = (Math.random() % (randomCount + 1)) / randomCount;
            double yRandom = (Math.random() % (randomCount + 1)) / randomCount;

            double distance = (xRandom * xRandom) + (yRandom * yRandom);
            if (distance <= 1)
                circlePointCount++;

            squarePointCount++;

            pi = 4.0 * (circlePointCount) / squarePointCount;

            if (i % 10 == 0) {

                System.out.println(pi);
            }

        }

        return pi;
    }
}

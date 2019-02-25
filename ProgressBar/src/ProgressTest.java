import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * ProgressCircle Circle Unit Test
 * 
 * Original code written by: Juan Macias
 * San Jose State University
 * Spring 2019
 * CMPE187: Software Testing
 *
 * This class unit tests ProgressCircle.java.
 * In order to run assertions you must have JUnit 4 added to the classpath.
 */

public class ProgressTest {

    @Test
    public void quadrantOneHit() {
        /**
         * Checks that "hits" in QI are detected properly
         */

        final int NUM_COORDS = 10;
        ArrayList<Integer> randXValues = oracle(50, 100, NUM_COORDS);
        ArrayList<Integer> randYValues = oracle(50, 100, NUM_COORDS);

        for (int i = 0; i < NUM_COORDS; i++) {
            ProgressCircle currentProgressCircle = new ProgressCircle(25, randXValues.get(i), randYValues.get(i));
            assertEquals("RED, QI", currentProgressCircle.getProgress(currentProgressCircle.P,
                    currentProgressCircle.x, currentProgressCircle.y));
        }
    }

    @Test
    public void quadrantOneMiss() {
        /**
         * Checks that "misses" in QI are detected properly
         */

        final int NUM_COORDS = 10;
        ArrayList<Integer> randXValues = oracle(50, 100, NUM_COORDS);
        ArrayList<Integer> randYValues = oracle(50, 100, NUM_COORDS);

        for (int i = 0; i < NUM_COORDS; i++) {
            ProgressCircle currentProgressCircle = new ProgressCircle(0, randXValues.get(i), randYValues.get(i));
            assertEquals("BLUE", currentProgressCircle.getProgress(currentProgressCircle.P,
                    currentProgressCircle.x, currentProgressCircle.y));
        }
    }

    @Test
    public void quadrantTwoHit() {
        /**
         * Checks that "hits" in QII are detected properly
         */

        final int NUM_COORDS = 10;
        ArrayList<Integer> randXValues = oracle(50, 100, NUM_COORDS);
        ArrayList<Integer> randYValues = oracle(0, 49, NUM_COORDS);

        for (int i = 0; i < NUM_COORDS; i++) {
            ProgressCircle currentProgressCircle = new ProgressCircle(50, randXValues.get(i), randYValues.get(i));
            System.out.println("Cirlce is 50% complete. Testing coordinates (x: "
                    + randXValues.get(i) + ",\ty: " + randYValues.get(i) + ")...");
            assertEquals("RED, QII", currentProgressCircle.getProgress(currentProgressCircle.P,
                    currentProgressCircle.x, currentProgressCircle.y));
        }
        System.out.println("Test complete.");
    }

    @Test
    public void quadrantTwoMiss() {
        /**
         * Checks that "misses" in QI are detected properly
         */

        final int NUM_COORDS = 10;
        ArrayList<Integer> randXValues = oracle(50, 100, NUM_COORDS);
        ArrayList<Integer> randYValues = oracle(0, 49, NUM_COORDS);

        for (int i = 0; i < NUM_COORDS; i++) {
            ProgressCircle currentProgressCircle = new ProgressCircle(25, randXValues.get(i), randYValues.get(i));
            assertEquals("BLUE", currentProgressCircle.getProgress(currentProgressCircle.P,
                    currentProgressCircle.x, currentProgressCircle.y));
        }
    }

    @Test
    public void quadrantThreeHit() {
        /**
         * Checks that "hits" in QII are detected properly
         */

        final int NUM_COORDS = 10;
        ArrayList<Integer> randXValues = oracle(0, 49, NUM_COORDS);
        ArrayList<Integer> randYValues = oracle(0, 49, NUM_COORDS);

        for (int i = 0; i < NUM_COORDS; i++) {
            ProgressCircle currentProgressCircle = new ProgressCircle(75, randXValues.get(i), randYValues.get(i));
            System.out.println("Cirlce is 75% complete. Testing coordinates (x: "
                    + randXValues.get(i) + ",\ty: " + randYValues.get(i) + ")...");
            assertEquals("RED, QIII", currentProgressCircle.getProgress(currentProgressCircle.P,
                    currentProgressCircle.x, currentProgressCircle.y));
        }
        System.out.println("Test complete.");
    }

    @Test
    public void quadrantThreeMiss() {
        /**
         * Checks that "misses" in QI are detected properly
         */

        final int NUM_COORDS = 10;
        ArrayList<Integer> randXValues = oracle(0, 49, NUM_COORDS);
        ArrayList<Integer> randYValues = oracle(0, 49, NUM_COORDS);

        for (int i = 0; i < NUM_COORDS; i++) {
            ProgressCircle currentProgressCircle = new ProgressCircle(50, randXValues.get(i), randYValues.get(i));
            System.out.println("Cirlce is 50% complete. Testing coordinates (x: "
                    + randXValues.get(i) + ",\ty: " + randYValues.get(i) + ")...");
            assertEquals("BLUE", currentProgressCircle.getProgress(currentProgressCircle.P,
                    currentProgressCircle.x, currentProgressCircle.y));
        }
        System.out.println("Test complete.");
    }

    @Test
    public void quadrantFourHit() {
        /**
         * Checks that "hits" in QII are detected properly
         */

        final int NUM_COORDS = 10;
        ArrayList<Integer> randXValues = oracle(0, 49, NUM_COORDS);
        ArrayList<Integer> randYValues = oracle(50, 100, NUM_COORDS);

        for (int i = 0; i < NUM_COORDS; i++) {
            ProgressCircle currentProgressCircle = new ProgressCircle(100, randXValues.get(i), randYValues.get(i));
            System.out.println("Cirlce is 100% complete. Testing coordinates (x: "
                    + randXValues.get(i) + ",\ty: " + randYValues.get(i) + ")...");
            assertEquals("RED, QIV", currentProgressCircle.getProgress(currentProgressCircle.P,
                    currentProgressCircle.x, currentProgressCircle.y));
        }
        System.out.println("Test complete.");
    }

    @Test
    public void quadrantFourMiss() {
        /**
         * Checks that "misses" in QI are detected properly
         */

        final int NUM_COORDS = 10;
        ArrayList<Integer> randXValues = oracle(0, 49, NUM_COORDS);
        ArrayList<Integer> randYValues = oracle(50, 100, NUM_COORDS);

        for (int i = 0; i < NUM_COORDS; i++) {
            ProgressCircle currentProgressCircle = new ProgressCircle(75, randXValues.get(i), randYValues.get(i));
            System.out.println("Cirlce is 75% complete. Testing coordinates (x: "
                    + randXValues.get(i) + ",\ty: " + randYValues.get(i) + ")...");
            assertEquals("BLUE", currentProgressCircle.getProgress(currentProgressCircle.P,
                    currentProgressCircle.x, currentProgressCircle.y));
        }
        System.out.println("Test complete.");
    }



    // Set up testing environment

    private static ArrayList<Integer> oracle(int minCoord, int maxCoord, int numCoords) {
        /**
         * This is our test oracle.
         * It generates random values to test
         *
         * @return random values to test.
         */
        final int MAX = maxCoord;
        final int MIN = minCoord;
        final int SIZE = numCoords; // number of random numbers to generate

        ArrayList<Integer> values = generateRandomValues(MIN, MAX, SIZE);

        return values;
    }

    public static ArrayList<Integer> generateRandomValues(int min, int max, int size) {
        /**
         * Generates random values and returns them as an arraylist
         *
         * @param size is the number of random values added to the arraylist
         * @param max is the maximum possible value for the random number
         * @param min is the minimum possible value for the random number
         */
        Random rand = new Random();

        ArrayList<Integer> values = new ArrayList<Integer>();

        //generate random values
        for (int i = 0; i < size; i++) {
            values.add(min + (int) (Math.random() * ((max - min) + 1)));
        }
        return values;
    }
}

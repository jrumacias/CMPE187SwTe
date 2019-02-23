import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * ProgressCircle Circle Unit Test
 * <p>
 * Original code written by: Juan Macias
 * San Jose State University
 * Spring 2019
 * CMPE187: Software Testing
 * <p>
 * This class unit tests ProgressCircle.java.
 * In order to run assertions you must have JUnit 4 added to the classpath.
 */

public class ProgressTest {

    @Test
    public void quadrantOne() {
        /**
         * Checks that "hits" and "misses" in QI are detected properly
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
            values.add(min + (int)(Math.random() * ((max - min) + 1)));
        }
        return values;
    }
}

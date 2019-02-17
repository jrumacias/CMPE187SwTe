import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import static org.junit.Assert.*;

/**
 * This class unit tests the BST. The BST DOES NOT have duplicates
 *
 * In order to run assertions you must have '-ea' in the VM assertions for your IDE.
 *
 * if you are using IntelliJ IDEA IDE follow these steps to enable assertions:
 * Run -> edit configurations -> in VM options enter '-ea'.    now you can run the program like normal
 */

public class BSTtest {

    @Test
    public void addArrayList(){
        /**
         * Checks that the values were correctly added to the BST
         */
        //Get random values from the test oracle
        ArrayList<Integer> randValues = oracle();

        //For testing we remove duplicate values from our rand values because our BST does not take duplicates
        ArrayList<Integer> randValuesWithoutDuplicates = removeDuplicates(randValues);

        //Create bst
        BST tree = new BST();

        //Add arraylist
        tree.addArrayList(randValues);

        for(int value:randValuesWithoutDuplicates)
        {
            assertTrue(tree.find(value));
        }


    }

    @Test
    public void getRootNodeValue() {
        /**
         * tests the getRoodNodeValue method
         */

        //Create bst
        BST tree = new BST();

        //Test that the newely created BST's root node is NULL.
        assertNull(tree.getRootNode());

        //Get random values from the test oracle
        ArrayList<Integer> randValues = oracle();

        //Add the arraylist to the tree
        tree.addArrayList(randValues);

        //Check that the first value entered into the tree (root) is the root node in the tree.
        assertEquals(randValues.get(0),(Integer) tree.getRootNodeValue());
    }
    
    @Test
    public void find() {
        /**
         * Test the find function
         */

        //Create random test values
        ArrayList<Integer> randValues = oracle();

        //create BST with rand values
        BST tree = new BST(randValues);


        //Check that each value that has been added to the tree can be found
        for(int value: randValues){

            assertTrue(tree.find(value));

        }

    }

    @Test
    public void delete() {
        /**
         * Tests the delete function
         */

        //get random values (with duplicates)
        ArrayList<Integer> randValues = oracle();

        //Create BST with random values
        BST tree = new BST(randValues);


        //For testing we remove duplicate values from our rand values because our BST does not take duplicates
        ArrayList<Integer> randValuesWithoutDuplicates = removeDuplicates(randValues);

        //Get the size of the input data without duplicates
        int randValuesSize = randValuesWithoutDuplicates.size()-1;
        System.out.println("randValuesSize: " + randValuesSize);
        //When An Item is deleted test the size
        for(int value: randValuesWithoutDuplicates)
        {

            tree.delete(value);
//            randValuesSize -= 1;
            assertEquals(randValuesSize--, tree.getSize(tree.getRootNode()));
        }

    }

    @Test
    public void minValue(){
        /**
         * tests the minvalue
         */

        //get random values for test
        ArrayList<Integer> randValues = oracle();

        //Create tree and add random values to the tree
        BST tree = new BST(randValues);

        //Sort the random values so we know the least values from our test input data
//        Collections.sort(randValues);

        //Check if the min value from our test values match the min value from the tree
        assertEquals(Collections.min(randValues),(Integer) tree.minValue());
    }

    @Test
    public void getSuccessor() {


    }

    @Test
    public void insert() {
        /**
         * Test the insert method
         */
        ArrayList<Integer> randValues = oracle();

        BST tree = new BST();


        ArrayList<Integer> noDuplicateValues = removeDuplicates(randValues);


        for(int value: randValues)
        {
            assertTrue(tree.insert(value));
        }


    }

    @Test
    public void display() {
        /**
         * Test the display method
         *
         * This does NOT WORK
         */


        ArrayList<Integer> randValues = oracle();

        BST tree = new BST(randValues);

        //Get the random values without duplicates. This will be compared with whats in the tree. Tree does not have duplicates
        randValues = removeDuplicates(randValues);

        //Sort the randValues so that we can compare with the output of the tree (tree should go from smallest to largest without duplicates)
        Collections.sort(randValues);

        String stringVal= randValues.toString();

        String temp= "";
        for(int i = 0; i < randValues.size();i++)
        {

            temp += " "+ randValues.get(i).toString();


        }


    }



    private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list){
        /**
         * This is a helper method for testing.
         *
         * This method removes duplicates from an arraylist
         *
         * @param list with duplicates
         * @return list with duplicates removed
         */
        ArrayList<Integer> noDuplicates = new ArrayList<>();


        for(int i = 0; i < list.size();i++)
        {
            if(!noDuplicates.contains(list.get(i)))
            {
                noDuplicates.add(list.get(i));
            }
        }
        return noDuplicates;
    }

    private static ArrayList<Integer>oracle() {
        /**
         * This is our test oracle.
         * It generates random values to test
         *
         * @return random values to test.
         */
        final int MAX = 20;
        final int MIN = 0;
        final int SIZE = 6;//number of random numbers

        ArrayList<Integer> values= generateRandomValues(SIZE,MAX,MIN);

        return values;
    }

    public static ArrayList<Integer> generateRandomValues(int size, int max, int min) {
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
        for(int i = 0; i < size ; i ++ )
        {
            values.add(rand.nextInt(max)+min);
        }

        return values;

    }

    private static void print(Object value) {
        /**
         * Prints Object values to the screen.
         *
         * @return void
         */
        System.out.print(value);

    }

    private static void println(Object value) {
        /**
         * Prints Object values to the screen.
         *
         * @return void
         */
        System.out.println(value);

    }
}

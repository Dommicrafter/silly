/**
 * Test Class for ArrayPlayground
 * ADS 1 - Telematik - TH Wildau
 *
 * @author Roman Kobosil
 * @version 1.0, 23.03.17
 */
public class TestPlayground {

    /**
     * Main Java Class
     *
     * @param args java parameter
     */
    public static void main(String[] args) {

        //measure start time in ms
        long startTime = System.currentTimeMillis();

        //run getPrimes
        ArrayPlayground.getPrimes(10000);


        //measure end time in ms
        long stopTime = System.currentTimeMillis();
        System.out.println("getPrimes ms: " + (stopTime - startTime));


        //test int array
        int[] testArray = {1, 2, 4, 6, 888, 44, 22, 3, 5};

        //search value 4 in test array
        System.out.println("Array Index: " + ArrayPlayground.search(testArray, 4));

        System.out.print("before invert: ");

        //iterate every index of array
        for (int i = 0; i < testArray.length; i++) {
            //print value of index
            System.out.print(testArray[i] + ",");
        }

        System.out.print(" after: ");

        //invert test array
        ArrayPlayground.invertArray(testArray);

        //iterate every index of array
        for (int i = 0; i < testArray.length; i++) {
            //print value of index
            System.out.print(testArray[i] + ",");
        }
        System.out.println("");

        //get number of days feb
        System.out.println("NumDaysOfMonth(2) Feb: " + ArrayPlayground.getNumDaysOfMonth(2));

        System.out.println("matrices test: ");
        //demo matrices
        float[][] a = {{4, 2, 1}, {0, -2, 4}};
        float[][] b = {{1, 2, 3}, {0, 4, 6}, {2, -1, 8}};
        float[][] result = ArrayPlayground.matrixMult(a, b);

        //iterate every row of the result array
        for (int rows = 0; rows < result.length; rows++) {
            //iterate every cols of the result array
            for (int cols = 0; cols < result[rows].length; cols++) {
                //print value of index
                System.out.print(result[rows][cols] + ",");
            }
            //print new line
            System.out.println();
        }


    }


}

/**
 * Class for testing new algorithms
 * ADS 1 - Telematik - TH Wildau
 *
 * @author Roman Kobosil
 * @version 1.0, 23.03.17
 */
public class ArrayPlayground {

    /**
     * search an int value in a array
     *
     * @param array search array
     * @param x     search value
     * @return return the index in the array or -1 for no match
     */
    public static int search(int[] array, int x) {

        //iterate every index of array of match with x
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x)
                return i; // return index
        }

        //return -1 if no match
        return -1;
    }

    /**
     * algorithm for generation of prime numbers
     *
     * @param max highest number
     */
    public static void getPrimes(int max) {
        // create boolean array with the size one more of the highest
        boolean[] primeArray = new boolean[max + 1];

        //iterate every index of array and fill with true
        for (int i = 0; i < primeArray.length; i++) {
            primeArray[i] = true;
        }

        //iterate every index of array, starting on index 2
        for (int i = 2; i < primeArray.length; i++) {

            //continue if current index is already false
            if (!primeArray[i])
                continue;

            //iterate every multiple of i, starting at the first multiple of i
            for (int z = i * 2; z < primeArray.length; z += i) {
                //set multiple of i false
                primeArray[z] = false;
            }
        }


        System.out.print("Primes: ");
        //iterate every index of array and print results (print index=prime if the value is true)
        for (int i = 2; i < primeArray.length; i++) {
            //check if value of primeArray index is true
            if (primeArray[i])
                System.out.print(i + ",");
        }
        //new line
        System.out.println("");


    }

    /**
     * invert an int array
     *
     * @param a int array
     */
    public static void invertArray(int[] a) {

        //iterate the first half side of array
        for (int i = 0; i < a.length / 2; i++) {
            //copy value with index i in swap value
            int swap = a[i];

            //fill index i with the value of last index from the end - i (opposite side)
            a[i] = a[a.length - 1 - i];
            //fill the last index from the end - i with the swap value
            a[a.length - 1 - i] = swap;
        }
    }

    /**
     * get the days of a Month by id {1,2,3,4,...,12}
     *
     * @param month id of Month {1,2,3,4,...,12}
     * @return days of a Month or -1 if month no match {1,2,3,4,...,12}
     */
    public static int getNumDaysOfMonth(int month) {

        //array of the days in each month
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        //check the set of ids {1,2,3,4,...,12}
        if (month < 13 && month > 0) {
            //return the static value of days by month id - 1 (because array starts with index 0)
            return daysOfMonth[month - 1];

        } else {
            //return error if month id not match set
            return -1;
        }
    }

    /**
     * product of two matrices
     *
     * @param a matrice a
     * @param b matrice b
     * @return result matrice
     */
    public static float[][] matrixMult(float[][] a, float[][] b) {

        //result cols length = b[0].length and result rows = a.length
        float[][] result = new float[a.length][b[0].length];

        //iterate all rows from the result
        for (int rows = 0; rows < a.length; rows++) {
            //iterate all cols from the result
            for (int cols = 0; cols < b[0].length; cols++) {
                //iterate all cols from the a array
                for (int x = 0; x < a[0].length; x++) {
                    //calculate product like http://www.frustfrei-lernen.de/mathematik/matrizen-multiplizieren.html
                    result[rows][cols] += a[rows][x] * b[x][cols];
                }
            }
        }

        return result;
    }
}

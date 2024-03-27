import static java.lang.Math.sqrt;


public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */

    public static int[] flattenSnail(int[][] array2d) {
        // snail is not square
        // Length of middle row not equal to the number of rows.
        if ((array2d == null) || (array2d.length == 0) || (array2d.length != array2d[0].length)
    || (!isPerfectSquare(array2d)) ) {
            return new int[0];
        }

        int n = array2d.length;
        int[] result = new int[n * n];
        int index = 0;

        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // top row from left to right
            for (int i = left; i <= right; i++) {
                result[index++] = array2d[top][i];
            }
            top++;

            // right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                result[index++] = array2d[i][right];
            }
            right--;

            // bottom row from right to left
            for (int i = right; i >= left; i--) {
                result[index++] = array2d[bottom][i];
            }
            bottom--;

            // left column from bottom to top
            for (int i = bottom; i >= top; i--) {
                result[index++] = array2d[i][left];
            }
            left++;
        }

        return result;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if (array1d == null || array1d.length == 0) {
            return new int[0][0];
        }
        if (!isPerfectSquare(array1d)) {
            return new int[0][0];
        }

        int n = (int) sqrt(array1d.length);
        int[][] result = new int[n][n];
        int index = 0;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // top row from left to right
            for (int i = left; i <= right; i++) {
                result[top][i] = array1d[index++];
            }
            top++;

            // right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                result[i][right] = array1d[index++];
            }
            right--;

            // bottom row from right to left
            for (int i = right; i >= left; i--) {
                result[bottom][i] = array1d[index++];
            }
            bottom--;

            // left column from bottom to top
            for (int i = bottom; i >= top; i--) {
                result[i][left] = array1d[index++];
            }
            left++;
        }

        return result;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int i = 0;i < array1d.length; i++){
            System.out.println(array1d[i]);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[i].length; j++) {
                System.out.print(array2d[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        double sqrt=Math.sqrt(array1d.length);
        return ((sqrt - Math.floor(sqrt)) == 0);
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        int num = 0;
        for (int[] i: array2d){
            for (int j: i){
                num++;
            }
        }
        double i = Math.sqrt(num);
        if ((int) i * (int) i != num){
            return false;
        }
        return true;
    }

}

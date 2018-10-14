package com.practice.program.optimization;
public class TriPairSumCloseToK {

    public void getTriPair(int[] arr, int expectedTriSum) {
        for (int i = 0; i < arr.length; i++) {
            int expectedBiSum = expectedTriSum - arr[i];
            String output = getPair2(arr, expectedBiSum, i);
            if(!output.equalsIgnoreCase("")) {
                System.out.println(arr[i]+","+output.toString());
            }
        }
    }

    /**
     * Find the pair in an array whose sum with complexity O(n). This assumes
     * the array passed is sorted array and there are no duplicates in the
     * array
     * @param arr
     *            input array of elements
     * @param expectedBiSum
     *            sum for which pair of array elements needs to be searched
     */
    public String getPair2(int[] arr, int expectedBiSum, int ignoreIndex) {
        int start = 0;
        int end = arr.length - 1;
        int sum = 0;

        // output array to record matching pairs
        StringBuilder arrs = new StringBuilder();

        while (start < end) {
            //
            if(start == ignoreIndex)
                start++;
            //
            if(end == ignoreIndex)
                end--;

            sum = arr[start] + arr[end];
            if (sum == expectedBiSum) {
                // we have found one pair, add it to our output array
                arrs.append(arr[start] + "," + arr[end] + ";");
                start++;
                end--;
            } else if (sum < expectedBiSum) {
                // if the sum of the pair is less than the sum we are searching
                // then increment the start pointer which would give us the sum
                // more than our current sum as the array is sorted
                start++;
            } else {
                // if the sum of the pair is greater than the sum we are
                // searching then decrement the end pointer which would give us
                // the sum less than our current sum as the array is sorted
                end--;
            }
        }
        return arrs.toString();
    }

    /**
     * Client to test
     *
     * @param args
     */
    public static void main(String[] args) {
        TriPairSumCloseToK p = new TriPairSumCloseToK();

        // sorted array algo
        int[] arr1 = { 1, 2, 3, 4, 5 };
        p.getTriPair(arr1, 12);

    }
}

package com.practice.program;

// Java program to print distinct
// subset sums of a given array.
import java.io.*;
import java.util.*;

class GFG
{
    // sum denotes the current sum
    // of the subset currindex denotes
    // the index we have reached in
    // the given array
    static void distSumRec(int arr[], int n, int sum,
                           int currindex, HashSet<Integer> s)
    {
        if (currindex > n)
            return;

        if (currindex == n) {
            s.add(sum);
            return;
        }

        distSumRec(arr, n,  arr[currindex],
                currindex + 1, s);
        distSumRec(arr, n, sum, currindex + 1, s);
    }

    // This function mainly calls
    // recursive function distSumRec()
    // to generate distinct sum subsets.
    // And finally prints the generated subsets.
    static void printDistSum(int arr[], int n)
    {
        HashSet<Integer> s = new HashSet<>();
        distSumRec(arr, n, 0, 0, s);

        // Print the result
        for (int i : s)
            System.out.print(i + " ");
    }

    //Driver code
    public static void main(String[] args)
    {
        int arr[] = { 1,2,3};
        int n = arr.length;
        printDistSum(arr, n);
    }
}

// This code is contributed by Gitanjali.
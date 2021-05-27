package com.practice.program.matrix;

// Java program to DP approach
// to above solution
//https://www.geeksforgeeks.org/longest-common-subarray-in-the-given-two-arrays/
class LongestSubArray
{
    // Function to find the maximum
    // length of equal subarray
    static int FindMaxLength(int A[], int B[], int n, int m)
    {

        // Auxillary dp[][] array
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = 0;

        // Updating the dp[][] table
        // in Bottom Up approach
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = m - 1; j >= 0; j--)
            {
                // If A[i] is equal to B[i]
                // then dp[j][i] = dp[j + 1][i + 1] + 1
                if (A[i] == B[j])
                    dp[j][i] = dp[j + 1][i + 1] + 1;
            }
        }
        int maxm = 0;

        // Find maximum of all the values
        // in dp[][] array to get the
        // maximum length
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                // Update the length
                maxm = Math.max(maxm, dp[i][j]);
            }
        }

        // Return the maximum length
        return maxm;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int A[] = { 1, 2, 8, 2, 1 };
        int B[] = { 8, 2, 1, 4, 7 };

        int n = A.length;
        int m = B.length;

        // Function call to find
        // maximum length of subarray
        System.out.print(FindMaxLength(A, B, n, m));
    }
}

// This code is contributed by PrinciRaj1992


package com.practice.dynamicprog;

class RodCutting
{
    /* Returns the best obtainable price for a rod of length
       n and price[] as prices of different pieces */
    static int cutRod(int price[], int n)
    {
        if (n <= 0)
            return 0;
        int max_val = Integer.MIN_VALUE;

        // Recursively cut the rod in different pieces and
        // compare different configurations
        for (int i = 0; i<n; i++) {

            System.out.println("max_val:" + max_val + "  ,n:" + n + ", i: "+i );

            int val = price[i] + cutRod(price, n - i - 1);



            max_val = Math.max(max_val, val);
            System.out.println("max_val:" + max_val);

        }
        return max_val;
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 5, 8, 9};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "+
                cutRod(arr, size));

    }


    //---------------------------------------------- below is the sample out to understand
    /**
     * max_val:-2147483648  ,n:4, i: 0
     * (max_val:-2147483648  ,n:3, i: 0
         * {max_val:-2147483648  ,n:2, i: 0
             * [max_val:-2147483648  ,n:1, i: 0
             * max_val:1 ]
         * max_val:2 }
         * {max_val:2  ,n:2, i: 1
         * max_val:5 }
     * max_val:6 )
     * max_val:6  ,n:3, i: 1
     * max_val:-2147483648  ,n:1, i: 0
     * max_val:1
     * max_val:6
     * max_val:6  ,n:3, i: 2
     * max_val:8
     * max_val:9
     * max_val:9  ,n:4, i: 1
     * max_val:-2147483648  ,n:2, i: 0
     * max_val:-2147483648  ,n:1, i: 0
     * max_val:1
     * max_val:2
     * max_val:2  ,n:2, i: 1
     * max_val:5
     * max_val:10
     * max_val:10  ,n:4, i: 2
     * max_val:-2147483648  ,n:1, i: 0
     * max_val:1
     * max_val:10
     * max_val:10  ,n:4, i: 3
     * max_val:10
     */
}
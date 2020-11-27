package com.practice.dynamicprog;

//https://www.geeksforgeeks.org/maximum-games-played-winner/
public class MaxGamePlayedByWinner {
    // method returns maximum games a winner needs
    // to play in N-player tournament
    static int maxGameByWinner(int N)
    {
        int[] dp = new int[N];

        // for 0 games, 1 player is needed
        // for 1 game, 2 players are required
        dp[0] = 1;
        dp[1] = 2;

        // loop until i-th Fibonacci number is
        // less than or equal to N
        int i = 2;
        do {
            dp[i] = dp[i - 1] + dp[i - 2];
        } while (dp[i++] <= N);

        // result is (i - 2) because i will be
        // incremented one extra in while loop
        // and we want the last value which is
        // smaller than N, so one more decrement
        return (i - 2);
    }

    // Driver code to test above methods
    public static void main(String args[])
    {
        int N = 23;
        System.out.println(maxGameByWinnerMyLogic(N));
    }

    static  int maxGameByWinnerMyLogic(int N){
        if(N == 0 || N ==1)
            return 0;
        if(N == 2)
            return 1;
        int finalReturn = 0;
        if(N > 2){
            int i = N;
            boolean flag = false;

            while(i > 1){
                if(i % 2 == 1)
                    flag = true;
                i= i/2;
                ++finalReturn;
            }

            if(flag)
                ++finalReturn;
        }

        return finalReturn;
    }
}
package Recursion;

import java.util.Arrays;
import java.util.Arrays.*;

public class FibannociSeries {
    static long dp[] = new long[101];
    public static void main(String[] args){
        Arrays.fill(dp,-1);
        for(int i=0;i<50;i++){
            System.out.println(i+1 + "->"+ fibnacci(i));
        }

    }
    public static long fibnacci(int n){
        if(n<=1){
            return n;
        }
        else {
            if(dp[n]==-1){
                dp[n]=fibnacci(n - 1) + fibnacci(n - 2);
            }
            return dp[n];
        }
    }
}

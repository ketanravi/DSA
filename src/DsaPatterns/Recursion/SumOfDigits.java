package src.DsaPatterns.Recursion;
/*
Given a positive number n. Find the sum of all the digits of n.

Examples:

Input: n = 687
Output: 21
Explanation: Sum of 687's digits: 6 + 8 + 7 = 21
Input: n = 12
Output 3
Explanation: Sum of 12's digits: 1 + 2 = 3
Constraints:
1 <= n <= 105
 */
public class SumOfDigits {
    static int sumOfDigits(int n) {
        return helper(n,0);
    }
    static int helper(int n, int sum){
        if(n==0){
            return sum;
        }
        int rem = n%10;
        sum+=rem;
        n = n/10;
        return helper(n,sum);
    }
}

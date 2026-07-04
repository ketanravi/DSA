package src.DsaPatterns.HashMap;
/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.


Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */
public class LongestPallindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
    public static int longestPalindrome(String s) {
        int[] freq = new int[128];

        for(char ch : s.toCharArray()){
            freq[ch]++;
        }
        int count = 0;
        boolean oddFound=false;

        for(int i=0;i<128;i++){
            count += (freq[i] / 2) * 2;

            if (freq[i] % 2 == 1) {
                oddFound = true;
            }
        }
        return oddFound ? count+1: count;
    }
}

package src.DsaPatterns.SlidingWindow;

import java.util.HashMap;

/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        /// keeping count of each charcter in t
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();

        while (end < chS.length) {
            // if charcter of s found in map
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            // if count==0 means all charcters of t present in current substring
            // while all chacters present calculte minimum
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                // if any charcters removed from current subtring, stop and again go to find next such substring which has all chars of t
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }
// return minm
        return minLen == Integer.MAX_VALUE ? new String() :
                new String(chS, startIndex, minLen);
    }
}

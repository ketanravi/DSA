package AlgoMaster.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
        Given two strings s and p, return an array of all the start indices of p's
        anagrams
         in s. You may return the answer in any order.



        Example 1:

        Input: s = "cbaebabacd", p = "abc"
        Output: [0,6]
        Explanation:
        The substring with start index = 0 is "cba", which is an anagram of "abc".
        The substring with start index = 6 is "bac", which is an anagram of "abc".
        Example 2:

        Input: s = "abab", p = "ab"
        Output: [0,1,2]
        Explanation:
        The substring with start index = 0 is "ab", which is an anagram of "ab".
        The substring with start index = 1 is "ba", which is an anagram of "ab".
        The substring with start index = 2 is "ab", which is an anagram of "ab".


        Constraints:

        1 <= s.length, p.length <= 3 * 104
        s and p consist of lowercase English letters.
 */
public class findAllAnagrams {
    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagramsOptimized(s, p));
    }

    //Brute force approach
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int windowSize = p.length();
        char[] arr = p.toCharArray();
        Arrays.sort(arr);
        p = new String(arr);

        for (int i = 0; i < s.length() - windowSize + 1; i++) {
            char[] temp = (s.substring(i, i + windowSize)).toCharArray();
            Arrays.sort(temp);
            String currString = new String(temp);
            if (currString.equals(p)) {
                res.add(i);
            }

        }
        return res;
    }

    public static List<Integer> findAnagramsOptimized(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int arr[] = new int[26];

        for (int i = 0; i < p.length(); i++) {
            arr[p.charAt(i) - 'a']++;
            System.out.println(arr[p.charAt(i) - 'a']);
        }
        int i = 0, j = 0;
        int windowSize = p.length();
        while (j < s.length() - windowSize + 1) {
            i = j;
            int compArr[] = new int[26];
            while (i < j + windowSize) {
                if (arr[s.charAt(i) - 'a'] == 0 || arr[s.charAt(i) - 'a'] <= compArr[s.charAt(i) - 'a']) {
                    break;
                } else {
                    compArr[s.charAt(i) - 'a']++;

                    if (i == j + windowSize - 1) {
                        res.add(j);
                    }
                    i++;
                }
            }
            j++;
        }
        return res;
    }

    public static List<Integer> findAnagramsUsingArray(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        // Frequency arrays for s and p
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Initialize the frequency arrays
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Sliding window over s
        for (int i = 0; i <= s.length() - p.length(); i++) {
            // Check if the current window is an anagram
            if (areArraysEqual(pCount, sCount)) result.add(i);

            // Slide the window
            if (i + p.length() < s.length()) {
                sCount[s.charAt(i) - 'a']--; // Remove old char from the count
                sCount[s.charAt(i + p.length()) - 'a']++; // Add new char to the count
            }
        }

        return result;
    }

    private static boolean areArraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

}

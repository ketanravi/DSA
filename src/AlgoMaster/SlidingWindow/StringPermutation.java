package AlgoMaster.SlidingWindow;
/*
        Given two strings s1 and s2, return true if s2 contains a
        permutation
         of s1, or false otherwise.

        In other words, return true if one of s1's permutations is the substring of s2.



        Example 1:

        Input: s1 = "ab", s2 = "eidbaooo"
        Output: true
        Explanation: s2 contains one permutation of s1 ("ba").
        Example 2:

        Input: s1 = "ab", s2 = "eidboaoo"
        Output: false


        Constraints:

        1 <= s1.length, s2.length <= 104
        s1 and s2 consist of lowercase English letters.
 */
public class StringPermutation {
    public static void main(String[] args){
       String s1 = "bb", s2 = "eidbaooo";
       System.out.println(checkInclusion(s1,s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        // Frequency arrays for s and p
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Initialize the frequency arrays
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Sliding window over s
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            // Check if the current window is an anagram
            if (areArraysEqual(s1Count, s2Count)) return true;

            // Slide the window
            if (i + s1.length() < s2.length()) {
                s2Count[s2.charAt(i) - 'a']--; // Remove old char from the count
                s2Count[s2.charAt(i + s1.length()) - 'a']++; // Add new char to the count
            }
        }

        return false;
    }

    private static boolean areArraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}

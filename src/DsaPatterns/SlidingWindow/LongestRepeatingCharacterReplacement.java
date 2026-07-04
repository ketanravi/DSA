package src.DsaPatterns.SlidingWindow;
/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 */
public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int low=0;
        int lookup[] =new int[26];
        int max=0;
        int res=0;

        for(int high=0;high<n;high++){
            lookup[s.charAt(high)-65]++;

            max = Math.max(max,lookup[s.charAt(high)-65]);// chracter len with most number of occurance
            int len = high-low+1;// current window length

            while(high-low+1-max > k){
                // this means the no. of replacements is more than
                // allowed (k)
                // Decrementing the count of the character which was
                // at low because it is no longer in the window
                lookup[s.charAt(low) - 65]--;
                low++;
            }
            res = Math.max(res,high-low+1);
        }
        return res;
    }
}

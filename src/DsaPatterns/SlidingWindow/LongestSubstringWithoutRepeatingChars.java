package src.DsaPatterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s, find the length of the longest substring without duplicate characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int low=0,n=s.length();
        int res=0;
        if(n<=1)
            return n;
        Map<Character,Integer> hmap = new HashMap<>();
        for(int high=0;high<n;high++){
            char c = s.charAt(high);
            hmap.put(c,hmap.getOrDefault(c,0)+1);
            int currLen = high-low+1;
            while(hmap.size()<currLen){

                hmap.put(s.charAt(low),hmap.getOrDefault(s.charAt(low),0)-1);
                if(hmap.getOrDefault(s.charAt(low),0)==0){
                    hmap.remove(s.charAt(low));
                }
                low++;
                currLen=high-low+1;
            }

            res = Math.max(res,high-low+1);
        }
        return res;

    }
}

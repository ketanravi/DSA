package AlgoMaster.TwoPointers;
import java.util.*;
/*
Given a string s, find the length of the longest substring without duplicate characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
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
public class MaxLenNonRepeatingChar {
    public static int lengthOfLongestSubstring(String s) {
        int l,r;
        l=r=0;
        int len=0,maxlen=0;

        int hash[] = new int[255];
        Arrays.fill(hash,-1);
        if(r==1)
            return r;
        while(r<s.length()){
            if(hash[s.charAt(r)]!=-1){
                if(hash[s.charAt(r)]>=l){
                    l=hash[s.charAt(r)]+1;
                }
            }

            len = r-l+1;
            maxlen = Math.max(maxlen,len);
            hash[s.charAt(r)]=r;
            r++;


        }
        return maxlen;
    }
    public static void main (String[] args){
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}

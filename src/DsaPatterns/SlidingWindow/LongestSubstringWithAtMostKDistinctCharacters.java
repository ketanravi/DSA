package src.DsaPatterns.SlidingWindow;
/*
Given a string s and an integer k.Find the length of the longest substring with at most k distinct characters.


Example 1

Input : s = "aababbcaacc" , k = 2

Output : 6

Explanation : The longest substring with at most two distinct characters is "aababb".

The length of the string 6.

Example 2

Input : s = "abcddefg" , k = 3

Output : 4

Explanation : The longest substring with at most three distinct characters is "bcdd".

The length of the string 4.

Constraints

1 <= s.length <= 105
1 <= k <= 26

 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int kDistinctChar(String s, int k) {
        // hash lookup
        int[] hash = new int[26];

        int n = s.length();
        int cnt=0;
        int res = -1;

        int left=0,right=0;

        while(right<n){
            // if the characters are distinct that is its count are still zero in hash then only increase count
            if(hash[s.charAt(right)-97]==0){
                cnt++;
            }
            // increase the count in hash array
            hash[s.charAt(right)-97]++;

            // while cnt is greater than k, then remove elements from left one by one once the count of elemnets becomes 0 decrement count
            while(cnt>k && left<right){
                hash[s.charAt(left)-97]--;
                if(hash[s.charAt(left)-97]==0){
                    cnt--;
                }
                left++;
            }

            // whenever cnt is less than or equal to k, calculate current max length becuayse question asks for atmost k
            if(cnt<=k){
                res = Math.max(res,right-left+1);
            }
            right++;

        }
        return res;
    }
}

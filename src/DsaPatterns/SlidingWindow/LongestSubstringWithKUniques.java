package src.DsaPatterns.SlidingWindow;
/*
You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

Note : If no such substring exists, return -1.

Examples:

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.
Constraints:
1 ≤ s.size() ≤ 105
1 ≤ k ≤ 26
 */
public class LongestSubstringWithKUniques {
    public int longestKSubstr(String s, int k) {
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
            // whenever cnt is equal to k, calculate current max length becuayse question asks for atmost k
            if(cnt==k){
                res = Math.max(res,right-left+1);
            }
            right++;

        }
        return res;

    }
}

package src.DsaPatterns.Recursion;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.



Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]


Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
    public static List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        helper(s,0,temp,res);
        return res;

    }
    public static void helper(String s, int index, List<String> temp, List<List<String>> res){
        if(index==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrom(s,index,i)){
                temp.add(s.substring(index,i+1));
                helper(s,i+1,temp,res);
                temp.removeLast();
            }
        }
    }

    private static boolean isPalindrom(String s, int start, int end) {
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}

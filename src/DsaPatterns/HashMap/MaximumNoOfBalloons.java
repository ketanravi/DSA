package src.DsaPatterns.HashMap;
/*
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.



Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0


Constraints:

1 <= text.length <= 104
text consists of lower case English letters only.
 */
public class MaximumNoOfBalloons {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }
    public static int maxNumberOfBalloons(String text) {
        int[] requiredCharFreq = new int[26];
        requiredCharFreq['b'-'a']=1;
        requiredCharFreq['a'-'a']=1;
        requiredCharFreq['l'-'a']=2;
        requiredCharFreq['o'-'a']=2;
        requiredCharFreq['n'-'a']=1;


        int[] givenCharFreq = new int[26];


        int n = text.length();

        for(int i=0;i<n;i++){
            int charIndx = text.charAt(i)-'a';
            givenCharFreq[charIndx]++;
        }
        int intancesFormed = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            int requiredFreq = requiredCharFreq[i];
            if(requiredFreq!=0){
                int currLenFreq = givenCharFreq[i];
                intancesFormed = Math.min(intancesFormed,currLenFreq/requiredFreq);
            }
        }
        return intancesFormed != Integer.MAX_VALUE ? intancesFormed : 0;

    }
}

package src.DsaPatterns.Recursion;
/*
Given a string s and a character c. The task is to remove all the occurrences of the character in the string.

Examples:

Input: s = "geeksforgeeks", c = 'e'
Output: s = "gksforgks"
Input: s = "geeksforgeeks", c = 'g'
Output: s = "eeksforeeks"
Constraints:
1 <= |s| <= 105
 */
public class RemoveCharFromString {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("geeksforgeeks");
        removeCharacter(s,'e');
        System.out.println(s.toString());

    }
    public static void removeCharacter(StringBuilder s, char c) {
        helper(s,c,0);

    }
    public static void helper(StringBuilder s, char c, int i){
        if(i==s.length())
            return;
        if(s.charAt(i)==c){
            s.deleteCharAt(i);
            helper(s,c,i);
        }
        else
            helper(s,c,i+1);
    }
}

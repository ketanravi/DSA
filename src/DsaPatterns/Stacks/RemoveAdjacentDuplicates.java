package src.DsaPatterns.Stacks;

import java.util.Stack;

/*
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.



Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
 */
public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("azxxzy"));
    }
    //optimized
    public static String removeDuplicates2(String s) {
        char[] stack = new char[s.length()];
        int top=-1;
        int i=0;
        for(char c: s.toCharArray()){
            if(top!=-1 && c==stack[top]){
                top--;
            }
            else
                stack[++top]=c;
        }

        return new String(stack,0,top+1);
    }

    public static String removeDuplicates(String s) {

         StringBuilder sb = new StringBuilder();
         Stack<Character> sc = new Stack<>();
         int i=0;
         while(i<s.length()){
             if(!sc.empty() && s.charAt(i)==sc.peek()){
                 sc.pop();
             }
             else
                 sc.push(s.charAt(i));
             i++;
         }
         while(!sc.isEmpty()){
             sb.append(sc.pop());
         }
         return sb.reverse().toString();


    }
}

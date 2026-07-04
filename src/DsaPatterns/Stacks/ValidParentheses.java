package src.DsaPatterns.Stacks;
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false



Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(("));
    }
    public static boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top=-1;

        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack[++top]=c;
            }
            else{
                if(top!=-1 && (c == ')' && stack[top] == '(') || (c == '}' && stack[top] == '{') || (c == ']' && stack[top] == '[')){
                    top--;
                }
                else{
                    stack[++top]=c;
                }
            }
        }
        if(top==-1)
            return true;
        else
            return false;

    }
}

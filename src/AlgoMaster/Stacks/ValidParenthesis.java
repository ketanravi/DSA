package AlgoMaster.Stacks;

import java.util.Stack;

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



        Constraints:

        1 <= s.length <= 104
        s consists of parentheses only '()[]{}'.
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "(){}}{";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s){
        if(s.length()%2!=0)
            return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if( c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else{
                if(stack.empty()
                        || (( c ==')' && stack.pop() != '(')
                        || ( c ==']' && stack.pop() != '[')
                        ||( c =='}' && stack.pop() != '{')
                )
                )
                {
                    return false;
                }
            }

        }
        return stack.empty();
    }
}

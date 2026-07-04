package src.DsaPatterns.Recursion;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve(res,new StringBuilder(),0,0,n);
        return res;

    }
    public static void solve (List<String> result, StringBuilder sb, int open, int close, int n) {

        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            solve (result, sb, open+1, close, n);
            sb.deleteCharAt(sb.length()-1);
        }

        if (close < open) {
            sb.append(')');
            solve (result, sb, open, close+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

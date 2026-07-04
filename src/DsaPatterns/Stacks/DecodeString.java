package src.DsaPatterns.Stacks;

import java.util.Stack;

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"


Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].


rough: 3[a]

a





b
c
]
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }
    public static String decodeString(String s) {
            Stack<Integer> st = new Stack<>();
            Stack<StringBuilder> st1 = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int n = 0;

            for (char c : s.toCharArray()) {
                // if digit build the multi digit number
                if (Character.isDigit(c)) {
                    n = n * 10 + (c - '0');
                } else if (c == '[') {// if [ Push the current string and count onto their respective stacks.Reset the current string and count.
                    st.push(n);
                    n = 0;
                    st1.push(sb);
                    sb = new StringBuilder();
                } else if (c == ']') {// if ], we need to repeat the current string. k(from one stack) times
                    int k = st.pop();
                    StringBuilder temp = sb;
                    sb = st1.pop();
                    while (k-- > 0) {// repeating
                        sb.append(temp);
                    }
                } else {// if character need to prepare string
                    sb.append(c);
                }
            }

            return sb.toString();


    }
}

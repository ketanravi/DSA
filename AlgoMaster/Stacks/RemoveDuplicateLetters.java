package AlgoMaster.Stacks;

import java.util.Stack;

/*
        Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.



        Example 1:

        Input: s = "bcabc"
        Output: "abc"
        Example 2:

        Input: s = "cbacdcbc"
        Output: "acdb"


        Constraints:

        1 <= s.length <= 104
        s consists of lowercase English letters.

 */
public class RemoveDuplicateLetters {
    public static void main(String[] args){
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));

    }
    public static String removeDuplicateLetters(String s){
        int lastIndex[] = new int[26];
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a'] = i;// keeping track of last occurrence index in string for each character e.g abcca : a = 4, b = 1, c = 3
        }

        int visited[] = new int[26]; // to check if character is already visited and is present in stack before pushing it
        Stack<Character> st = new Stack<>();


        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(visited[ch-'a']==1){
                continue;// if already added in stack ignore and move to next character in given string
            }
            while(!st.empty() && st.peek()>ch && lastIndex[st.peek()-'a']>i){
                visited[st.pop()-'a'] = 0; // while stack is not empty and top of stack element is greater than current character and last occurrence index of top of stack element is greater than current index in string,
                                            // pop the element from stack
            }
            st.push(ch); // push the new element in stack
            visited[ch-'a']=1; // mark the character as visited bcoz it is pushed to stack
        }

        // creating result from stack elements
        StringBuilder result = new StringBuilder();
        for (char c : st) {
            result.append(c);
        }

        return result.toString();

    }
}

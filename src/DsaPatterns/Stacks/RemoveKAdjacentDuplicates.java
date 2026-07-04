package src.DsaPatterns.Stacks;

import java.util.Stack;

/*
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.



Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"


Constraints:

1 <= s.length <= 105
2 <= k <= 104
s only contains lowercase English letters.
 */
public class RemoveKAdjacentDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("pbbcggttciiippooaais",2));
    }
    public static String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(!st.empty()){
                Pair<Character,Integer> currPair = st.peek();
                if(currPair.key()==c && currPair.value()==k-1){
                    st.pop();
                }
                else{
                    Pair<Character,Integer> newPair;
                    if(currPair.key()==c){
                        newPair = new Pair<>(currPair.key(),currPair.value()+1);
                        st.pop();
                    }
                    else{
                        newPair = new Pair<>(c,1);
                    }
                    st.push(newPair);

                }
            }
            else{
                st.push(new Pair<>(c,1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.empty()){
            Pair<Character,Integer> p = st.pop();
            int i=0;
            while(i<p.value()){
                sb.append(p.key());
                i++;
            }

        }
        return sb.reverse().toString();

    }
}

record Pair<Character, Integer>(Character key, Integer value) {

}

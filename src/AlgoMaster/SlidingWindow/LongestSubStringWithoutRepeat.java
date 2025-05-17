package AlgoMaster.SlidingWindow;

import java.util.HashMap;

/*
        Given a string s, find the length of the longest
        substring
         without repeating characters.



        Example 1:

        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
        Example 2:

        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.
        Example 3:

        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


        Constraints:

        0 <= s.length <= 5 * 104
        s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubStringWithoutRepeat {
    public static void main(String[] args){
        String s = "aaaabcd";
        System.out.println(lengthOfNonRepeatingLongestSubstring(s));
    }
    public static int lengthOfNonRepeatingLongestSubstring(String s){
        HashMap<Character,Integer> hmap= new HashMap<>();
        int res=0;
        int left=0;
        int i;
        for(i = 0; i<s.length(); i++){
            // if not present in map add
            if(!hmap.containsKey(s.charAt(i)) || hmap.get(s.charAt(i))==0){
                hmap.put(s.charAt(i),1);
            }
            else{
                // first repeating so calculating possible ans till now
                res=Math.max(res,i-left);
                // while not found repeater char
                while(i!=left){
                    // if found match decrease count from map and increase left pointer and break;
                    if(s.charAt(left)==s.charAt(i)){
                        hmap.put(s.charAt(left),hmap.get(s.charAt(left))-1);
                        left++;
                        break;
                    }
                    // else if move left and decrease count from map
                    else{
                        hmap.put(s.charAt(left),hmap.get(s.charAt(left))-1);
                        left++;
                    }

                }
                // add new character to map
                hmap.put(s.charAt(i),hmap.get(s.charAt(i))+1);

            }

        }
        //at last return result which ever is max
        return Math.max(res,i-left);


    }
}

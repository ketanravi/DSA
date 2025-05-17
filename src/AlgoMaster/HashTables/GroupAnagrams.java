package AlgoMaster.HashTables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
/*
        Given an array of strings strs, group the
        anagrams
         together. You can return the answer in any order.



        Example 1:4

        Input: strs = ["eat","tea","tan","ate","nat","bat"]

        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        Explanation:

        There is no string in strs that can be rearranged to form "bat".
        The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
        The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
        Example 2:

        Input: strs = [""]

        Output: [[""]]

        Example 3:

        Input: strs = ["a"]

        Output: [["a"]]



        Constraints:

        1 <= strs.length <= 104
        0 <= strs[i].length <= 100
        strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {
    public static void main(String[] args){
        String[] strs = {"cat","dog","tac","god","act"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmap = new HashMap<>();
        for (String word : strs) {
            int count[] = new int[26];

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                keyBuilder.append('#');
                keyBuilder.append(count[i]);
            }
            String key = keyBuilder.toString();
            if (hmap.containsKey(key)) {
                hmap.get(key).add(word);
            } else {
                ArrayList arr = new ArrayList<>();
                arr.add(word);
                hmap.put(key, arr);
            }

        }
        return new ArrayList<>(hmap.values());
    }
    public List<List<String>> groupAnagramsSortingTechnique(String[] strs) {
        HashMap<String,List<String>> hmap = new HashMap<>();
        for(String word : strs){
            char[] charArray = word.toCharArray();
            // Sort the array
            Arrays.sort(charArray);
            // Convert back to string
            String sortedWord = new String(charArray);
            if(hmap.containsKey(sortedWord)){
                hmap.get(sortedWord).add(word);
            }
            else{
                ArrayList arr = new ArrayList<>();
                arr.add(word);
                hmap.put(sortedWord,arr);
            }

        }
        return new ArrayList<>(hmap.values());
    }
}

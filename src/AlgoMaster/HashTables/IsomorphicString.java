package AlgoMaster.HashTables;
/*
        Given two strings s and t, determine if they are isomorphic.

        Two strings s and t are isomorphic if the characters in s can be replaced to get t.

        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

        Example 1:

        Input: s = "egg", t = "add"

        Output: true

        Explanation:

        The strings s and t can be made identical by:

        Mapping 'e' to 'a'.
        Mapping 'g' to 'd'.
        Example 2:

        Input: s = "foo", t = "bar"

        Output: false

        Explanation:

        The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

        Example 3:

        Input: s = "paper", t = "title"

        Output: true



        Constraints:

        1 <= s.length <= 5 * 104
        t.length == s.length
        s and t consist of any valid ascii character.
 */
public class IsomorphicString {
    public static void main(String[] args){
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s,t));

    }
    public static boolean isIsomorphic(String s, String t) {
        int l1 = s.length();
        if(l1 != t.length())
            return false;// if length are not equal return false

        //creating array to insert all characters
        int arr1[] = new int[256];
        int arr2[] = new int[256];

        for(int i=0;i<l1;i++){

            if(arr1[s.charAt(i)]!=arr2[t.charAt(i)]){
                return false;// if at any place count is not equal i.e means we cannot replace s with t
                // for example in foo & bar -> f and b count are same, o and a count same , o again and r here count mismatch
            }
            arr1[s.charAt(i)] = i+1;//counting each occurrence in array 1
            arr2[t.charAt(i)] = i+1;//counting each occurrence in array 2
        }
        return true;
    }
}

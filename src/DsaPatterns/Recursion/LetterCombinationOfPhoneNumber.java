package src.DsaPatterns.Recursion;
/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.




Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

1 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));

    }
    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> hmap = new HashMap<>();
        hmap.put('2',"abc");
        hmap.put('3',"def");
        hmap.put('4',"ghi");
        hmap.put('5',"jkl");
        hmap.put('6',"mno");
        hmap.put('7',"pqrs");
        hmap.put('8',"tuv");
        hmap.put('9',"wxyz");

        List<String> res= new ArrayList<>();

        helper(digits,digits.length(),0,new StringBuilder
                (),res,hmap);
        return res;

    }
    public static void helper(String digits, int n, int idx,StringBuilder temp, List<String> res,HashMap<Character, String> hmap ){
        if(idx==n)
        {
            res.add(temp.toString());
            return;
        }
        String choice = hmap.get(digits.charAt(idx));
        for(int i=0;i<choice.length();i++){
            temp.append(choice.charAt(i));
            helper(digits,n,idx+1,temp,res,hmap);
            temp.deleteCharAt(temp.length()-1);
        }
        return;
    }
}

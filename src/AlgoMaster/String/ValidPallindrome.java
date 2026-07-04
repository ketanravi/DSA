package AlgoMaster.String;
/*
        A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

        Given a string s, return true if it is a palindrome, or false otherwise.



        Example 1:

        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.
        Example 2:

        Input: s = "race a car"
        Output: false
        Explanation: "raceacar" is not a palindrome.
        Example 3:

        Input: s = " "
        Output: true
        Explanation: s is an empty string "" after removing non-alphanumeric characters.
        Since an empty string reads the same forward and backward, it is a palindrome.


        Constraints:

        1 <= s.length <= 2 * 105
        s consists only of printable ASCII characters.
 */
public class ValidPallindrome {
    public static void main(String[] args){

    }
    public static boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        s = s.toLowerCase();
        while(i<j){
            if((s.charAt(i)>=97 && s.charAt(i)<=122) || (s.charAt(i)>=48 && s.charAt(i)<=57))
            {
                if((s.charAt(j)>=97 && s.charAt(j)<=122) || (s.charAt(j)>=48 && s.charAt(j)<=57)){
                    if(s.charAt(j)==s.charAt(i)){
                        i++;j--;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    j--;
                }
            }
            else{
                i++;
            }
        }
        return true;
    }
}

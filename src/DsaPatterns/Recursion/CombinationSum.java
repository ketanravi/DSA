package src.DsaPatterns.Recursion;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []


Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(0,candidates,target,res,ans);
        return res;

    }
    public static void helper(int i,int[] candidates, int target, List<List<Integer>> res, List<Integer> temp){

        if(i == candidates.length){
            if(target==0)
                res.add(new ArrayList<>(temp));
            return;
        }
        if(candidates[i]<=target){
            temp.add(candidates[i]);
            helper(i,candidates,target-candidates[i],res,temp);
            temp.removeLast();
        }
        helper(i+1,candidates,target,res,temp);
    }

    /*
    1)Here every element is a stage
    2)Indexes
    3)Choice kya hai
        a)Nhi lena hai yani sidhe next index no change
        b)lena hai or hm ek hi element ko bar bar le sakte hai isliye next index pe nhi jayenge
    4) jb sare stage khatam ho jaye answer mil jayega

     */
}

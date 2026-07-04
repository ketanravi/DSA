package src.DsaPatterns.Recursion;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

1,2,3
 */
public class Permutation {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        helper(nums,nums.length,temp,res,isVisited);
        return res;



    }

    public static void helper(int[] nums, int n, List<Integer> temp, List<List<Integer>> res, boolean[] isVisited){

        if(temp.size()==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                temp.add(nums[i]);
                isVisited[i]=true;
                helper(nums,n,temp,res,isVisited);
                temp.remove(temp.size()-1);
                isVisited[i]=false;
            }
        }
        return;

    }

}

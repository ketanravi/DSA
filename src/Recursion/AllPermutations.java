package Recursion;

/*
        Given an array nums of distinct integers, return all the possible
        permutations
        . You can return the answer in any order.



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
 */
import java.util.ArrayList;
import java.util.List;

public class AllPermutations {
    public static void main(String[] args){
        int nums[] = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freqMap = new boolean[nums.length]; // creating a freqmap to check if element processed.
        solve(nums,ds,ans,freqMap);
        System.out.println(ans);
    }
    public static void solve(int nums[], List<Integer> ds, List<List<Integer>> ans,boolean freqMap[]){
        // when all elements processed and one answer is ready we need to add to answers list - base case;
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        // processing each element
        for(int i=0;i<nums.length;i++){
            // if element not processed
            if(!freqMap[i]){
                //add number to generate permutation
                ds.add(nums[i]);
                // mark as processed because that number is used now for next recursion
                freqMap[i]=true;
                // calling recursion
                solve(nums,ds,ans,freqMap);
                // while backtrack removing added number from permutation for generating next other permutation options without above elements
                ds.remove(ds.size()-1);
                // also marking it as not processed so that right recursion can also use that number
                freqMap[i]=false;
            }
        }
    }
}

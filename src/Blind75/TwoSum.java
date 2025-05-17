package Blind75;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String args[]){
        int nums[] = {2,7,11,15};
        int target = 13;
        int result[] =(getPairsHavingTargetSum(nums,target));
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }


    }

    //most optimal if need index otherwise if it need to be answered in yes no sort array and use two pointer
    private static int[] getPairsHavingTargetSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}

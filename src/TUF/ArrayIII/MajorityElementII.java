package src.TUF.ArrayIII;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of size n. Return all elements which appear more than n/3 times in the array. The output can be returned in any order.


Example 1

Input: nums = [1, 2, 1, 1, 3, 2]

Output: [1]

Explanation:

Here, n / 3 = 6 / 3 = 2.

Therefore the elements appearing 3 or more times is : [1]

Example 2

Input: nums = [1, 2, 1, 1, 3, 2, 2]

Output: [1, 2]

Explanation:

Here, n / 3 = 7 / 3 = 2.

Therefore the elements appearing 3 or more times is : [1, 2]
Constraints

n == nums.length.
2 <= n <= 105
-104 <= nums[i] <= 104
 */
public class MajorityElementII {
    public static void main(String[] args) {
        int nums[] = {1, 2, 1, 1, 3, 2, 2};
        System.out.println(majorityElementTwo(nums));

    }

    public static List<Integer> majorityElementTwo(int[] nums) {
        int ele1=Integer.MIN_VALUE,ele2=Integer.MIN_VALUE,cnt1=0,cnt2=0;
        int n = nums.length;
        List<Integer> res = new ArrayList<>(2);

        for(int i=0;i<n;i++){
            if(cnt1==0 && nums[i]!=ele2){
                ele1=nums[i];
                cnt1++;
            }
            else if(cnt2==0 && nums[i]!=ele1){
                ele2=nums[i];
                cnt2++;
            }
            else if(nums[i]==ele1){
                cnt1++;
            }
            else if(nums[i]==ele2){
                cnt2++;
            }
            else{
                cnt1--; cnt2--;
            }
        }
        cnt1=0;cnt2=0;
        for(int i=0;i<n;i++){
            if(ele1==nums[i]) cnt1++;
            if(ele2==nums[i]) cnt2++;
        }

        if(cnt1>n/3)
            res.add(ele1);
        if(cnt2>n/3)
            res.add(ele2);

        return res;

    }
}

package AlgoMaster.TwoPointers;
/*
        Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



        Example 1:


        Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
        Output: 6
        Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
        Example 2:

        Input: height = [4,2,0,3,2,5]
        Output: 9


        Constraints:

        n == height.length
        1 <= n <= 2 * 104
        0 <= height[i] <= 105
 */
public class TrappingRainWater {
    public static void main(String[] args){
        int nums[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }
    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            // Move the pointer with the smaller height
            if (height[left] < height[right]) {
                // If left is smaller, check against leftMax
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                // If right is smaller, check against rightMax
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }

        return trappedWater;
    }
}

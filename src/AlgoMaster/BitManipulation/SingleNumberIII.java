package AlgoMaster.BitManipulation;
/*
        Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

        You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.



        Example 1:

        Input: nums = [1,2,1,3,2,5]
        Output: [3,5]
        Explanation:  [5, 3] is also a valid answer.
        Example 2:

        Input: nums = [-1,0]
        Output: [-1,0]
        Example 3:

        Input: nums = [0,1]
        Output: [1,0]


        Constraints:

        2 <= nums.length <= 3 * 104
        -231 <= nums[i] <= 231 - 1
        Each integer in nums will appear twice, only two integers will appear once.
 */
public class SingleNumberIII {
    public static void main(String[] args){
        int nums [] = { 1,2,1,3,2,5};
        int res[] = findSingleNumbers(nums);
        System.out.println(res[0] +" " + res[1]);
    }
    public static int[] findSingleNumbers(int[] nums) {
        // HashMap<Integer,Integer> hmap = new HashMap<>();
        // int res [] = new int[2];

        // for(int i=0;i<nums.length;i++){
        //     if(hmap.containsKey(nums[i])){
        //         hmap.put(nums[i],hmap.get(nums[i])+1);
        //     }
        //     else{
        //         hmap.put(nums[i],1);
        //     }
        // }
        // int i=0;
        // for(Map.Entry<Integer,Integer> entry : hmap.entrySet()){
        //     if(entry.getValue()==1){
        //         res[i++]= entry.getKey();
        //     }
        // }
        // return res;




        /// /// ##########  OPTIMIZED with O(1) space  ##############/// ///




        // First find xor of both number who are unique because two eqaul will cancel out each other because x xor  x is 0;
        int xorOfUniques = nums[0];
        for(int i=1;i<nums.length;i++){
            xorOfUniques = xorOfUniques ^ nums[i]; // 1 ^ 2 ^ 1 ^ 3 ^ 2 ^ 5 (Rule 1^1 =0 and 1^0 =1)
        }
        // xorOfUniques = 3^5 -> 011 ^ 101 =  110 i.e 6
        // find first bit position from right whose bit is set that is 1
        int rightMostSetBit = xorOfUniques & (-xorOfUniques); // 110 & -(110) = 110 & 010 (2's complement) = 010
        int x=0,y=0;
        // now divide array in two groups first whose rightMostSetBits is set and other whose not
        for(int i=0;i<nums.length;i++){
            //nums whose rightmostsetbit position is not set 1, 2, 1 ,3 ,2 ,5 = 001, 010, 001, 011, 010, 101
            if((rightMostSetBit & nums[i] )== 0){// 001, 001, 101 -> 1 ,1,5 -> For these number right most set position we found were are not set
                x = x^ nums[i];// 1 ^ 1 ^ 5 = 5
            }
            //nums whose rightmostsetbit position is set
            else{// 010 , 011, 010 -> 2,3,2
                y = y ^ nums[i]; // 2 ^ 3 ^ 2 = 3
            }
        }
        return new int[]{x,y};// 5,3

    }
}

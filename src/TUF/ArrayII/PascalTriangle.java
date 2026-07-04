package src.TUF.ArrayII;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer n, return the first n (1-Indexed) rows of Pascal's triangle.



In Pascal's triangle:

The first row has one element with a value of 1.
Each row has one more element in it than its previous row.
The value of each element is equal to the sum of the elements directly above it when arranged in a triangle format.

Example 1

Input: n = 4

Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]

Explanation: The Pascal's Triangle is as follows:

1

1 1

1 2 1

1 3 3 1

1st Row has its value set to 1.

All other cells take their value as the sum of the values directly above them

Example 2

Input: n = 5

Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]

Explanation: The Pascal's Triangle is as follows:

1

1 1

1 2 1

1 3 3 1

1 4 6 4 1

1st Row has its value set to 1.

All other cells take their value as the sum of the values directly above them
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int n=5;
        List<List<Integer>> res = pascalTriangleIII(n);
        System.out.print("[");
        for(List<Integer> nums: res){
            System.out.print("[");
            for(int i=0;i<nums.size();i++){
                System.out.print(nums.get(i));
                if(i!=nums.size()-1){
                    System.out.print(",");
                }
            }
            System.out.print("]");

        }
        System.out.println("]");
    }
    public static List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> temp = new ArrayList<>(i+1);
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    temp.add(1);
                }
                else{
                    int currEle = res.get(i-1).get(j-1)+res.get(i-1).get(j);
                    temp.add(currEle);
                }
            }
            res.add(temp);
        }

        return res;
    }
}

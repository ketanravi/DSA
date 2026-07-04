package AlgoMaster.TwoDimensionalArray;
/*
    Given an m x n matrix, return all elements of the matrix in spiral order.

    Example 1:


    Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    Output: [1,2,3,6,9,8,7,4,5]
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args){
        int twoDArray[][] ={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(getSpiralPath(twoDArray));

    }
    public static List<Integer> getSpiralPath(int arr[][]){
        int left=0;
        int right = arr[0].length-1;
        int top = 0;
        int bottom = arr.length-1;

        List<Integer> res = new ArrayList<>();
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                res.add(arr[top][i]);
            }
            top++;

            for(int i=top;i<=bottom;i++){
                res.add(arr[i][right]);
            }
            right--;

            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    res.add(arr[bottom][i]);
                }
                bottom--;
            }

            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    res.add(arr[i][left]);
                }
                left++;
            }

        }
        return res;

    }
}

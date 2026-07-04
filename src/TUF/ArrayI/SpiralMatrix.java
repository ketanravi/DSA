package src.TUF.ArrayI;

import java.util.ArrayList;
import java.util.List;


/*

    Given an M * N matrix, print the elements in a clockwise spiral manner.
    Return an array with the elements in the order of their appearance when printed in a spiral manner.


    Example 1

    Input: matrix = [[1, 2, 3], [4 ,5 ,6], [7, 8, 9]]

    Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]

    Explanation:

    The elements in the spiral order are 1, 2, 3 -> 6, 9 -> 8, 7 -> 4, 5

    Example 2

    Input: matrix = [[1, 2, 3, 4], [5, 6, 7, 8]]

    Output: [1, 2, 3, 4, 8, 7, 6, 5]

    Explanation:

    The elements in the spiral order are 1, 2, 3, 4 -> 8, 7, 6, 5

    Constraints:
        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 100
        -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4 ,5 ,6}, {7, 8, 9}};
        List<Integer> flattedRes = spiralOrder(matrix);
        for(int num: flattedRes){
            System.out.print(num+" ");
        }

    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        int left=0,top=0;
        int right=colLen-1,bottom=rowLen-1;

        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }

        }
        return res;

    }
}

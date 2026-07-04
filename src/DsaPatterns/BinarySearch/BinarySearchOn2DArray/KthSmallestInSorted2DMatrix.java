package src.DsaPatterns.BinarySearch.BinarySearchOn2DArray;

public class KthSmallestInSorted2DMatrix {
    public static void main(String[] args) {
        int matrix[][] = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(matrix,8));
    }
    public static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res=-1;
        int low = matrix[0][0], high = matrix[m-1][n-1];

        while(low<=high){
            int guess = low+(high-low)/2;
            if(numberOfElementSmaller(matrix,k,m,n,guess)>=k){// go left till equal because it can be equal only if itself included
                res=guess;
                high=guess-1;
            }
            else{
                low=guess+1;
            }

        }
        return res;
    }
    public static int numberOfElementSmaller(int[][] matrix, int k, int m, int n, int guess){
        int row = m-1, col = 0;
        int count=0;

        while(row>=0 && col<n){
            if(matrix[row][col]<=guess){
                count=count+row+1;
                col++;
            }
            else{
                row--;
            }
        }
        return count;
    }
}

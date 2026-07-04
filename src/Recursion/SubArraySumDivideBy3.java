package Recursion;

public class SubArraySumDivideBy3 {
    public static void main(String[] args) {
        int arr[] = {4,5,6,6};
        int count = 0;
        for(int i=0;i<arr.length;i++){
            count+=subArraySumDivideBy3(arr, i, 0);
        }
    }
    public static int subArraySumDivideBy3(int arr[], int i, int sum){
        System.out.println(sum);
        if(i==arr.length){
            if(sum !=0 && sum%3==0){
                return 1;
            }
            return 0;
        }
        else if(sum !=0 && sum % 3 == 0){
            System.out.println(sum);
            return 1+subArraySumDivideBy3(arr, i+1, sum+arr[i]);
        }
        else{
            return subArraySumDivideBy3(arr, i+1, sum+arr[i]);
        }
    }
}

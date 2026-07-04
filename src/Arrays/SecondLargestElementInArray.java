package Arrays;

public class SecondLargestElementInArray {
    public static int findSecondLargestElement(int arr[]){
        int largest =  arr[0], secondLargest = -1;
//        for(int i=1;i<arr.length;i++){
//            if(arr[i]>largest){
//                largest = arr[i];
//            }
//        }
//        for(int i=1;i<arr.length;i++){
//            if(arr[i]!=largest && arr[i]>secondLargest){
//                secondLargest = arr[i];
//            }
//        }
        //most optimal

        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>largest){
                secondLargest = largest;
                largest=arr[i];
            }
            else if(arr[i]>secondLargest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}

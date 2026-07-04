package src.DsaPatterns.BinarySearch;

public class HIndexII {
    public static void main(String[] args) {
        int citations[] = {0,1,2,3,5,6};
        System.out.println(hIndex(citations));
    }
    public static int hIndex(int[] citations) {
        int n = citations.length;

        int low=0,high=n-1;


        while(low<=high){
            int mid = low+(high-low)/2;
            if(citations[mid]==n-mid){// this means that at that index all right elements will be greater or equal to citations[mid]
                return citations[mid];
            }
            else if(citations[mid]>n-mid){// this means in right there are less elements which is greater than citations[mid]
                high=mid-1;
            }
            else{
                low=mid+1;// if this is smaller than number of elements we can go right
            }

        }
        return n-low;
    }
}

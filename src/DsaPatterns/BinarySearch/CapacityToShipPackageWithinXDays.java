package src.DsaPatterns.BinarySearch;

import java.util.Arrays;

/*
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.



Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
Example 3:

Input: weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1


Constraints:

1 <= days <= weights.length <= 5 * 104
1 <= weights[i] <= 500

dayCount=2

4


 */
public class CapacityToShipPackageWithinXDays {
    public static void main(String[] args) {
        //int weights[] = {1,2,3,1,1};
        //int weights[] = {3,2,2,4,1,4};
        int weights[] = {1,2,3,4,5,6,7,8,9,10};
        //int weights[] = {70,259,379,369,287,145,259,29,150,410,493,121,184,92,79,168,269,209,139,437};

        System.out.println(shipWithinDays3(weights,5));
    }
    public static int shipWithinDays3(int[] weights, int days) {
        int total = 0, heaviest = 0;
        for (int w : weights) {
            total += w;
            heaviest = Math.max(heaviest, w);
        }
        int left = heaviest;
        int right = total;
        int res=-1;
        while (left <= right) {
            int minWeightGuess = left + (right - left) / 2;
            if (shipmentPossible(weights, minWeightGuess,days)) {
                res=minWeightGuess;
                right = minWeightGuess-1;
            } else {
                left = minWeightGuess + 1;
            }
        }
        return res;

    }
    private static boolean shipmentPossible(int[] weights, int capacity, int days) {
        int daysNeeded = 1, remaining = capacity;
        for (int weight : weights) {
            if (remaining < weight) {
                daysNeeded++;
                remaining = capacity;
            }
            remaining -= weight;
        }
        return daysNeeded <= days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int total = 0, heaviest = 0;
        for (int w : weights) {
            total += w;
            heaviest = Math.max(heaviest, w);
        }
        int left = Math.max(heaviest, total / days);
        int right = heaviest * (int) Math.ceil((double) weights.length / days);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int neededDays = totalDay(weights, mid);
            if (neededDays <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }
    private static int totalDay(int[] weights, int capacity) {
        int days = 1, remaining = capacity;
        for (int weight : weights) {
            if (remaining < weight) {
                days++;
                remaining = capacity;
            }
            remaining -= weight;
        }
        return days;
    }

    public static int shipWithinDays2(int[] weights, int days) {
        int n = weights.length;
        int maxWeightsInADay = 0;
        for (int i = 0; i < n; i++) {
            maxWeightsInADay += weights[i];
        }
        System.out.println("Total weight " + maxWeightsInADay);
        int low = 1, high = maxWeightsInADay;
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
//            System.out.println(mid);
            if (canBeShipped(weights, n, mid, days, maxWeightsInADay)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
    public static boolean canBeShipped(int[] weights,int n, int mid,int days, int maxWeightsInADay){
        int dayCount=0;
        int sum=0;
        int totalWeights = 0;
        System.out.println("mid " + mid);
        for(int i=0;i<n;i++){
            if(weights[i]>mid){
                return false;
            }
            sum+=weights[i];
            if(sum>mid) {

                dayCount++;
                totalWeights+=sum-weights[i];
                System.out.println(sum+" "+dayCount);
                sum=weights[i];

                if(sum==mid) {
                    dayCount++;
                    totalWeights+=mid;
                    sum=0;
                    System.out.println(sum+" "+dayCount);
                }
            }
            else{
                if(sum==mid) {
                    dayCount++;

                    totalWeights+=mid;
                    sum=0;
                    System.out.println(sum+" "+dayCount);
                }
            }
        }
        if(sum!=0 && sum<=mid){
            dayCount++;
            totalWeights+=sum;
        }
        System.out.println("Total" + totalWeights);
        if(dayCount<=days && totalWeights==maxWeightsInADay){
            System.out.println("Total shipped" + totalWeights);
            return true;
        }
        return false;

    }
}

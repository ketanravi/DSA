package AlgoMaster.Stacks;

import java.util.Stack;
import java.util.Arrays;

/*
    Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

    Example 1:

    Input: temperatures = [73,74,75,71,69,72,76,73]
    Output: [1,1,4,2,1,1,0,0]
    Example 2:

    Input: temperatures = [30,40,50,60]
    Output: [1,1,1,0]
    Example 3:

    Input: temperatures = [30,60,90]
    Output: [1,1,0]


    Constraints:

    1 <= temperatures.length <= 105
    30 <= temperatures[i] <= 100
 */
public class DailyTemprature {
    public static void main(String[] args){
        int tempratures[] = {73,74,75,71,69,72,76,73};
        int res[] = findNoOfDaysBeforeNextWarmerDay(tempratures);
        for(int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] findNoOfDaysBeforeNextWarmerDay(int tempratures[]){

        int result[] = new int[tempratures.length];
        Arrays.fill(result,0); // filling every element with 0 that is not present
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tempratures.length;i++){
            while(!st.empty() && tempratures[i] > tempratures[st.peek()]){// Check if the stack is not empty and the current temperature is greater than that at stack's top index
                int index = st.pop(); //pop the element index from stack
                result[index] = i -index; // calculate the difference in days between current index and popped index and store it in result array
            }
            st.push(i);//Push the current index onto the stack
        }
        return result;


    }
}

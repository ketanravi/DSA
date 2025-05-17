import java.util.Stack;

public class StackProblems {
    static Stack<Integer> st1 = new Stack<>();
    static  Stack<Integer> st2 = new Stack<>();
    public static void main(String args[]){





    }
    void push(int a){
        if(st1.isEmpty()){
            st1.push(a);
            return;
        }
        else{
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            st1.push(a);
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }

        }
    }
    int pop(Stack<Integer> st1){
        if(st1.isEmpty()){
            return -1;
        }
        return st1.pop();
    }

}

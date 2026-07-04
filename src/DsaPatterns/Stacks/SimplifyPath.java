package src.DsaPatterns.Stacks;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
    }
    public static String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] parts = path.split("/");
        for(String part : parts){
            System.out.println(part);
            if(part.equals("")||part.equals(".")){
                continue;
            }else if(part.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(part);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : st) {
         //   System.out.println(dir);
            result.append("/").append(dir);
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}

package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterativeSingleStack {
    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.left.left.right = new TreeNode(9);
        root.right.right.left = new TreeNode(8);
        root.left.left.right.left = new TreeNode(1);

        System.out.println(getPostOrderIterativeTraversalSingleStack(root));
    }

    private static List<Integer> getPostOrderIterativeTraversalSingleStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        ArrayList<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        TreeNode curr = root;
        TreeNode temp = null;

        while(curr != null || !stack.isEmpty())
        {
            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            else{
                temp = stack.peek().right;
                if(temp==null){
                    temp = stack.pop();
                    result.add(temp.data);
                    while(!stack.isEmpty() && temp==stack.peek().right){
                        temp = stack.pop();
                        result.add(temp.data);
                    }
                }
                else{
                    curr= temp;
                }
            }
        }

        return result;
    }
}

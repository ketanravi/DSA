package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderIterative {
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

        System.out.println(getPreOrderIterativeTraversal(root));
    }

    private static List<Integer> getPreOrderIterativeTraversal(TreeNode root) {
       List<Integer> result= new ArrayList<>();
         if(root == null)
              return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.data);
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }

       return result;
    }
}

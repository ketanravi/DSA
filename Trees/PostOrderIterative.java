package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterative {
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

        System.out.println(getPostOrderIterativeTraversal(root));
    }

    private static List<Integer> getPostOrderIterativeTraversal(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        ArrayList<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        stack1.push(root);
        while(!stack1.isEmpty())
        {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left!=null)
                stack1.push(node.left);
            if(node.right!=null)
                stack1.push(node.right);
        }

        while(!stack2.isEmpty()){
            TreeNode node = stack2.pop();
            result.add(node.data);
        }
        return result;
    }
}

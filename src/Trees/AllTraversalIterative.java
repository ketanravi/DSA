package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllTraversalIterative {
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

        System.out.println(getAllTraversal(root));
    }

    private static List<List<Integer>> getAllTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
       List<Integer> preOrderResult= new ArrayList<>();
       List<Integer> inOrderResult= new ArrayList<>();
       List<Integer> postOrderResult= new ArrayList<>();
         if(root == null)
              return result;

        Stack<Pair<TreeNode,Integer>> stack = new Stack<>();
        stack.push(new Pair(root,1));
        while (!stack.isEmpty()){
            Pair curr = stack.pop();
            if(curr.state==1){
                preOrderResult.add((curr.node).data);
                curr.state++;
                stack.push(curr);
                if((curr.node).left!=null)
                    stack.push(new Pair((curr.node).left,1));
            }
            else if(curr.state==2){
                inOrderResult.add((curr.node).data);
                curr.state++;
                stack.push(curr);
                if((curr.node).right!=null)
                    stack.push(new Pair((curr.node).right,1));
            }
            else{
                postOrderResult.add((curr.node).data);

            }
        }
        result.add(preOrderResult);
        result.add(inOrderResult);
        result.add(postOrderResult);


       return result;
    }
}

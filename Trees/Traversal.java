package Trees;

import java.util.ArrayList;
import java.util.List;
 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
public class Traversal
{
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
       // root.right.left = new TreeNode(7);

        System.out.println(getTreeTraversal(root));


    }
    public static List<Integer> getInorderTraversal(TreeNode root, List<Integer> result){
        if(root == null)
            return result;
        getInorderTraversal(root.left,result);
        result.add(root.data);
        getInorderTraversal(root.right,result);
        return result;

    }
    public static List<Integer> getPreOrderTraversal(TreeNode root, List<Integer> result){
        if(root == null)
            return result;
        result.add(root.data);
        getPreOrderTraversal(root.left,result);
        getPreOrderTraversal(root.right,result);
        return result;
    }
    public static List<Integer> getPostOrderTraversal(TreeNode root,List<Integer> result){
        if(root == null)
            return result;
        getPostOrderTraversal(root.left,result);
        getPostOrderTraversal(root.right,result);
        result.add(root.data);
        return result;
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> traversalList = new ArrayList<>();
        TreeNode tempRoot = root;
        traversalList.add(getInorderTraversal(tempRoot,new ArrayList<Integer>()));
        tempRoot = root;
        traversalList.add(getPreOrderTraversal(tempRoot,new ArrayList<Integer>()));
        tempRoot = root;
        traversalList.add(getPostOrderTraversal(tempRoot,new ArrayList<Integer>()));
        return traversalList;
    }

}

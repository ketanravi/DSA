package src.DsaPatterns.Trees;
/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.



Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]


Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
 */
import java.util.HashMap;

public class ConstructBTFromPostAndInorder {
    static HashMap<Integer,Integer> map = new HashMap<>();
    static int index;
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        buildTree(inorder,postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        index= postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return solve(postorder,0,postorder.length-1);
    }
    public static TreeNode solve(int[] postorder, int low, int high){
        if(low>high){
            return null;
        }

        TreeNode node = new TreeNode(postorder[index]);
        index--;

        int inorderIndex = map.get(node.val);
        // right should be build first
        node.right = solve(postorder,inorderIndex+1,high);
        node.left = solve(postorder,low,inorderIndex-1);

        return node;
    }
}

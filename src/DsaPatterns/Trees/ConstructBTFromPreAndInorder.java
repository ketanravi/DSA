package src.DsaPatterns.Trees;

import java.util.HashMap;

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.



Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]


Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
 */
public class ConstructBTFromPreAndInorder {
    static HashMap<Integer,Integer> map = new HashMap<>();
    static int index=0;
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        buildTree(inorder,postorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return solve(preorder,0,preorder.length-1);
    }
    public static TreeNode solve(int[] preorder, int low, int high){
        if(low>high){
            return null;
        }
        TreeNode node = new TreeNode(preorder[index]);
        index++;

        int inorderIndex = map.get(node.val);
        //left to be build first
        node.left = solve(preorder,low,inorderIndex-1);
        node.right = solve(preorder,inorderIndex+1,high);
        return node;
    }


}

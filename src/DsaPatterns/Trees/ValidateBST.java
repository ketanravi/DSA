package src.DsaPatterns.Trees;
/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys strictly less than the node's key.
The right subtree of a node contains only nodes with keys strictly greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */
public class ValidateBST {
    static boolean ans = true;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(7);

// root.left.left = null;
// root.left.right = null;

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(8);
//        TreeNode prev = null;
//
//        isValidBST(root,prev);
//        System.out.println(ans);

        System.out.println(isValidBSTDFSApproach(root,null,null));


    }
    // using DFS
    public static boolean isValidBSTDFSApproach(TreeNode root, TreeNode left, TreeNode right) {
        if(root==null)
                return true;
        if(left!=null && root.val<=left.val || right!=null && root.val>=right.val)
            return false;
        return isValidBSTDFSApproach(root.left,left,root)&&
                isValidBSTDFSApproach(root.right,root,right);

    }
    // Using Inorder approach
    public static void isValidBSTInOrderApproach(TreeNode root,TreeNode prev) {
        if(root==null){
            return;
        }
        isValidBSTInOrderApproach(root.left,prev);
        if(prev==null){
            prev=root;
        }
        else{
            if(root.val<=prev.val)
                ans = false;
            prev=root;
        }
        isValidBSTInOrderApproach(root.right,prev);
        return;
    }

    public boolean isValidBSTDFS2(TreeNode root) {
        return solve(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean solve(TreeNode root, long min, long max){
        if(root==null)
            return true;
        if(root.val<=min || root.val>=max)
            return false;
        return solve(root.left,min,root.val)&&
                solve(root.right,root.val,max);
    }
}

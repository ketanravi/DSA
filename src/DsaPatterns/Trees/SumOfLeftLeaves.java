package src.DsaPatterns.Trees;
/*
Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
Example 2:

Input: root = [1]
Output: 0


Constraints:

The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeaves(head));
    }
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;

        return solve(root,false);


    }
    public static int solve(TreeNode root, boolean isLeft){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null){// direction means coming from left
            return isLeft ? root.val : 0;
        }

        int leftSum = solve(root.left,true);
        int rightSum = solve(root.right,false);

        return leftSum+rightSum;


    }
}

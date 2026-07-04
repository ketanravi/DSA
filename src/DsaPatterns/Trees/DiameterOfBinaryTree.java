package src.DsaPatterns.Trees;
/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.



Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
 */
public class DiameterOfBinaryTree {
    static int diameter = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left = new TreeNode(7);



        System.out.println(diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        height(root);
        return diameter;

    }
    public static int height(TreeNode root){
        if(root==null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        diameter = Math.max(diameter,leftHeight+rightHeight);
        return 1+Math.max(leftHeight,rightHeight);
    }
}

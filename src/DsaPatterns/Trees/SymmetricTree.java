package src.DsaPatterns.Trees;
/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false


Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100

 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null)
            return true;
        return check(root.left,root.right);
    }
    public static boolean check(TreeNode node1, TreeNode node2) {
        if(node1==null && node2==null){
            return true;
        }
        if(node1==null || node2==null){
            return false;
        }
        if(node1.val!= node2.val){
            return false;
        }

        return check(node1.left,node2.right) && check(node1.right,node2.left);

    }




}

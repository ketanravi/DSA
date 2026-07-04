package src.DsaPatterns.Trees;
/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
Example 1:

Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:

Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:

Input: p = [1,2,1], q = [1,1,2]
Output: false

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(2);
        p.right = new TreeNode(20);
        TreeNode q = new TreeNode(3);
        q.left = new TreeNode(9);
        q.right = new TreeNode(21);
        System.out.println(isSameTree(p,q));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null && q ==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }

        boolean leftSubTree = isSameTree(p.left,q.left);
        boolean rightSubTree =  isSameTree(p.right,q.right);

        if(!leftSubTree || !rightSubTree)
            return false;
        return true;

    }
}

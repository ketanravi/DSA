package src.DsaPatterns.Trees;
/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”



Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1


Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.
 */
public class LCA {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        TreeNode p = head.left = new TreeNode(5);
        TreeNode q = head.right = new TreeNode(1);
        head.left.left = new TreeNode(6);
        head.left.right = new TreeNode(2);
        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(8);
        head.left.right.left = new TreeNode(7);
        head.left.right.right = new TreeNode(4);

        System.out.println(lowestCommonAncestorSecondMethod(head,p,q).val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null; // reached end, found nothing

        if(root == p || root == q) return root; // found p or q, send it up

        TreeNode left = lowestCommonAncestor(root.left, p, q); // search left
        TreeNode right = lowestCommonAncestor(root.right, p, q); // search right

        if(left != null && right != null) return root; // both sides found -> LCA
        return left != null ? left : right; // pass up whichever was found

    }

    static TreeNode ans = null;
    public static TreeNode lowestCommonAncestorSecondMethod(TreeNode root, TreeNode p, TreeNode q) {

        int total = solve(root,p,q);
        return ans;


    }
    public static int solve(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return 0;
        int leftCount = solve(root.left,p,q);
        int rightCount = solve(root.right,p,q);
        int self = 0;
        if(root==p || root==q)
            self=1;
        int total = leftCount+rightCount+self;

        if(total==2 && ans==null){
            ans = root;
        }
        return total;

    }
}

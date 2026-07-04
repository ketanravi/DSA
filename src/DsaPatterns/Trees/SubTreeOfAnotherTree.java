package src.DsaPatterns.Trees;

import com.sun.source.tree.Tree;

/*
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.



Example 1:


Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:


Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false


Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
 */
public class SubTreeOfAnotherTree {
    static TreeNode ans = null;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.left.left = null;
        root.left.left.right = null;
        root.right.left = null;
        root.right.right = null;
        root.left.right.left = new TreeNode(0);
        TreeNode subRoot = new TreeNode(4);
       subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);
        subRoot.right.left = new TreeNode(0);
        System.out.println(isSubtree(root,subRoot));
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)
            return true;
        if(root==null)
            return false;
        if(root.val == subRoot.val){
            if(isSameTree(root,subRoot))
                return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public static boolean isSameTree(TreeNode root, TreeNode subRoot) {

        if(root==null && subRoot ==null){
            return true;
        }
        if(root==null || subRoot==null || root.val!=subRoot.val){
            return false;
        }

        if(!isSameTree(root.left,subRoot.left))
            return false;
        if(!isSameTree(root.right,subRoot.right))
            return false;
        return true;

    }
}

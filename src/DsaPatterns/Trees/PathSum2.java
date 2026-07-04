package src.DsaPatterns.Trees;

import java.util.ArrayList;
import java.util.List;

import static src.DsaPatterns.Trees.PathSum2.solve;

/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.



Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */
public class PathSum2 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

// root.right.left.left = null;
// root.right.left.right = null;

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(pathSum(root,22));
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;

        solve(root,targetSum,res,new ArrayList<>());
        return res;


    }
    public static void solve(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> temp){
        if(root==null)
            return;
        temp.add(root.val);

        if(root.left==null && root.right==null && root.val==targetSum){
            res.add(new ArrayList<>(temp));
        }
        solve(root.left, targetSum - root.val,res,temp);
        solve(root.right, targetSum - root.val,res,temp);
        temp.removeLast();
    }
}

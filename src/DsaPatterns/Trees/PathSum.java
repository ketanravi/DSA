package src.DsaPatterns.Trees;
/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.



Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There are two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */
public class PathSum {
    static boolean res = false;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(hasPathSum(root,5));
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if(root==null) {
            return false;
        }
        solve(root,targetSum,0);
        return res;
    }
    public static void solve(TreeNode root, int targetSum, int sum) {
        if(root==null)
            return;
        sum+=root.val;

        if(root.left==null && root.right==null) {
            if(sum==targetSum)
                res=true;
            return;
        }

        solve(root.left,targetSum,sum);
        solve(root.right,targetSum,sum);
        return;
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null && root.right==null && root.val==targetSum) return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

}

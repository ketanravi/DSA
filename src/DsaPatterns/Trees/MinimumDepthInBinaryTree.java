package src.DsaPatterns.Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5


Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000
 */
public class MinimumDepthInBinaryTree {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);
        System.out.println(minDepth(head));
    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                if (curr != null && curr.left == null && curr.right == null)
                    return depth;
                if (curr != null && curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr != null && curr.right != null) {
                    queue.offer(curr.right);
                }

            }
            depth++;
        }
        return depth;


    }

    public int minDepthWithRecursion(TreeNode root) {
        if (root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

    }
}

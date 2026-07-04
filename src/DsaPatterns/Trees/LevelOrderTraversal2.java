package src.DsaPatterns.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 */
public class LevelOrderTraversal2 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);
        System.out.println(levelOrderBottom(head));
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root==null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode curr = queue.poll();
                if(curr!=null)
                    temp.add(curr.val);

                if(curr!=null && curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr!=null && curr.right!=null){
                    queue.offer(curr.right);
                }

            }
            res.addFirst(temp);
        }
        return res;
    }

}

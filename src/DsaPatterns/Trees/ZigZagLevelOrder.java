package src.DsaPatterns.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
1,2,3,4,null,null,5


            1
           2  3
         4
 */
public class ZigZagLevelOrder {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.right = new TreeNode(5);
        System.out.println(zigzagLevelOrder(head));
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root==null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode curr = queue.poll();
                if(curr!=null) {
                    if(level%2==0)
                        temp.add(curr.val);
                    else{
                        temp.addFirst(curr.val);
                    }
                }

                if (curr != null && curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr != null && curr.right != null) {
                    queue.offer(curr.right);
                }


            }
            level++;
            res.add(temp);
        }
        return res;
    }
}

package src.DsaPatterns.Trees;

import java.util.Stack;

/*
Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false


Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
 */
public class TwoSumInBST {
    static Stack<TreeNode> ascStack = new Stack<>();
    static Stack<TreeNode> descStack = new Stack<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode p = root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        TreeNode q = root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        System.out.println(findTarget(root,23));
    }
    public static boolean findTarget(TreeNode root, int k) {
        if(root==null)
            return false;
        TreeNode temp = root;
        while(temp!=null){
            ascStack.push(temp);
            temp = temp.left;
        }
        temp = root;
        while(temp!=null){
            descStack.push(temp);
            temp = temp.right;
        }

        int start = findNextSmaller();
        int end = findNextGreater();
        while(start<end){
            int sum = start + end;
            if(sum==k)
                return true;
            if(sum>k)
                end=findNextGreater();
            else
                start=findNextSmaller();
        }

        return false;


    }
    public static int findNextSmaller(){
        TreeNode currSmaller = ascStack.pop();
        // find further smaller
        TreeNode rightChild = currSmaller.right;
        while(rightChild!=null){
            ascStack.push(rightChild);
            rightChild = rightChild.left;
        }
        return currSmaller.val;
    }
    public static int findNextGreater(){
        TreeNode currGreater = descStack.pop();
        // find further smaller
        TreeNode leftChild = currGreater.left;
        while(leftChild!=null){
            descStack.push(leftChild);
            leftChild = leftChild.right;
        }
        return currGreater.val;
    }


}

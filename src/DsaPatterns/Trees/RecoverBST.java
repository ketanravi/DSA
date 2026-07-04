package src.DsaPatterns.Trees;
/*
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.



Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:


Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.


Constraints:

The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1

 */
public class RecoverBST {
    static TreeNode prev=null;
    static int nodesSwappedCount = 0;
    static TreeNode firstNodeSwapped = null;
    static TreeNode firstNodeSwappedNext = null;

    static TreeNode secondNodeSwapped = null;
    static TreeNode secondNodeSwappedNext = null;


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        recoverTree(root);
        if(nodesSwappedCount==1){
            int temp = firstNodeSwapped.val;
            firstNodeSwapped.val = firstNodeSwappedNext.val;
            firstNodeSwappedNext.val = temp;
        }
        else{
            int temp = firstNodeSwapped.val;
            firstNodeSwapped.val = secondNodeSwappedNext.val;
            secondNodeSwappedNext.val = temp;
        }
        // return root
    }
    public static void recoverTree(TreeNode root) {
        if(root==null)
            return;
        recoverTree(root.left);
        if(prev==null){
            prev=root;
        }
        else{
            if(root.val<prev.val){
                if(nodesSwappedCount==0){
                    firstNodeSwapped = prev;
                    firstNodeSwappedNext = root;
                    nodesSwappedCount++;
                }
                else{
                    secondNodeSwapped=prev;
                    secondNodeSwappedNext=root;
                    nodesSwappedCount++;
                }
            }
            prev=root;
        }
        recoverTree(root.right);

    }
}

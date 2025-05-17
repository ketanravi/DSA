package Trees;

import java.util.HashMap;

public class TreeFromInOrderAndPreOrder {
    public static void main(String[] args){
        int inorder[] = {9,3,15,20,7};
        int preorder[] = {3,9,20,15,7};
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hmap.put(inorder[i],i);
        }
        TreeNode root = buildTree(inorder,preorder,hmap);
        System.out.println(Traversal.getPostOrderTraversal(root,new java.util.ArrayList<>()));
    }

    public static TreeNode buildTree(int[] inorder, int[] preorder,HashMap<Integer,Integer> hmap){
        return buildTreeHelper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hmap);
    }
    public static TreeNode buildTreeHelper(int[] preorder,  int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
       HashMap<Integer,Integer> hmap){
        if(inStart>inEnd || preStart> preEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = hmap.get(root.data);
        int numsLeft = inRoot - inStart;
        root.left = buildTreeHelper(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,hmap);
        root.right = buildTreeHelper(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,hmap);
        return root;

    }
}

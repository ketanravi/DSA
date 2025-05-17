package Trees;

import java.util.HashMap;

public class TreeFromInOrderAndPostOrder {
    public static void main(String[] args){
        int inorder[] = {9,3,15,20,7};
        //int preorder[] = {3,9,20,15,7};
        int postorder[] = {9,15,7,20,3};
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hmap.put(inorder[i],i);
        }
        TreeNode root = buildTree(inorder,postorder,hmap);
        System.out.println(Traversal.getPreOrderTraversal(root,new java.util.ArrayList<>()));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder,HashMap<Integer,Integer> hmap){
        return buildTreeHelper(postorder,0,postorder.length-1,inorder,0,inorder.length-1,hmap);
    }
    public static TreeNode buildTreeHelper(int[] postorder,  int postStart, int postEnd, int[] inorder, int inStart, int inEnd,
       HashMap<Integer,Integer> hmap){
        if(inStart>inEnd || postStart> postEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = hmap.get(root.data);
        int numsLeft = inRoot - inStart;
        root.left = buildTreeHelper(postorder,postStart,postStart+numsLeft-1,inorder,inStart,inRoot-1,hmap);
        root.right = buildTreeHelper(postorder,postStart+numsLeft,postEnd-1,inorder,inRoot+1,inEnd,hmap);
        return root;

    }
}

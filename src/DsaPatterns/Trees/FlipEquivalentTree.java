package src.DsaPatterns.Trees;

public class FlipEquivalentTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);
        System.out.println(flipEquiv(root1,root2));

    }
    public static  boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;


        if(root1.val!=root2.val)
            return false;


        // check the root1 left child with root2 left child and root1 right child with root2 right child
        boolean withoutSwap = flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right);
        // check the root1 left child with root2 right child and root1 right child with root 2 left child
        boolean withLeftRightSwap = flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left);

        // if without swap or with swap possible
        return withoutSwap || withLeftRightSwap;

    }
}

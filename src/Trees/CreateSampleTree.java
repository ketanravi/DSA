package Trees;

public class CreateSampleTree {
    TreeNode root;
    CreateSampleTree(){
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
//        root.left.left.right = new TreeNode(9);
//        root.right.right.left = new TreeNode(8);
//        root.left.left.right.left = new TreeNode(1);
//        root.right.right.left.left = new TreeNode(11);
//        root.right.right.left.left.left = new TreeNode(18);
//        root.right.right.left.left.right = new TreeNode(19);
//        root.right.right.left.left.left.right = new TreeNode(28);
    }
}

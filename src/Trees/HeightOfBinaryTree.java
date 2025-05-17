package Trees;

public class HeightOfBinaryTree {
    public static void main(String args[]){

        CreateSampleTree node = new CreateSampleTree();

        System.out.println("Height of the tree is: "+getHeight(node.root));

    }
    public static int getHeight(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
}

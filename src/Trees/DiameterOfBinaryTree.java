package Trees;

public class DiameterOfBinaryTree {
   public static void main(String args[]){

       CreateSampleTree node = new CreateSampleTree();

       System.out.println("Diameter of the tree is: "+getDiameter(node.root));

   }
    public static int getDiameter(TreeNode root){
         if(root == null)
              return 0;
         int leftHeight = getHeight(root.left);
         int rightHeight = getHeight(root.right);
         int leftDiameter = getDiameter(root.left);
         int rightDiameter = getDiameter(root.right);
         return Math.max(leftHeight+rightHeight,Math.max(leftDiameter,rightDiameter));
    }
    public static int getHeight(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

}

package Trees;

public class BalancedBinaryTree {
    public static void main(String args[]){

        CreateSampleTree node = new CreateSampleTree();

        System.out.println(getHeight(node.root)!=-1);

    }
    public static int getHeight(TreeNode root) {
        if(root == null)
            return 0;

        int lh = getHeight(root.left);
        if(lh==-1)//if left height is -1, return -1 that is not balanced
            return -1;
        int rh = getHeight(root.right);
        if(rh==-1)
            return -1;//if right height is -1, return -1 that is not balanced
        //if difference of left height and right height is greater than 1, return -1 that is not balanced
        if(Math.abs(lh-rh)>1)
            return -1;
        int height = Math.max(lh,rh)+1; //else return the height of the tree which says that at this particular node tree is balanced
        return height;
    }
}

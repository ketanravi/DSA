package Trees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTreeIterative {
    public static void main(String args[]){

        CreateSampleTree node = new CreateSampleTree();

        System.out.println("Height of the tree is: "+getHeight(node.root));

    }
    public static int getHeight(TreeNode root){
        if(root == null)
            return 0;
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            height++;
        }
        return height;
    }
}

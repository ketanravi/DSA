package src.Trees;

import java.util.ArrayList;
import java.util.List;
 class TreeNode {
     public int data;
     public TreeNode left;
     public TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     public TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
}

package homework;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Andrew Lu
 * @Description: 二叉树中序遍历
 */
//Definition for a binary tree node.

public class BinaryTreeInorderTraversal94 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){return res;}
        inOrder(root,res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if(root==null){return;}
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }
}

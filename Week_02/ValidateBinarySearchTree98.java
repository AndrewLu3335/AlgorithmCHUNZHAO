/**
 * @Author: Andrew Lu
 * @Description: 验证二叉搜索树
 */

public class ValidateBinarySearchTree98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root,null,null);
    }

    private boolean isValid(TreeNode root, Integer lower, Integer upper) {
        if(root==null){return true;}

        int val=root.val;
        if(lower!=null && val<lower) {
            return false;
        }
        if(upper!=null && upper<val) {
            return false;
        }
        if(!isValid(root.right, val, upper)) {
            return false;
        }
        if(!isValid(root.left, lower, val)) {
            return false;
        }

        return true;
    }

}

/**
 * @Author: Andrew Lu
 * @Description: 二叉树的最近公共祖先
 */
public class LowestCommonAncestorOfABinaryTree236 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     *二叉树的最近公共祖先root要具备的条件：
     *      1.p或者q节点在root的左子树右子树中，并且p和q是在异侧
     *      2.root==p 并且root的左子树或者右子树中有q节点
     *      3.root==q 并且root的左子树或者右子树中有p节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //遍历到叶子节点， 节点就是p节点， 节点就是q节点
        if(root==null || root==p ||root==q) {return root;}

        //  递归过程
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        //逻辑判断
        //左右子树都没p或者q节点
        if(left==null && right==null) {return null;}
        //如果左子树走完了代表pq都不在左子树，那么就去右子树找
        if(left==null) {return right;}
        //如果右子树完了代表pq都不在右子树，那么就去左子树找
        if(right==null) {return left;}
        return root;

    }

}

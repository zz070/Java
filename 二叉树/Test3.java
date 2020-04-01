package java_03_30;

public class Test3 {
    //二叉树的最大深度
    public int maxDepth(TreeNode root) {
        //若二叉树为空，深度为0
        if(root == null){
            return 0;
        }
        //若二叉树的左右子树都为空，深度为1
        if(root.left == null && root.right == null){
            return 1;
        }
        //若二叉树左右子树都不为空，递归判断左右子树的深度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1+(leftDepth>rightDepth?leftDepth:rightDepth);
    }

    //判断一个二叉树，是否是平衡二叉树
    // 平衡二叉树，左右子树的深度绝对值不大于于1
    public boolean isBalanced(TreeNode root) {
        //若二叉树为空，那么是一个平衡二叉树
        if(root == null){
            return true;
        }
        //若二叉树没有子树，那么也是一个平衡二叉树
        if(root.left == null && root.right == null){
            return true;
        }
        //若二叉树左右子树都不为空，递归判断左右子树的深度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        //若左右子树的深度绝对不小于1，那么一定不是一个平衡二叉树
        if(leftDepth - rightDepth >1 || leftDepth - rightDepth < -1){
            return false;
        }
        //否则，递归判断当前结点是否为平衡二叉树
        return isBalanced(root.left) && isBalanced(root.right);
    }
}

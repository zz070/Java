package java_03_30;

public class Test4 {
    public boolean isMirrorTree(TreeNode p, TreeNode q){
        //若两个子树为空，一定对称
        if(p == null && q == null){
            return true;
        }
        //若两个子树，一个为空，另一个不为空，一定不对称
        if(p == null || q == null){
            return false;
        }
        //若两个子树根节点不同，一定不对称
        if(p.val != q.val){
            return false;
        }
        return isMirrorTree(p.left,q.right) && isMirrorTree(p.right,q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        //空树一定对称
        if(root == null){
            return true;
        }
        //判断左右子树是否成对称
       return isMirrorTree(root.left,root.right);
    }
}

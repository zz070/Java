package Tree;

public class Test0703 {
    //判断一个数是否是平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        int n1 = level(root.left);
        int n2 = level(root.right);
        if(n1-n2<-1||n1-n2>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    private int level(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int lenthLeft = level(root.left);
        int lenthRight= level(root.right);
        return 1+(lenthLeft>lenthRight?lenthLeft:lenthRight);
    }
}

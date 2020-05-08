package Tree;

public class Test0508 {
    //二叉树搜索树转换成排序双向链表
    public TreeNode Convert(TreeNode pRootOfTree){
        //二叉树搜索树的中序遍历是有序的
        //如果二叉树为空，直接返回null
        if(pRootOfTree == null){
            return null;
        }
        //如果当前树没有子树，直接返回该节点
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        //最终链表的结构：左子树链表+根节点+右子树的链表
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        while(leftTail != null && leftTail.right != null){
            leftTail = leftTail.right;
        }
        if(left != null){
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left == null? pRootOfTree:left;
    }


}

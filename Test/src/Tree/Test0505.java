package Tree;

public class Test0505 {
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

    //二叉树创建字符串
    private StringBuilder s = new StringBuilder();
    public String treeTwoStr(TreeNode t) {
        //如果t 为空，返回空字符串
        if (t == null) {
            return "";
        }
        helper(t);
        //删除多出来的（）
        s.deleteCharAt(0);
        s.deleteCharAt(s.length() - 1);
        //返回最终字符串
        return s.toString();
    }
    public void helper(TreeNode t) {
        if(t == null){
            return;
        }
        s.append("(");
        s.append(t.val);
        helper(t.left);
        //如果左子树为空，右子树不为空，要输出一个完整的（）
        if(t.left == null && t.right != null){
            s.append("()");
        }
        helper(t.right);
        s.append(")");
    }
}

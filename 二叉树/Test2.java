package java_03_30;

public class Test2 {
    //检查两颗二叉树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q){
        //可以分为四种情况
        //1、p，q都为null；
        //2、p为null，q不为null；
        //3、q为null，p不为null；
        //4、p，q都不为null

        //两个树若为空树，那么认为这两个树相同
        if(p == null && q == null){
            return true;
        }
        //两个树若一个为空，一个不为空，肯定不同
        //if((p == null && q != null) || (p != null && q == null))
        if(p == null || q == null){
            return false;
        }
        //两个树都不为空，若根的值不同，那么两个树不同
        if(p.val != q.val){
            return false;
        }
        //否则，递归遍历两个树的左右子树
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


    //是否是另一棵树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
         if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        boolean ret = true;
        if(s.val == t.val){
            ret = isSameTree(s,t);
        }
        return ret || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
}

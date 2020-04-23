package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Test0423 {
    //判断是否是完全二叉树
    public boolean isCompleteTree(TreeNode root){
        if(root == null){
            return true;
        }
        Boolean secondStep = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!secondStep) {
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left != null && cur.right == null) {
                    queue.offer(cur.left);
                    secondStep = true;
                }else if(cur.left == null && cur.right != null){
                    return false;
                }else{
                    secondStep = true;
                }
            }else{
                if(cur.left != null || cur.right != null){
                    return false;
                }
            }
        }
        return true;
    }

    //判断两棵数是否相同
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null&& q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}

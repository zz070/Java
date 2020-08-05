package Test;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}
public class CompleteTree {
    public boolean isCompleteTree(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(root);
        boolean second = false;
        while(!tree.isEmpty()){
            TreeNode cur = tree.poll();
            if(!second){
                if(cur.left != null && cur.right != null){
                    tree.offer(cur.left);
                    tree.offer(cur.right);
                }else if(cur.left != null && cur.right == null){
                    tree.offer(cur.left);
                    second = true;
                }else if(cur.left == null && cur.right != null){
                    return false;
                }else{
                    second = true;
                }
            }else{
                if(cur.left != null || cur.right != null){
                    return false;
                }
            }
        }
        return  true;
    }
}

package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class java0430 {
    //判断一棵树是否是完全二叉树
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

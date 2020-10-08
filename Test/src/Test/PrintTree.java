package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//之字形打印二叉树，并将结果存储在一个List中
/*
1、创建一个ArrayList用于存放二叉树的所有结点
2、创建一个新的ArrayList用于分别存储二叉树的每一层结点
3、创建一个队列和一个栈分别用于临时存放二叉树的每一层节点
4、
 */
public class PrintTree {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer> > Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> s = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        TreeNode one = null;
        TreeNode two = null;
        boolean flag = true;
        s.push(root);
        while(!s.isEmpty()){
            int size = s.size();
            for(int i = 0;i<size;i++){
                TreeNode cur = s.pop();
                temp.add(cur.val);
                if(flag){
                    one = cur.left;
                    two = cur.right;
                }else{
                    one = cur.right;
                    two = cur.left;
                }
                if(one != null){
                    q.offer(one);
                }
                if(two != null){
                    q.offer(two);
                }
            }
            list.add(temp);
            temp.clear();
            while(!q.isEmpty()){
                s.push(q.poll());
            }
            flag = !flag;
        }
        return list;
    }
}
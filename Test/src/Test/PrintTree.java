package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//之字形打印二叉树，并将结果存储在一个List中
/*
①创建一个ArrayList用于存放二叉树每一层元素
②如果二叉树为空，直接返回一个空的ArrayList
③创建一个栈，用于对二叉树的每一层元素进行逆序，创建一个队列用于临时存放二叉树结点
④ 设置一个flag，用于标志一层存储结束，在一次循环的最后将flag的置反
⑤将根结点入栈
⑥在栈不为空的情况下，
	将栈中的元素全部都存储在临时ArrayList中
	按照flag标志位分别从前到后，或从后到前将下一层元素入队列（若flag为true，那么按顺序存储下一层元素，反之，逆序存储）
	一层元素元素存储完毕，将其保存在list中，并清空临时存储的ArrayLIst，再将队列中所有元素入栈
	最后将flag置反
⑦最后返回list
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
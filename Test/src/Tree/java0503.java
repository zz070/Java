package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class java0503 {
    //非递归遍历二叉树
    //先序非递归遍历
    private static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> tree = new Stack<>();
        tree.push(root);
        while(!tree.isEmpty()){
            TreeNode top = tree.pop();
            System.out.print(top.val+"  ");
            if(top.right != null){
                tree.push(top.right);
            }
            if(top.left != null){
                tree.push(top.left);
            }
        }
    }
    //中序非递归遍历
    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> tree = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                tree.push(cur);
                cur = cur.left;
            }
            if (tree.isEmpty()) {
                break;
            }
            TreeNode top = tree.pop();
            System.out.print(top.val + "  ");
            cur = top.right;
        }
    }
    //后序非递归遍历
    private static void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> tree = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(true){
            while(cur != null){
                tree.push(cur);
                cur = cur.left;
            }
            if(tree.isEmpty()){
                break;
            }
            TreeNode top = tree.peek();
            if(top.right == null || prev == top.right){
                System.out.print(top.val+"  ");
                tree.pop();
                prev = top;
            }else{
                cur = top.right;
            }
        }
    }

    //层序遍历
    private static void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> tree = new LinkedList<>();
        tree.offer(root);
        while(!tree.isEmpty()){
            TreeNode top = tree.poll();
            System.out.print(top.val+"  ");
            if(top.left != null){
                tree.offer(top.left);
            }
            if(top.right != null){
                tree.offer(top.right);
            }
        }
    }
    //构建一棵二叉树
    public static TreeNode build() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        System.out.print("先序遍历二叉树:");
        preOrder(root);
        System.out.println();
        System.out.print("中序遍历二叉树:");
        inOrder(root);
        System.out.println();
        System.out.print("后序遍历二叉树:");
        postOrder(root);
        System.out.println();
        System.out.print("层序遍历二叉树:");
        levelOrder(root);
    }
}

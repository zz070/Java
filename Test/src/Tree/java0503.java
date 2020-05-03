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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.val+"  ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
    //递归遍历
    //先序递归
    public static void preOrder2(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+"  ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序递归
    public static void inOrder2(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+"  ");
        inOrder(root.right);
    }
    //后序遍历
    public static void postOrder2(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+"  ");
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
        System.out.println();
        System.out.println("递归：");
        System.out.print("先序遍历二叉树:");
        preOrder(root);
        System.out.println();
        System.out.print("中序遍历二叉树:");
        inOrder(root);
        System.out.println();
        System.out.print("后序遍历二叉树:");
        postOrder(root);
    }
}

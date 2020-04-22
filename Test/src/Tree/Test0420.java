package Tree;

public class Test0420 {
    //递归遍历
    //先序递归
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序递归
    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    //后序遍历
    public static void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
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
    }
}

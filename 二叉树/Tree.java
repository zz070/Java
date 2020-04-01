package java_03_29;


class Node{
    public char val;
    public Node left;
    public Node right;
    public Node(char val){
        this.val = val;
    }
}
public class Tree {
    //构造一棵二叉树
    public static Node built(){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;
        return a;
    }
    //先序遍历二叉树
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序遍历二叉树
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        preOrder(root.left);
        System.out.print(root.val);
        preOrder(root.right);
    }
    //后序遍历二叉树
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val);
    }
    //求二叉树中节点的个数
    public static int size(Node root){
        if(root == null){
            return 0;
        }
        return 1+size(root.left)+size(root.right);
    }
    //求二叉树中叶子节点的个数
    public static int leafSize(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }
    //在二叉树中查找指定元素
    public static Node find(Node root,char toFind){
        if(root == null){
            return null;
        }
        if(root.val == toFind){
            return root;
        }
        Node result = find(root.left,toFind);
        if(result != null){
            return result;
        }
        return find(root.right,toFind);
    }
    //求二叉树第K层的结点个数
    public static int kLevelSize(Node root, int k){
        if(root == null || k<1){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return kLevelSize(root.left,k-1)+kLevelSize(root.right,k-1);
    }

    public static void main(String[] args) {
        Node root = built();
        System.out.println("先序遍历: ");
        preOrder(root);
        System.out.println();

        System.out.println("中序遍历: ");
        inOrder(root);
        System.out.println();

        System.out.println("后序遍历: ");
        postOrder(root);
        System.out.println();

        System.out.println("求二叉树中节点的个数");
        System.out.println(size(root));
        System.out.println();

        System.out.println("求二叉树中第K层节点的个数");
        System.out.println(kLevelSize(root,3));
        System.out.println();

        System.out.println("求二叉树中叶子节点的个数");
        System.out.println(leafSize(root));
        System.out.println();

        System.out.println("求二叉树中指定元素D");
        System.out.println(find(root,'D'));
    }
}

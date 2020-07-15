package Test;
class Node {
    int val;
    Node left;
    Node right;
    public Node(int x) {
        val = x;
    }
}
public class Test0715 {
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
}

package java_03_30;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 空树返回一个空的 List (元素个数为 0, 但是不是 null)
        if(root == null){
            return list;
        }
        // 访问根节点, 此处的访问操作, 把元素 add 到 List 中
        list.add(root.val);
        // 递归遍历左子树, 把左子树的遍历结果加入到 List 中
        list.addAll(preorderTraversal(root.left));
        // 递归遍历右子树, 把右子树的遍历结果加到 List 中
        list.addAll(preorderTraversal(root.right));
        return list;
    }
    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 空树返回一个空的 List (元素个数为 0, 但是不是 null)
        if(root == null){
            return list;
        }
        // 递归遍历左子树, 把左子树的遍历结果加入到 List 中
        list.addAll(inorderTraversal(root.left));
        // 访问根节点, 此处的访问操作, 把元素 add 到 List 中
        list.add(root.val);
        // 递归遍历右子树, 把右子树的遍历结果加到 List 中
        list.addAll(inorderTraversal(root.right));
        return list;
    }
    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }
}

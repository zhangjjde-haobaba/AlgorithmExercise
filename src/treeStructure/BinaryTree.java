package treeStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jiang on 3/1/23 2:25 PM
 */
public class BinaryTree {
    /*
   层序遍历
   完全二叉树的特性：
       1.空树也是完全二叉树
       2.左子树为null,右子树不为null,一定不是完全二叉树
       3.如果左右子树都为空，这个节点一定是叶子节点，这个节点往后都是叶子节点
*/
    public static void main(String[] args) {
        Tree<Integer> A = new Tree<Integer>(1);//根节点
        Tree<Integer> B = new Tree<Integer>(2);
        Tree<Integer> C = new Tree<Integer>(3);
        Tree<Integer> D = new Tree<Integer>(4);
        Tree<Integer> E = new Tree<Integer>(5);
        Tree<Integer> F = new Tree<Integer>(6);
        Tree<Integer> G = new Tree<Integer>(7);
        Tree<Integer> H = new Tree<Integer>(8);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right=G;
        D.left = H;
        System.out.println(isCompleteBinaryTree(A));

    }

    public static boolean isCompleteBinaryTree(Tree tree){
        //判断一棵树是不是完全二叉树
        //层序遍历 左树和右树都不为空 先判断左树再判断右树
        //如果节点的度为1 那么只有左树没有右树
        //如果节点的度为0 那么后边的节点也一定要是叶子节点
        //完全二叉树也可以是空树
        if(tree==null){
            return true;
        }
        //定义一个队列 有顺序的遍历节点
        Queue<Tree> queue = new LinkedList<>();
        //是否遍历到叶子节点
        boolean isLeaf = false;
        //把树放进队列
        queue.offer(tree);
        while(!queue.isEmpty()){
            //弹出队首元素
            Tree root = queue.poll();
            //如果没有遍历到叶子节点按这种方式遍历
            if(!isLeaf){
                //遍历左树和右树
                //层序遍历 左树和右树都不为空 先判断左树再判断右树
                if(root.left!=null&&root.right!=null){
                    queue.offer(root.left);
                    queue.offer(root.right);
                }
                //如果节点的度为1 那么只有左树没有右树
                else if(root.left!=null && root.right==null){
                    queue.offer(root.left);
                }
                //只有右树 没有左树 一定不是完全二叉树
                else if(root.right!=null && root.left==null){
                    return false;
                }
                //左树和右树都为空 表示遍历到叶子节点 ，那么遍历的后面的所有节点都应该是叶子节点
                else{
                    isLeaf = true;
                }
            }else{
               if(root.left!=null || root.right!=null){
                   return false;
               }
            }
        }
        return isLeaf;

    }
}

class Tree<E>{
    E root;
    Tree<E> left;
    Tree<E> right;

    public Tree(E root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

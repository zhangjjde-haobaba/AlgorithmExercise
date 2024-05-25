package treeStructure;

/**
 * Created by jiang on 10/8/23 1:44 PM
 */
public class AVLTree {
    public static void main(String[] args) {

        Tree<Integer> tree11 = new Tree<>(11);
        Tree<Integer> tree9 = new Tree<>(9);
        Tree<Integer> tree7 = new Tree<>(7);
        Tree<Integer> tree8 = new Tree<>(8);
        Tree<Integer> tree10 = new Tree<>(10);
//        tree10.right = tree11;
//        tree9.right = tree10;
//        tree8.right = tree9;
//        tree8.left  = tree7;
        //  左旋
//        Tree tree = rotateLeft(tree8);
//        System.out.println(tree.toString());
        //  右旋
        tree9.right = tree10;
        tree7.left = tree9;
        tree8.left = tree7;
        tree8.right = tree11;
        Tree tree = rotateRight(tree8);
        System.out.println(tree.toString());


    }

    //左旋
    public static Tree rotateLeft(Tree tree){
        //新的根节点为原来根节点的右孩子
        Tree newRoot = tree.right;
        //原来根节点的右孩子的左子树变成原来根节点的右子树
        //根节点的右孩子的左子树不一定存在
        if(tree.right.left != null){
            tree.right = tree.right.left;
            //它的值已经赋给了tree.right
            tree.right.left = null;
        }else {
            tree.right = null;
        }

        //让原来的根节点变为新的根节点的左子树
        newRoot.left = tree;

        return newRoot;
    }

    //右旋
    public static Tree rotateRight(Tree tree){
        //根节点的左孩子变成新根节点
        Tree newRoot = tree.left;
        //让原来的根节点的左孩子的右子树变为原来根节点的左子树
        if(tree.left.right != null){
            tree.left = tree.left.right;
            tree.left.right = null;
        }else {
            tree.left = null;
        }
        //让原来的根节点变为新的根节点的右子树
        newRoot.right = tree;
        return newRoot;

    }
}

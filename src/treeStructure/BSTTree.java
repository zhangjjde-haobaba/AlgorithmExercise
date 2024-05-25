package treeStructure;

/**
 * Created by jiang on 10/2/23 11:45 PM
 */
public class BSTTree {
    public static void main(String[] args) {
        Tree<Integer> tree10 = new Tree<>(10);
        Tree<Integer> tree8 = new Tree<>(8);
        Tree<Integer> tree14 = new Tree<>(14);
        Tree<Integer> tree9 = new Tree<>(9);
        Tree<Integer> tree12 = new Tree<>(12);
        tree14.left = tree12;
        tree8.right = tree9;
        tree10.left = tree8;
        tree10.right = tree14;
        isContainsk(tree10,8);
    }
    //二叉查找树里是否包含某些节点
    public static void isContainsk(Tree<Integer> tree, int k){
        if(tree != null){
            if(k == tree.root){
                System.out.println("包含该节点");
            }else if(k>tree.root){
                    isContainsk(tree.right,k);
            }else if (k<tree.root){
                    isContainsk(tree.left,k);
            }
        }else {
            System.out.println("不包含");
        }

    }
}

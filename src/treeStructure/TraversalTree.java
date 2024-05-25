package treeStructure;

/**
 * Created by jiang on 10/2/23 4:13 PM
 * 树的遍历
 */
public class TraversalTree {
    public static void main(String[] args) {
//        Tree<String> A = new Tree<>("A");
//        Tree<String> B = new Tree<>("B");
//        Tree<String> C = new Tree<>("C");
//        Tree<String> D = new Tree<>("D");
//        Tree<String> E = new Tree<>("E");
//        B.left = D;
//        B.right = E;
//        A.left = B;
//        A.right = C;
//        preVisitor(A);
//        middleVisitor(A);
//        afterVisitor(A);
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] mid = {4,7,2,1,5,3,8,6};
        Tree tree = getTree(pre, mid);
        System.out.println(tree.toString());
    }
    /**
     * 前序遍历
     */
    public static void preVisitor(Tree tree){
        if(tree != null){
            //打印根节点
            System.out.println(tree.root);
            preVisitor(tree.left);
            preVisitor(tree.right);
        }

    }

    /**
     * 中序遍历
     *
     */
    public static void middleVisitor(Tree tree){
        if(tree != null){
            middleVisitor(tree.left);
            System.out.println(tree.root);
            middleVisitor(tree.right);
        }
    }

    /**
     * 后序遍历
     *
     */
    public static void afterVisitor(Tree tree){
        if(tree != null){
            afterVisitor(tree.left);
            afterVisitor(tree.right);
            System.out.println(tree.root);

        }
    }

    /**
     * 已知前序遍历是:1,2,4,7,3,5,6,8 中序遍历是:4,7,2,1,5,3,8,6
     *
     */
    public static Tree getTree(int[] pre, int[] middle){
        if(pre.length != middle.length){
            return null;
        }
        //前序遍历的第一个结果一定是root
        Tree<Integer> tree = new Tree<>(pre[0]);
        //如果数组的长度为1 代表只有根节点
        if(pre.length == 1){
            return tree;
        }else{
            //先找到root在中序中的索引
            for(int i=0;i<middle.length;i++){
                if(middle[i] == pre[0]){
                    //构建左树 在i左边的是左树
                    if(i>0){
                        int[] pre_left = new int[i];
                        int[] mid_left = new int[i];
                        for(int j=0;j<i;j++){
                            //因为前序的第一个元素是根 需要从第二个元素开始赋值
                            pre_left[j] = pre[j+1];
                            mid_left[j] = middle[j];

                        }
                        tree.left = getTree(pre_left,mid_left);
                    }else{
                        //没有左树
                        tree.left = null;
                    }

                    //构建右树
                    if(middle.length-1-i>0){
                        //判断根节点i在不在中序的最右边 如果不在创建树 否则右树不存在
                        int[] pre_right = new int[middle.length-1-i];
                        int[] mid_right = new int[middle.length-1-i];
                        for(int j=0;j<middle.length-1-i;j++){
                            //因为前序的第一个元素是根 需要从第二个元素开始赋值
                            pre_right[j] = pre[j+middle.length-1-i];
                            mid_right[j] = middle[j+middle.length-1-i];
//                            pre_right[j] = pre[j+i+1];
//                            mid_right[j] = middle[j+i+1];

                        }
                        tree.right = getTree(pre_right,mid_right);
                    }else {
                        tree.right = null;
                    }
                }
            }
        }
        return tree;
    }
}

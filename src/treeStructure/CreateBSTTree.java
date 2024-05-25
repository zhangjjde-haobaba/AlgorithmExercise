package treeStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang on 10/4/23 4:12 PM
 */
public class CreateBSTTree {

    static List<Integer> list2 = new ArrayList<>(); //接受中序遍历的结果
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(7);
        list.add(9);
        Tree tree = buildBST(list);
        System.out.println(tree.toString());
        preVisitor(tree);
        list2  = validBST(tree);
        boolean flag = isUp(list2,0,list2.size()-1);
        System.out.println(flag);

    }
    //已知二叉查找树的先序遍历结果，构建二叉查找树
    public static Tree buildBST(List<Integer> list){
        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        //判断有可能发生的异常
        if(list.size()<1){
            return null;
        }
        //先序遍历的结果第一个元素肯定是根节点
        Tree<Integer> tree=new Tree<>(list.get(0));
        if(list.size()==1){
            return tree;
        }
        //构建左树，二叉查找树左树上任意一个节点都小于根
        int i;
        for(i=1;i<list.size();i++){
            //左树的范围的索引应该是1~i-1
            if(list.get(i)<list.get(0)){
                left.add(list.get(i));
            }else{
                break;
            }
        }
        tree.left=buildBST(left);

        for(int j=i;j<list.size();j++){
            //右树的范围的索引应该是i~list.size()-1
            right.add(list.get(j));

        }
        tree.right=buildBST(right);
        return tree;

    }

    public static void preVisitor(Tree tree){
        if(tree != null){
            //打印根节点
            System.out.println(tree.root);
            preVisitor(tree.left);
            preVisitor(tree.right);
        }

    }

    //判断是不是二叉查找树
    public static List<Integer> validBST(Tree<Integer> tree){
        //方法1：
        //找出左树上最大的节点，判断是否小于根
        //找出右树上最小的节点，判断是否大于根

        //方法2：
        //二叉查找树的中序遍历结果一定是升序的
        //遍历中序结果查看是否为升序
        //note 二叉查找树也可以是空树

        if(tree == null){
            return null;
        }
        if(tree.left != null){
            validBST(tree.left);
        }

        if(tree.root != null){
            list2.add(tree.root);
        }

        if(tree.right != null){
            validBST(tree.right);
        }
        return list2;
    }

    public static boolean isUp(List<Integer> list, int start, int end){
        boolean flag = true;  // 初始化 flag 为 true

        if((start+1)<=end && flag){
            if(list.get(start+1)>list.get(start)){
                flag = isUp(list,start+1,end);
            }else {
                flag = false;
            }
        }
        //只有前面一直符合条件才能走到这一步
        return flag;
    }
}

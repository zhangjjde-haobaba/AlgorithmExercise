package treeStructure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by jiang on 10/14/23 9:02 PM
 */
public class BFSAndDFS {
    public static void main(String[] args) {
        Tree<String> treeA=new Tree<>("A");
        Tree<String> treeB=new Tree<>("B");
        Tree<String> treeC=new Tree<>("C");
        Tree<String> treeD=new Tree<>("D");
        Tree<String> treeE=new Tree<>("E");
        Tree<String> treeF=new Tree<>("F");
        Tree<String> treeH=new Tree<>("H");
        treeD.left=treeH;
        treeB.left=treeD;
        treeB.right=treeE;
        treeC.left=treeF;
        treeA.left=treeB;
        treeA.right=treeC;
        System.out.println("广度优先搜索：");
        BFS(treeA);
        System.out.println("深度优先搜索：");
        DFS(treeA);
    }
    //给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。比如，
    // 员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的
    // 数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。
    // 注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
    // 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。





    public static void DFS(Tree<String> tree){
        Stack<Tree> deque=new Stack<>();
        deque.push(tree);
        while(!deque.isEmpty()){
            Tree root=deque.pop();
            System.out.print(root.root+"-->");
            if(root.root.equals("H")){
                break;
            }
            if(root.left!=null){
                deque.push(root.left);
                continue;
            }
            if(root.right!=null){
                deque.push(root.right);
                continue;
            }

        }
        System.out.println();
    }

    /**
     *
     * 初始化：将根节点压入栈中。
     *
     * 遍历：当栈不为空时，执行以下步骤：
     *
     * 从栈中弹出一个节点，这是当前正在访问的节点。
     * 访问该节点（例如，打印节点值）。
     * 如果该节点是特定的节点（例如，值为"H"），则停止遍历。
     * 如果该节点有右子节点，将右子节点压入栈。
     * 如果该节点有左子节点，将左子节点压入栈。
     * 重复：重复步骤2，直到栈为空。
     *
     * 这种遍历方式首先访问左子节点，然后是右子节点。由于栈是后进先出的，所以实际上先访问的是最后一个被压入栈的节点。
     * 这意味着如果一个节点有左右两个子节点，它会先访问右子节点，然后才是左子节点。
     */

    //广度优先
    public static void BFS(Tree<String> tree){
        Deque<Tree> deque=new LinkedList<>();
        deque.offer(tree);
        while(!deque.isEmpty()){
            Tree root=deque.pop();
            System.out.print(root.root+"-->");
            if(root.root.equals("H")){
                break;
            }
            if(root.left!=null){
                deque.offer(root.left);
            }
            if(root.right!=null){
                deque.offer(root.right);
            }

        }
        System.out.println();


    }
    /**
     * 初始化：将根节点加入队列中。
     *
     * 遍历：当队列不为空时，执行以下步骤：
     *
     * 从队列中移除一个节点，这是当前正在访问的节点。
     * 访问该节点（例如，打印节点值）。
     * 如果该节点是特定的节点（例如，值为"H"），则停止遍历。
     * 如果该节点有左子节点，将左子节点加入队列。
     * 如果该节点有右子节点，将右子节点加入队列。
     * 重复：重复步骤2，直到队列为空。
     *
     * 这种遍历方式首先访问同一层的所有节点，然后再访问下一层的节点。由于队列是先进先出的，所以先访问的是最先被加入队列的节点。
     */


}

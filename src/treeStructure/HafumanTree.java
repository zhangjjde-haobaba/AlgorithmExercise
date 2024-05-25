package treeStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jiang on 10/8/23 5:55 PM
 */
public class HafumanTree {
    //假如给定一个序列：33，45，145，25，8，45，38，1 这些都是权重
    // 33为F出现的频次 45为D出现的频次 145为A出现的频次
    // 25为G出现的频次 8为P出现的频次 45为E出现的频次 38为B出现的频次 1为Z出现的频次
    static List<HuffmanTree> list=new ArrayList<>();
    public static void main(String[] args) {
        HuffmanTree<Character> huffmanTreeF=new HuffmanTree<>('F',33);
        list.add(huffmanTreeF);
        HuffmanTree<Character> huffmanTreeD=new HuffmanTree<>('D',45);
        list.add(huffmanTreeD);
        HuffmanTree<Character> huffmanTreeA=new HuffmanTree<>('A',145);
        list.add(huffmanTreeA);
        HuffmanTree<Character> huffmanTreeG=new HuffmanTree<>('G',25);
        list.add(huffmanTreeG);
        HuffmanTree<Character> huffmanTreeP=new HuffmanTree<>('P',8);
        list.add(huffmanTreeP);
        HuffmanTree<Character> huffmanTreeE=new HuffmanTree<>('E',45);
        list.add(huffmanTreeE);
        HuffmanTree<Character> huffmanTreeB=new HuffmanTree<>('B',38);
        list.add(huffmanTreeB);
        HuffmanTree<Character> huffmanTreeZ=new HuffmanTree<>('Z',1);
        list.add(huffmanTreeZ);
        HuffmanTree huffmanTree = createHuffman();
        System.out.println(huffmanTree.toString());
    }

    public static HuffmanTree<Character> createHuffman(){
        while(list.size()>1){
            //升序-->Compareable接口后是降序
            Collections.sort(list);
            //倒数第一个数肯定是最小的，次之倒数第二个数
            HuffmanTree<Character> left = list.get(list.size()-1);
            HuffmanTree<Character> right = list.get(list.size()-2);
            //构造一颗新树，权重是最小两个树权重之和
            HuffmanTree<Character> root = new HuffmanTree<>(null,list.get(list.size()-1).weight+list.get(list.size()-2).weight);
            root.left = left;
            root.right = right;
            //移除被使用的元素
            list.remove(list.size()-1);
            list.remove(list.size()-1);
            list.add(root);
        }
        return list.get(0);
    }

    /**
     * Collections.sort(list) 方法根据列表元素的自然顺序对列表进行升序排序。
     * 如果列表元素实现了 Comparable 接口，sort 方法会使用这些元素的 compareTo 方法来确定它们的顺序。
     * 在 createHuffman() 方法中调用 Collections.sort(list)，
     * sort 方法会使用 HuffmanTree 类的 compareTo 方法来确定排序顺序。
     * 在这种情况下，哈夫曼树将根据它们的 weight 属性进行排序，且由于 compareTo 方法的实现，
     * 排序将是降序的（weight 较大的对象排在前面）。
     */

}

class HuffmanTree<E> implements Comparable<HuffmanTree>{

    E root;
    double weight;
    HuffmanTree<E> left;
    HuffmanTree<E> right;

    public HuffmanTree(E root, double weight) {
        this.root = root;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HuffmanTree{" +
                "root=" + root +
                ", weight=" + weight +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public int compareTo(HuffmanTree huffmanTree) {
        if(huffmanTree.weight>this.weight){
            return 1;
        }else if(huffmanTree.weight < this.weight){
            return -1;
        }
        return 0;
    }

}

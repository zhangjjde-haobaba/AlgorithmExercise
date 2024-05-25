package NodeStructure;

/**
 * Created by jiang on 2/5/23 12:04 PM
 */
public class NodeDemo {
    public static void main(String[] args) {
        SingleLinkedNode<Integer> singleLinkedNode = new SingleLinkedNode<>();
        singleLinkedNode.add(1);
        singleLinkedNode.add(2);
        singleLinkedNode.add(4);
        singleLinkedNode.add(5);
        singleLinkedNode.insertAfterNode(2,3);
        singleLinkedNode.traversal();
        singleLinkedNode.deleteAfterNode(2);
        singleLinkedNode.traversal();
        singleLinkedNode.deleteFront();
        singleLinkedNode.traversal();
        Node<Integer> node = singleLinkedNode.reverse();
        System.out.println(node);
    }

}
//单向链表
class SingleLinkedNode<E>{
    private Node<E> node;//链表
    private Node<E> tail;//尾指针
    //单向列表:1->2->3->4->null
    //添加(尾部添加), 插入， 修改头节点，修改某个节点之后的节点,遍历

    //尾部添加
    public void add(E e){

        //先判断链表是否为空，如果为空那么新增的就是头节点也是尾节点，如果不为空要让原来的尾节点指向新增的节点
        //尾指针更新为新添加节点
        System.out.println("添加节点："+e);
        Node<E> newNode=new Node<>(e);
        if(node==null){
            node=newNode;
        }else{
            tail.setNext(newNode);
        }
        //更新尾元素
        tail=newNode;
    }

    //插入到指定节点后面
    public void insertAfterNode(E oldNode, E newNode){
        //3种插入可能 将B插入到A之后
        //1.D->E->A->C A为一个普通节点
        //2.A A为头节点
        //3.D->A A为尾节点
        Node<E> nodeCopy = node; //链表的拷贝
        Node<E> nodeA = null;
        while(true){
            if(nodeCopy==null){
                System.out.println("链表为空");
                break;
            }
            //先用链表的头节点进行比较(0代表找到了)
            if(nodeCopy.compareTo(oldNode)==0){
                nodeA = nodeCopy;
                break;
            }
            nodeCopy = nodeCopy.getNext();
        }
        //链表中有一个节点的值域为oldNode
        if(nodeA != null){
            System.out.println("值域为"+oldNode+"的节点后面添加值域为"+newNode+"的节点");
            //根据newNode创建节点
            Node<E> enode = new Node<>(newNode);
            //A->C ==== A->B->C
            enode.setNext(nodeA.getNext());
            nodeA.setNext(enode);
            //如果tail==nodeA那么原来的A节点为尾节点
            if(tail==nodeA){
                //更新尾节点
                tail = enode;
            }
        }else{
            System.out.println("链表中不存在值域是"+oldNode+"的节点");
        }

    }
    //删除头节点
    public boolean deleteFront(){
        //1.A->B->C删除A只需要覆盖
        if(node==null){
            System.out.println("链表为空");
        }else{
            System.out.println("删除头节点");
            Node<E> bNode = node.getNext();
            node = bNode;
            //2.A 只有一个元素 删完之后尾节点也需要为null
            if(node==null){
                tail = null;
            }
        }
        return true;
    }
    //删除某个节点之后的节点
    public void deleteAfterNode(E oldNode){
        //3种插入可能 将B插入到A之后
        //1.D->E->A->C A为一个普通节点
        //2.A A为头节点
        //3.D->A A为尾节点
        Node<E> nodeCopy = node; //链表的拷贝
        Node<E> nodeA = null;
        while(true){
            if(nodeCopy==null){
                System.out.println("链表为空");
                break;
            }
            //先用链表的头节点进行比较(0代表找到了)
            if(nodeCopy.compareTo(oldNode)==0){
                nodeA = nodeCopy;
                break;
            }
            nodeCopy = nodeCopy.getNext();
        }
        //链表中有一个节点的值域为oldNode
        if(nodeA != null){
            System.out.println("删除链表中值域为"+oldNode+"的节点后面的节点");
            //A->B->C 删除B
            //A不是尾节点的情况
            if(tail!=nodeA){
                Node<E> bNode = nodeA.getNext();
                nodeA.setNext(bNode.getNext());
            }
            //A->B B删除了A就是尾节点了
            if(nodeA.getNext()==null){
                tail = nodeA;
            }


        }else{
            System.out.println("链表中不存在值域是"+oldNode+"的节点");
        }

    }
    //遍历
    public void traversal(){
        Node<E> nodeCopy = node; //链表的拷贝
        while(true){
            if(nodeCopy==null){
                System.out.println("链表为空");
                break;
            }
            System.out.println(nodeCopy.getValue());
            nodeCopy = nodeCopy.getNext();

        }
    }

    //反转 非常重要
    public Node<E> reverse(){
        //null->1->2->3->4->5 == 5->4->3->2->1->null
        Node<E> curr = node; //链表当前的指针
        Node<E> next = null;//反转以后的下一个指针
        //反转后的链表
        Node<E> reverseNode = new Node<>();
        while(curr.getNext()!=null){ //curr.getNext()==null说明已经遍历到最后了
            //1.创建一个节点
            Node<E> temp = new Node<>();
            temp.setValue(curr.getValue());
            temp.setNext(next);
            reverseNode.setValue(curr.getNext().getValue());
            reverseNode.setNext(temp);
            next = temp;
            curr = curr.getNext();
        }

        return reverseNode;
    }

}
//链表的数据结构
class Node<E> implements Comparable{
    private E value; //值域
    private Node<E> next; //指针域:指向下一个元素

    public E getValue() {
        return value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node(E value) {
        this.value = value;
    }

    public Node() {
    }

    //判断相等，只比较值域
    @Override
    public int compareTo(Object o) {
        //比较此对象与指定对象的顺序，0相等 1大于 -1小于。
        if(o==this.value){
            return 0;
        }else{
            return 1;
        }

    }
}

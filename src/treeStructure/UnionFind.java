package treeStructure;

/**
 * Created by jiang on 10/14/23 9:13 PM
 *
 * 并查集 -- 用来判断两个点是否相连的
 */
public class UnionFind implements UF{

    private int[] id; //组

    public UnionFind(int size) {
        this.id = new int[size];
        //初始化时默认索引就是组id
        for(int i=0;i<size;i++){
            id[i] = i;
        }
    }

    //找组id
    private int find(int index){
        if(index>0 && index<id.length){
            return id[index];
        }
        throw new IllegalArgumentException("索引参数不合法");
    }

    @Override
    public boolean isConnected(int p, int q) {
        //先找出p的组号
        int pId = find(p);
        // q的组号
        int qId = find(q);
        return pId == qId;
    }

    @Override
    public void unionElement(int p, int q) {
        //先找出p的组号
        int pId = find(p);
        // q的组号
        int qId = find(q);
        for(int i=0;i<id.length;i++){
            if(id[i] == pId){
                id[i]=qId;
            }
        }


    }

    public void printArr(){
        for(int i:id){
            System.out.print(i+"\t\t");
        }
        System.out.println();
    }
}

interface UF{
    //是否相连
    boolean isConnected(int p, int q);
    //并（分组归类）
    void unionElement(int p,int q);
}

class UFTest{
    public static void main(String[] args) {
        UnionFind unionFind=new UnionFind(10);
        unionFind.printArr();
        System.out.println("5 6 合并为一组");
        unionFind.unionElement(5,6);
        System.out.println("合并5，6后：");
        unionFind.printArr();
        System.out.println(unionFind.isConnected(4,6));
    }

}
package treeStructure;

/**
 * Created by jiang on 10/11/23 11:55 AM
 */
public class SegmentTreeTest {
    public static void main(String[] args) {
        Integer[] arr = {12,7,6,5,4};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, new Merge<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a+b;
            }
        });
        System.out.println(segmentTree);
        System.out.println(segmentTree.queryArea(1,2));
    }
}

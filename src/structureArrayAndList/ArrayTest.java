package structureArrayAndList;

/**
 * Created by jiang on 1/26/23 12:11 PM
 */
public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> arr = new Array();
        System.out.println("数组开辟的内存大小是:"+arr.getCapacity());
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.add(1,4);
        arr.remove(1);
        arr.update(1,4);
        arr.addLast(6);
        arr.addLast(7);
        arr.addLast(8);
        System.out.println("数组开辟的内存大小是:"+arr.getCapacity());
        System.out.println(arr.toString());
        System.out.println(arr.get(1));
        System.out.println(arr.isEmpty());
        System.out.println(arr.contains(4));
    }
}

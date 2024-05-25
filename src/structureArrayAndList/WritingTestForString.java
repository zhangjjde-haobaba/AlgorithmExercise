package structureArrayAndList;

/**
 * Created by jiang on 10/16/23 5:33 PM
 */
public class WritingTestForString {
    public static void main(String[] args) {
        String str="abcdedcabccba";
//        System.out.println(method1_1(str,0,str.length()-1));
//        System.out.println(method1_2(str,0,str.length()-1));
        System.out.println(method2_1(str));
    }


    /*
     * 1.字符串反转：给定一个字符串，反转指定的部分，比如字符串的值为abc,
     * 全部反转为cba；如给定一个abcde,反转2-4，就是abedc
     * */
    //借鉴选择排序 分为未反转区和以反转区
    //把未反转区的第一个放在已反转区的第一个
    //abcdefg --> bcdefg | a --> cdefg | ba  --> defg | cba .... gfedcba
    public static String method1_1(String str, int start, int end){
        //字符串转数组
        char[]  arr = str.toCharArray();
        int finish = end +1; //已反转区在未反转区的后面第一个位置
        while(finish>start){
            //未反转区的第一个值
            char temp = arr[start];
            for(int i=start+1;i<finish;i++){
                arr[i-1] = arr[i];
            }
            arr[finish-1] = temp;
            finish--;
        }
        return String.valueOf(arr);

    }

    //先找到需要反转的中间位置 再交换两边的内容
    public static String method1_2(String str, int start, int end){
        //字符串转数组
        char[]  arr = str.toCharArray();
        //中轴线
        int mid = start + (end-start)/2;
        for(int i=start;i<=mid;i++){
            swap(arr,start+i,end-i);
        }
        return String.valueOf(arr);
    }

    //交换指定位置的字符
    public static void swap(char[] arr, int left, int right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    /*
     * 2.寻找最大的回文子串长度，比如abcdedcabba,最大回文子串即cdedc
     * */
    public static int method2_1(String str){
        if(str.length()<1||str==null){
            return 0;
        }
        int max=0, current=0, length=str.length(); //记录最长的回文长度 当前访问的回文字符串长度 字符串长度
        //str.charAt(i) 找中点值
        for(int i=0;i<str.length();i++){
            //如果回文字符串是奇数 中点值有1个
            //以当前的元素为中点从头开始找回文左边
            for(int j=0; (i-j)>0&&(i+j)<length; j++){
                //如果左右两边不对称 就跳出来
                if(str.charAt(i-j)!=str.charAt(i+j)){
                    break;
                }
                current=2*j+1;
            }

            //如果回文字符串是偶数 中点值有2个
            for(int j=0; (i-j)>0&&(i+j+1)<length; j++){
                //如果左右两边不对称 就跳出来
                if(str.charAt(i-j)!=str.charAt(i+j+1)){
                    break;
                }
                current=2*j+2;
            }
            if(current>max){
                max=current;
            }

        }
        return max;

    }

}

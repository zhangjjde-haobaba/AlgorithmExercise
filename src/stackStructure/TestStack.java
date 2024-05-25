package stackStructure;

/**
 * Created by jiang on 1/29/23 5:44 PM
 */
public class TestStack {
    public static void main(String[] args) {
        StackDemo<Integer> stackDemo = new StackDemo<>();
        System.out.println("栈是否为空:"+stackDemo.isEmpty());
        stackDemo.push(1);
        stackDemo.push(2);
        stackDemo.push(3);
        stackDemo.push(4);
        System.out.println("此时的栈顶元素:"+stackDemo.peek());
        stackDemo.pop();
        System.out.println("此时的栈顶元素:"+stackDemo.peek());
        System.out.println(isValidate("(())"));
        System.out.println("***********************");
        System.out.println(testEqual("ab#c","ad#c"));
    }

    //栈的面试题
    //1.给定一个只包括'(',')','{','}','[',']'的字符串,判断字符串是否有效
    //有效的字符串满足：1）左括号必须使用相同的右括号闭合2)左括号必须按照正确的顺序进行闭合3)注意空字符串可被认为是有效字符串
    public static boolean isValidate(String str){
        StackDemo<Character> stackDemo = new StackDemo<>();

        //空字符串可被认为是有效字符串
        if(str==null||str==""){
            return true;
        }
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            //如果是左括号 压入栈
            if(c=='('||c=='{'||c=='['){
                stackDemo.push(c);
            }else{
                //c是右括号
                if(stackDemo.isEmpty()){
                    //如果栈是空的并且第一个是字符是）那肯定不是个字符串
                    return false;
                }
                //查看栈顶元素
                char top = stackDemo.pop(); //肯定是左括号 只有左括号才被压入栈
                if(c==')'&&top!='('){
                    return false;
                }
                if(c==']'&&top!='['){
                    return false;
                }
                if(c=='}'&&top!='{'){
                    return false;
                }
            }
        }
        // ((())
        //如果比较完了栈也为空的时候才是一个字符串否则不是
        return stackDemo.isEmpty();
    }
    /*
    * 2.给定S和T两个字符串，当它们分别被输入到空白的文本编辑器中，判断二者是否相等，并返回结果 #代表退格字符
    *示例1：
    *   输入：S："ab#c" T："ad#c"
    *   返回true
    *   解释S和T都会变成ac
    * 示例2：
    *   输入:S:"ab##" T:"c#d#"
    *   返回true
    *   解释S和T都会变成""
    * */
    public static boolean testEqual(String s, String t){
        //有一个为null的话，那么就不想等
        if(s==null||t==null){
            return false;
        }
        //如果两个都为null那么认为是相等的
        if((s==null || s=="") && (t==null || t=="") ){
            return true;
        }
        //遍历两个字符串
        //封装一个方法
        return saveInStack(s).equals(saveInStack(t));
    }

    public static String saveInStack(String str){
        StackDemo<Character> stackDemo = new StackDemo<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='#'){
                stackDemo.push(str.charAt(i));
            }else{
                if(!stackDemo.isEmpty()){
                    stackDemo.pop();
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!stackDemo.isEmpty()){
            sb.append(stackDemo.pop());
        }
        return sb.toString();
    }
}


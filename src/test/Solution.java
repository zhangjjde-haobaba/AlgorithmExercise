package test;

/**
 * Created by jiang on 10/1/23 7:01 PM
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("WRRWWR"));

    }

    public static int solution(String s){
        int firstIndex = s.indexOf('R');
        int lastIndex = s.lastIndexOf('R');
        int count = 0;
        for(int i=firstIndex;i<=lastIndex;i++){
            if(s.charAt(i)=='W'){
                count++;
            }
        }
        return count;
    }
}

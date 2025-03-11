package String;

import java.io.IOException;
import java.util.Scanner;

public class 대소문자바꾸기 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] ans = str.toCharArray();
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if('A' <= c && c <= 'Z'){
                ans[i] = (char)('a' + c-'A');
                answer += ('a' + c-'A');
            }else{
                ans[i] =(char) ('A' + c-'a');
                answer += ('A' + c-'a');
            }
        }
        System.out.println(answer);
        System.out.println(ans);
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if(Character.isUpperCase(c)){
//                word += Character.toLowerCase(c);
//            }else{
//                word += Character.toUpperCase(c);
//            }
//        }
    }
}

package String;

import java.util.Scanner;

public class 가장짧은문자거리 {
    public int[] solution(String str, char n){
        int length = str.length();
        int[] arr = new int[length];
        int p = 1000;
        for (int i = 0; i < length; i++) {
            if(str.charAt(i) == n){
                p=0;
                arr[i] = p;
            }else{
                p++;
                arr[i] = p;
            }
        }
        p = 1000;
        for (int i = length-1; i >= 0 ; i--) {
            if(str.charAt(i) == n){
                p=0;
            }else{
                p++;
                arr[i] = Math.min(arr[i], p);
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        가장짧은문자거리 T = new 가장짧은문자거리();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char n = scanner.next().charAt(0);
        for (int x: T.solution(str, n)) {
            System.out.print(x+" ");
        }
    }
}

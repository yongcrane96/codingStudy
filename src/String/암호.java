package String;

import java.util.Scanner;

public class 암호 {
    public String solution(String str, int n){
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int t = Integer.parseInt(tmp, 2);
            answer += (char) t;
            str = str.substring(7);
        }
        return answer;
    }
    public static void main(String[] args) {
        암호 T = new 암호();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.print(T.solution(str, n));
    }
}

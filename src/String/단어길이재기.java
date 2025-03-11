package String;

import java.util.Scanner;

public class 단어길이재기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int n = scanner.nextInt()-1;

        System.out.println(str.charAt(n));
    }
}
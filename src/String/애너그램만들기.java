package String;

import java.io.IOException;
import java.util.Scanner;

public class 애너그램만들기 {
    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        int[] countA = getAlphabetCount(a);
        int[] countB = getAlphabetCount(b);
        int answer =0;

        for (int i = 0; i < 26; i++) {
            answer += Math.abs(countA[i]-countB[i]);
        }
        System.out.println(answer);
    }
}
package String;

import java.io.IOException;
import java.util.Scanner;

public class 소금폭탄 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.next().split(":");
        String[] b = scanner.next().split(":");

        int aHour = Integer.parseInt(a[0]);
        int aMinute = Integer.parseInt(a[1]);
        int aSecond = Integer.parseInt(a[2]);
        int aSecondAmount = aHour * 3600 + aMinute * 60 + aSecond;

        int bHour = Integer.parseInt(b[0]);
        int bMinute = Integer.parseInt(b[1]);
        int bSecond = Integer.parseInt(b[2]);
        int bSecondAmount
                = bHour * 3600 + bMinute * 60 + bSecond;

        int needSecondAmount = bSecondAmount - aSecondAmount;
        if(needSecondAmount <= 0){
            needSecondAmount += 24 * 3600;
        }

        int needHour = needSecondAmount / 3600;
        int needMinute = (needSecondAmount % 3600) / 60;
        int needSecoed = needSecondAmount % 60;

        System.out.printf("%02d:%02d:%02d", needHour, needMinute, needSecoed);


    }
}

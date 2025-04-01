package 이분탐색;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 문자열집합 {
    public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    String[] arr = new String[a];
        for (int i = 0; i < a; i++) {
        arr[i] = sc.next();
    }

        Arrays.sort(arr);

    int count = 0;
        while (b-- > 0){
        String x = sc.next();
        if(isExist(arr, x))
            count++;
    }
        System.out.println(count);
}

    private static boolean isExist(String[] A, String target){
        int l = 0, r = A.length -1 ;
        while (l <= r){
            int mid = l + (r - l) / 2;
            int compareResult = A[mid].compareTo(target);
            if(compareResult < 0)  l = mid + 1;
            else if (compareResult > 0) r = mid - 1;
            else return true;
        }return false;
    }
}

package 이분탐색;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 세수의합 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        // A + B + C = X -> A + B = X - C
        // 1. A + B의 집합을 만든다.
        int[] sums = new int[N * (N+1) / 2];
        int sumsIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sums[sumsIndex++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(sums);

        // 2. 모든 X - C 에 대해 A +B 집합에 존재하는지 확인한다.
        int ans = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];
                if(isExist(sums, target))
                    ans = Math.max(ans, arr[i]);
            }
        }
        System.out.println(ans);
    }

    private static boolean isExist(int[] A, int target){
        int l = 0, r = A.length -1 ;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(A[mid] == target) return true;
            if(A[mid] < target) l = mid + 1;
            else  r = mid - 1;
        }return false;
    }

}
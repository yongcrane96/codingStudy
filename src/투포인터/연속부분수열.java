package 투포인터;

import java.io.IOException;
import java.util.Scanner;

public class 연속부분수열 {
    public int solution(int n, int m, int[] arr){
        // 투포인트, 슬라이딩 알고리즘은 O(n2)을 -> O(n)으로 풀어내는 능력
        int answer = 0;
        int sum = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum+= arr[rt];
            if(sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if(sum == m) answer++;
            }
        }
        return  answer;
    }

    public void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.print(solution(n,m,a));
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin {
    // n 가지의 종류의 동전 있음
    // k 원이 되도록 하고 싶다
    static int n, k;
    static int[] dp, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        dp = new int[k+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j-arr[i]]; // arr[i] 는 사용하는 동전의 크기 점화식
            }
        }
        System.out.println(dp[k]);
    }

}

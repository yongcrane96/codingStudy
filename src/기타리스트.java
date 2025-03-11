import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타리스트 {
    // n 곡의 개수, s 시작 볼륨 , m보다 큰 값으로 볼륨 변경 X
    static int n,s,m;
    // 볼륨의 리스트 v
    //  P+V[i]나 P-V[i] 로 연주해야된다.
    static int[] v;
    static boolean[][] dp; // [곡][볼륨]
    // 마지막 곡을 연주할 수 있는 볼륨 중 최댓값을 구하는 프로그램
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        v = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[n+1][m+1];
        dp[0][s] = true; //시작 볼륨 설정

        for (int i = 0; i < n; i++) { //각 곡에대해
            for (int j = 0; j <= m; j++) { // 각 볼륨에 대해
                if(dp[i][j]){
                    if(j + v[i+1] <= m) dp[i+1][j + v[i+1]] = true;
                    if(j - v[i+1] >= 0) dp[i+1][j - v[i+1]] = true;
                }
            }
        }
        int maxVolume = -1;
        for (int i = m; i >= 0 ; i--) {
            if(dp[n][i]){
                maxVolume = i;
                break;
            }
        }
        System.out.println(maxVolume);
    }
}

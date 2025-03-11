import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Study3 {
    static int N;
    static long K; // 버틸수 있는 무게!!
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            arr[i][i] = Integer.parseInt(str.nextToken());
        }

        System.out.println(N);
        System.out.println(K);
        System.out.println(Arrays.toString(arr));
    }

}
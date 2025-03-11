import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Study {
    static int N; // 입국 심사대 갯수,
    static long M; // 사람 수
    static int[] arr;
    static long MAX_VALUE;
    static long result;
    // 심사를 받는데 걸리는 시간의 최솟값을 구하는 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        long max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        MAX_VALUE = M * max; // 사람 수에 따라 제일 최대로 걸리는 값
        result = MAX_VALUE;
        Arrays.sort(arr); // 이분탐색을 위한 정렬
        solve();
        System.out.println(result);
    }
    // 시간 기준으로 이분 탐색 진행
    static void solve(){
        long min = 0;
        long high = MAX_VALUE;

        while (min <= high){
            long mid = (min+high)/2;
            long sum = 0;

            for (int i : arr) {
                long cnt = mid / i;

                if(sum >= M || i >= mid){
                    break;
                }
                sum += cnt;
            }
            if(sum >= M){
                high = mid -1;
                result = Math.min(result, mid);
            }else{
                min = mid+1;
            }
        }
    }
}
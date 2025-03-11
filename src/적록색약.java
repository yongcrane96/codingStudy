import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 {
    // 적록 색약이 아닌 사람의 구역 개수와 적록색약의 구역의 수 출력
    static int n; // <- 입력값
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int cnt = 0; // 정상
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        int normal_cnt = cnt;
        cnt = 0;
        visited = new boolean[n+1][n+1];

        // 색약인 경우 G->R로 변경
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 'G') arr[i][j] = 'R';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        int abnormal_cnt = cnt;
        System.out.println(normal_cnt + " " + abnormal_cnt);
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        char temp = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                if(!visited[nx][ny] && arr[nx][ny] == temp) dfs(nx, ny);
            }
        }
    }
}

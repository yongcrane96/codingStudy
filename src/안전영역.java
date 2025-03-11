import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class 안전영역 {
    // 2차원 베열 행 열 개수 나타내는 N
    static int n;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // 물에 잠기지 않는 안전는 영역이 최대로 몇개가 만들어지는지
    // 높이도 있다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int maxHeight = 0;

        // 영역의 높이의 최댓값
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > maxHeight){
                    maxHeight = arr[i][j];
                }
            }
        }

        int max = 0;
        // 1. 모든 지역 탐색
        for (int height = 0; height < maxHeight; height++) {
            visited = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 2. 안전 영역 탐지
                    if(!visited[i][j] && arr[i][j] > height){
                        cnt+= dfs(i,j,height);
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    public static int dfs(int x, int y, int height){
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx> n-1 || ny > n-1) continue;
            if(visited[nx][ny]) continue;
            if(arr[nx][ny] > height){
                dfs(nx, ny, height);
            }
        }
        return 1;
    }

    public static int bfs(int x, int y, int height){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y]   = true;
        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            int px = pos[0];
            int py = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || nx > n-1 || ny < 0 || ny > n-1) continue;
                if(visited[nx][ny])continue;
                if(arr[nx][ny] > height){
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        return 1;
    }
}

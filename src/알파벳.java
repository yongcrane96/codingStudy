import java.util.Scanner;

public class 알파벳 {
    // 세로 R 칸 , 가로 C칸의 보드
    static int r, c;
    // 상하 좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 지금 까지 지나온 모든 칸에 적혀 있는 알파벳과 달라야한다.
    static boolean[] visited;
    static int[][] arr;
    // 최대의 칸수
    static int max;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        c = scanner.nextInt();
        scanner.nextLine();
        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j) - 'A';
            }
        }
        visited = new boolean[26];
        dfs(0,0,1);
        System.out.println(max);
        scanner.close();
    }

    public static void dfs(int x, int y, int len){
        visited[arr[x][y]] = true;
        max = Math.max(max, len);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny >= 0 && nx<r && ny < c){
                if(!visited[arr[nx][ny]]){
                    dfs(nx,ny, len + 1);
                    visited[arr[nx][ny]] = false;
                }
            }
        }
    }
}

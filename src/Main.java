import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    public static int findMaxRow(char[][] map){
        int N = map.length;
        int maxRow = 0;
        for (int i = 0; i < N; i++) {
            int len = 1;
            for (int j = 1; j < N; j++) {
                if(map[i][j] == map[i][j-1]) len++;
                else{
                    maxRow = Math.max(maxRow, len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len);
        }
        return maxRow;
    }
    public static int findMaxColumn(char[][] map){
        int N = map.length;
        int maxColumn = 0;
        for (int i = 0; i < N; i++) {
            int len = 1;
            for (int j = 1; j < N; j++) {
                if(map[j][i] == map[j-1][i]) len++;
                else{
                    maxColumn = Math.max(maxColumn, len);
                    len = 1;
                }
            }
            maxColumn = Math.max(maxColumn, len);
        }
        return maxColumn;
    }
    public static void swapCandy(char[][] map, int r1, int c1, int r2, int c2){
        char temp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = temp;
    }

    public static void main(String[] args) {
        // 1. 가능한 모든 쌍의 사탕을 서로 교환한다.
        // 2. 교환한 상태에서 가장 긴 연속 부분 행/열을 찾는다.
        // 3. 교환한 사탕을 원복한다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] map =new char[N][N];
        for (int i = 0; i < N; i++)
            map[i] = sc.next().toCharArray();

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(j+1 < N && map[i][j] != map[i][j + 1]){
                    swapCandy(map, i, j, i, j+1);
                    ans = Math.max(ans, Math.max(findMaxColumn(map), findMaxRow(map)));
                    swapCandy(map, i, j, i, j+1);
                }
                if(i+1 < N && map[i][j] != map[i+1][j]){
                    swapCandy(map, i, j, i+1, j);
                    ans = Math.max(ans, Math.max(findMaxColumn(map), findMaxRow(map)));
                    swapCandy(map, i, j, i+1, j);
                }
            }
        }
        System.out.println(ans);
    }
}

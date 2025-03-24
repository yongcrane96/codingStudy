import java.io.*;

class Main {
    static int answer;
    static boolean[] visit;
    static int[][] dungeon;
    public int solution(int n, int[][] arr){
        answer =0;
        dungeon = arr;
        visit = new boolean[dungeon.length];
       back(n, 0);
        return  answer;
    }

    private static void back(int n, int count){
        for (int i = 0; i < dungeon.length; i++) {
            if(!visit[i] && dungeon[i][0] <= n){
                visit[i] =true;
                back(n- dungeon[i][1], count + 1);
                answer = Math.max(answer, count+1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        int n = 80;
        int[][] arr = {{80,20},{50,40},{30,10}};
        System.out.print(T.solution(n,arr));
    }
}
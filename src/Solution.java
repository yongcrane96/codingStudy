import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
    private static ArrayList<Integer>[] addList;
    private static boolean[] visited;
    private static  ArrayList<Integer>  answer;

    public static void main(String[] args) {

    }
    private static int[] solution(int[][] graph, int start, int n){
    addList = new ArrayList[n + 1];
        for (int i = 0; i < addList.length; i++) {
            addList[i] = new ArrayList<>();
        }
        for (int[] edge: graph) {
            addList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n +1];
        answer = new ArrayList<>();
        bfs(start);

        return  answer.stream().mapToInt(Integer::intValue).toArray();
    }
    private static void bfs(int start){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();
            answer.add(now);

            for (int next: addList[now] ){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}

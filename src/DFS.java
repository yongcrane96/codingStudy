
class DFS {
    // 보드의 행과 열 그리고 최대 연결 길이를 저장하는 전역 변수 선언
    int rows =0;
    int cols =0;
    int maxLen = 0;

    public int solution(String[][] board){
        // 보드의 크기 설정
        rows =board.length;
        cols =board[0].length;

        // 모든 칸을 시작점으로 DFS 탐색을 수행
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] visited = new boolean[rows][cols];

                dfs(board, i, j, 1, visited, false);
            }
        }
        return maxLen;
    }

    /**
     * DFS 재귀 함수
     *
     * @param board  현재 보드
     * @param r      현재 행 위치
     * @param c      현재 열 위치
     * @param length 현재까지 연결된 길이
     * @param visited 방문 여부 배열
     * @param smallerMoveUsed 사전순 앞 알파벳으로 이동한적이 있는지 여부
     */
    private void dfs(String[][] board, int r, int c, int length, boolean[][] visited, boolean smallerMoveUsed){
        visited[r][c] = true; // 현재 칸 방문 처리

        maxLen = Math.max(maxLen, length); // 현재까지의 최대 연결 길이 갱신

        // 상하좌우 방향 벡터
        int[] dr = {-1, 1, 0, 0}; // 위, 아래
        int[] dc = {0, 0, -1, 1}; // 왼쪽, 오른쪽

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i]; // 다음 행
            int nc = c + dc[i]; // 다음 열

            // 보드 범위 안에 있고, 아직 방문하지 않은 경우만 탐색
            if(nr >= 0 && nr < rows && nc >= 0 && nc < cols
                    && !visited[nr][nc]){

                char current = board[r][c].charAt(0); // 현재 칸 알파벳
                char next = board[nr][nc].charAt(0);  // 다음 칸 알파벳

                // 사전순으로 더 뒤인 알파벳으로 이동 가능
                if(current > next){

                    dfs(board, nr, nc, length+1, visited, smallerMoveUsed);

                } else if (next < current && !smallerMoveUsed) {

                    dfs(board, nr, nc, length+1, visited, true);

                }
            }
        }
        visited[r][c] = false; // 백트래킹 : 다음 경로를 위해 방문 해제
    }

    public void main(String[] args) {
        String[][] board = {{"A", "B", "T", "T", "T"},
                {"T", "C", "D", "E", "Т"},{"T", "T", "T", "F", "T" },
                {"B", "A", "H", "G", "F"},{"C", "D", "E", "F", "G" }};
        System.out.println(solution(board));
    }
}

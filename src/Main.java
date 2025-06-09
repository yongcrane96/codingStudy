import java.util.*;

class Main {
        public static int[][] solution(int[][] matrix, int r) {
            int n = matrix.length;
            int rotations = r % 4;

            for (int i = 0; i < rotations; i++) {
                rotateOnce(matrix);
            }

            return matrix;
        }

        private static void rotateOnce(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n / 2; i++) {
                for (int j = i; j < n - 1 - i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                    matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                    matrix[j][n - 1 - i] = temp;
                }
            }
        }

    public static void main(String[] args) {
        int[][] matrix = {{1,2},{3,4}};
        int r = 1;
        System.out.println(Arrays.deepToString(solution(matrix,r)));
    }
}

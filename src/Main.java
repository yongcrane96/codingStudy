import java.util.*;

class Main {
        public static int[][] solution(int[][] matrix, int r) {
            int rotations = r % 4;

            for (int i = 0; i < rotations; i++) {
                rotateOnce(matrix);
            }

            return matrix;
        }

        private static void rotateOnce(int[][] matrix) {
            int n = matrix.length;

            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < n - 1 - i ; j++) {
                    int temp = matrix[i][j];
                    // 1 2    3 1
                    // 3 4    4 2
                    matrix[i][j] = matrix[n-1-j][i];
                    matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                    matrix[j][n-1-i] = temp;

                }
            }
                        // 1 2    3 1
                        // 3 4    4 2


        }

    public static void main(String[] args) {
        int[][] matrix = {{1,2},{3,4}};
        int r = 1;
        System.out.println(Arrays.deepToString(solution(matrix,r)));
    }
}

// 1 2 3  7 4 1
// 4 5 6  8 5 2
// 7 8 9  9 6 3

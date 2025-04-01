import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int findLowerBoundIndex(int[] arr, int x){
        // x 이상의 값이 처음으로 나타나는 위치
        int lowerBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r){
            int m = (l + r ) / 2;
            if(arr[m] < x) l = m + 1;
            else {
                r = m - 1;
                lowerBoundIndex = m;
            }
        }
        return  lowerBoundIndex;
    }

    static int findUpperBoundIndex(int[] arr, int x){
        // 2. x 초과의 값이 처음으로 나타나는 위치를 구한다.
        int upperBoundIndex = arr.length;
        int l = 0, r= arr.length -1;
        while (l <= r){
            int m = (l + r) /2 ;
            if(arr[m] <= x) l = m + 1;
            else{
                r = m - 1;
                upperBoundIndex = m;
            }
        }
        return  upperBoundIndex;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] cords = new int[N];
        for (int i = 0; i < N; i++)
            cords[i] = sc.nextInt();

        Arrays.sort(cords);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = sc.nextInt();
        while (M-- > 0){
            int x = sc.nextInt();
            // 1. x 이상의 값이 처음으로 나타나는 위치를 구한다.
            int lowerBoundIndex = findLowerBoundIndex(cords, x);
            // 2. x 초과의 값이 처음으로 나타나는 위치를 구한다.
            int upperBoundIndex = findUpperBoundIndex(cords, x);
            // 3. 두 값을 이용해 x의 개수를 센다.
            bw.write(upperBoundIndex - lowerBoundIndex + " ");
        }
        bw.write("\n");
        bw.flush();
        }

}
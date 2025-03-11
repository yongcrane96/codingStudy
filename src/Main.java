import java.util.Scanner;

public class Main {
    public String solution(String str, int n){
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int t = Integer.parseInt(tmp, 2);
            answer += (char) t;
            str = str.substring(7);
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.print(T.solution(str, n));
    }
}

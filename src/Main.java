import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String doc = scanner.nextLine();
    String word = scanner.nextLine();
    String replacedString = doc.replace(word, "");
    int replaced = doc.length() - replacedString.length();
    int length = replaced / word.length();
    int count = 0;
    int startIndex = 0;
    while (true){
        int findIndex = doc.indexOf(word, startIndex);
        if(findIndex < 0) break;
        count++;
        startIndex = findIndex + word.length();
    }
        System.out.println(count);
    }
}

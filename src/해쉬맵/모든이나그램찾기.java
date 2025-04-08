package 해쉬맵;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class 모든이나그램찾기 {
    public int solution(String a, String b){
    int answer = 0;
    HashMap<Character, Integer> am = new HashMap<>();
    HashMap<Character, Integer> bm = new HashMap<>();
    for (char x: b.toCharArray()) bm.put(x, bm.getOrDefault(x, 0)+1);
    int L = b.length()-1;
    for (int i = 0; i < L; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i),0)+1);
    int lt = 0;
    for (int rt = L; rt < a.length(); rt++) {
        am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0 )+1);
        if(am.equals(bm)) answer++;
        am.put(a.charAt(lt), am.get(a.charAt(lt))-1);
        if(am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
        lt++;
    }
    return answer;
}

    public void 모든이나그램찾기(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        String  n = kb.next();
        String  k = kb.next();
        System.out.print(solution(n,k));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 거스름돈 {
    public static void main(String[] args) {
        Integer[] coin = {1,10,50,100};
        int amount = 350;
        Arrays.sort(coin, Collections.reverseOrder());

        int count = 0;
        for (int value : coin) {
            count += amount / value;
            amount %= value;
        }

        amount =350;
        int[] result = new int[count];
        int index = 0;
        for (int value: coin) {
            while (amount >= value){
                result[index++] = value;
                amount -= value;
            }
        }
        System.out.println(Arrays.toString(result));
    }


    class Solution{
        private static int[] solution(int amount){
            int[] coin = {100, 50, 10, 1}; // 화폐단위를 내림 차순

            ArrayList<Integer> change = new ArrayList<>();

            for (int money: coin) {
                while (amount >= money){
                    change.add(money);
                    amount -= money;
                }
            }
            return change.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}

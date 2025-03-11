import java.util.Arrays;

public class 무인도 {
    public static void main(String[] args) {
        int[] people = new int[]{70, 50, 80, 50};
        Arrays.sort(people); // 50,50,70,80
        int limit = 100;
        int boats = 0;
        int left = 0;
        int right = people.length -1; // 3까지
        while (left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--;
            boats++;
        }

        System.out.println(boats);
    }

    private static int Solution(int[] people, int limit){
    people = new int[]{70, 50, 80, 50};
    limit = 100;

    int count = 0;
        for (int weight: people) {
            while (limit >= weight){
                count++;
                limit -= weight;
            }
        }
        return count;
    }
}

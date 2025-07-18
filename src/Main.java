class Main {

    public static int[] solution(int[] sales, int[] fromMonth, int[] toMonth){
        int n = sales.length;
        long[] prefixSum = new long[n+1]; // 누적합 배열(0부터 시작)

        for (int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i] + sales[i]; // 누적합 계산
        }
        // [0, 100, 201, 303, 406, 510]

        int queryCount = fromMonth.length;
        int[] answer = new int[queryCount];

        for (int i = 0; i < queryCount; i++) {
            int startIndex = fromMonth[i]; //1,2
            int endIndex = toMonth[i]; //2, 4
            // 309
            long sum = prefixSum[endIndex+1] - prefixSum[startIndex]; //구간합 계산
            answer[i] = (int) sum;
        }

        return answer;
    }



    public static void main(String[] args) {
        int[] sales = {100,101,102,103,104};
        int[] fromMonth = {1, 2};
        int[] toMonth = {2, 4};

        System.out.println(solution(sales, fromMonth, toMonth));
    }
}

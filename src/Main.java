class Main {
    private char[] tree; // 이진트리 구조로 메시지 저장할 배열
    private StringBuilder resultBuilder; // 후위 순위 결과를 달을 문자열 빌더

    public String solution(String message) {
        int n = message.length();
        tree = new char[n];

        for (int i = 0; i < n; i++) {
            tree[i] = message.charAt(i);
        }

        // 결과 문자열을 쌓아갈 StringBuilder 생성
        resultBuilder = new StringBuilder();

        // 후위 순회 시작 (루트 노드는 인덱스 0)
        postOrdertraversal(0);

        return resultBuilder.toString();
    }

    private void postOrdertraversal(int index) {
        if (index >= tree.length) return;


        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        postOrdertraversal(leftChildIndex);
        postOrdertraversal(rightChildIndex);
        resultBuilder.append(tree[index]);

    }

    private void preOrdertraversal(int index) {
        if (index >= tree.length) return;

        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        resultBuilder.append(tree[index]);
        preOrdertraversal(leftChildIndex);
        preOrdertraversal(rightChildIndex);
    }
    public static void main(String[] args) {
        String message = "ABCDEF";
        Main main = new Main();
        System.out.println(main.solution(message));
    }
}

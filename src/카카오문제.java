import java.util.Arrays;
import java.util.Comparator;

class 카카오문제 {
    int[][] result;
    int idx;
    public int[][] solution(int[][] nodeInfo) {
        //노드 배열을 초기화하고 각 노드를 입력받는다.
        Node[] node = new Node[nodeInfo.length];
        for (int i = 0; i < nodeInfo.length; i++) {
            node[i] = new Node(nodeInfo[i][0], nodeInfo[i][1], i+1, null, null);
        }
        // y값 큰 순서대로, y값 같다면 x 값 작은 순서대로 정렬
        // -> 이진트리의 형태 구성하는 문제이기에 y값(높이) 기준으로 내림차순
        // y값이 클수록 해당 노드는 트리에서 상위 레벨에 위치하기 위해
        Arrays.sort(node, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if(n1.y == n2. y) return n1.x - n2.x;
                else{
                    return n2.y - n1.y;
                }
            }
        });

        // 트리를 만든다.
        Node root = node[0];
        for (int i = 1; i < node.length; i++) {
            insertNode(root, node[i]);
        }
        result = new int[2][nodeInfo.length];
        idx = 0;
        preorder(root); // 전위 순회
        idx =0;
        postorder(root); // 후위 순회
        return result;
    }

    public void insertNode(Node parent, Node child){
        if(parent.x > child.x){
            // 부모의 x 값이 자식의 x 값보다 크다면 왼쪽 서브트리로 삽입
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child); // 왼쪽 서브트리로 재귀 호출
        }else{
            // 부모의 x 값이 자식의 x 값도 크지 않다면 오른쪽 서브트리로 삽입
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child); // 오른쪽 서브트리로 재귀 호출
        }
    }
    public void  preorder(Node root){
        if(root != null){
            result[0][idx++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            result[1][idx++] = root.value;
        }
    }

    public static void main(String[] args) {
        카카오문제 T = new 카카오문제();
        int[][] nodeInfo = {
                {5,3},{11,5},{13,3}, {3,5}, {6,1},
                {1,3}, {8,6}, {7,2}, {2,2}
        };
        int[][] resultArrays = T.solution(nodeInfo);
        // solution 메소드 호출
        System.out.println(Arrays.deepToString(resultArrays));
    }
    public class Node{
        int x;
        int y;
        int value;
        Node left;
        Node right;

        public Node(int x, int y, int value, Node left, Node right){
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right= right;
        }
    }
}
import java.util.Stack;

public class Study2 {
    public static void main(String[] args) {
        System.out.println(test("]](){{"));
    }
    static int test(String str){
        Stack<Character> stack = new Stack<>();
        int value =0;
        char[] a = str.toCharArray(); // 스트링을 문자로 쪼개는거
        for(char c: a){
            System.out.println("c : " + c);
            if(c == '(' || c== '{' || c=='[') {
                stack.push(c);
            }else{
                if(stack.isEmpty()) { // stack에서 비어 있는지 먼저 확인한 후에 pop() 메소드를 호출하여야 한다. 그렇지 않으면 EmptyStackException 예외 발생
                    continue;
                }
                System.out.println("stack : " + stack);
                char top = stack.peek(); // 지금 스택안에 있는 거 복사 "(" 그래서 아래 if문에 비교
                System.out.println("top : " +top);
                if((c == ')' && top == '(') || (c == ']' && top == '[') ||(c == '}' && top == '{')){
                    stack.pop();
                    value++;
                }else {
                    continue;
                }
            }
        }

        return value;
    }
}
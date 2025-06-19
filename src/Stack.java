class Stack {
    public static String solution(String compressed){
        java.util.Stack<String> stringStack = new java.util.Stack<>();
        java.util.Stack<Integer> intStack = new java.util.Stack<>();

        StringBuilder result = new StringBuilder();
        int num = 0;

        // "3(hi)"
        // "2(3(hi)co)"
        for (char c : compressed.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + (c-'0');
            } else if (c == '(') {
                stringStack.push(result.toString());
                intStack.push(num);
                result.setLength(0);
                num = 0;
            }else if (c == ')') {
                int repeatCount = intStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());
                for (int i = 0; i < repeatCount; i++) {
                    temp.append(result);
                }
                result = temp;
            }else{
                result.append(c);
            }
        }
        return  result.toString();

    }

    public static void main(String[] args) {
        String compressed = "2(3(hi)co)";
        System.out.println(solution(compressed));
    }
}

// hihihi "3(hi)"
// hihihicohihihico "2(3(hi)co)"

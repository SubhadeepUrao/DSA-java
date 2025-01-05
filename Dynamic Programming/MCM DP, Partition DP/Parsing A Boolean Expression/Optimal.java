import java.util.Stack;

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> operator = new Stack<>();
        Stack<Character> operand = new Stack<>();

        for(char ch : expression.toCharArray()) {
            if(ch == '|' || ch == '&' || ch =='!')
                operator.push(ch);
            else if(ch == '(' || ch == 'f' || ch == 't')
                operand.push(ch);
            else if(ch == ')') {
                char op = operator.pop();
                boolean res = operand.pop() == 't';
                while(operand.peek() != '(') {
                    switch (op) {
                        case '|':
                            res |= operand.pop() == 't';
                            break;
                        case '&':
                            res &= operand.pop() == 't';
                    }
                }
                if(op == '!') res = !res;
                operand.pop();
                operand.push(res ? 't' : 'f');
            }
        }
        return operand.pop() == 't';
    }
}
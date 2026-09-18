package Programmers.q67527;

// 수식 최대화

import java.util.*;

class Solution {
    String[][] oporder = {{"+","-","*"},
                         {"+","*","-"},
                         {"-","+","*"},
                         {"-","*","+"},
                         {"*","+","-"},
                         {"*","-","+"}};
    
    public long solution(String expression) {
        long answer = 0;
        String numberstr = "";
        List<String> parsed = new ArrayList<>();
        for(int i=0;i<expression.length();i++) {
            char c = expression.charAt(i);
            if(c=='+' || c=='-' || c=='*') {
                parsed.add(numberstr);
                parsed.add(Character.toString(c));
                numberstr = "";
            } else {
                numberstr += Character.toString(c);
            }
        }
        parsed.add(numberstr); //마지막 숫자도 추가
        for(int i=0;i<oporder.length;i++) {
            Deque<String> dq = null;
            for(int j=0;j<oporder[i].length;j++) {
                if(dq == null) dq = makeDeque(parsed);
                dq = calculate(dq, oporder[i][j]);
            }
            long temp = Long.parseLong(dq.peekLast());
            if(temp < 0) temp *= -1;
            if(answer < temp) answer = temp;
        }
        return answer;
    }
    
    private Deque<String> calculate(Deque<String> parsed, String operator) {
        Deque<String> left = new ArrayDeque<>();
        Deque<String> right = parsed;
        while(!right.isEmpty()) {
            String op = right.peekFirst();
            right.removeFirst();
            if(!op.equals(operator)) {
                left.addLast(op);
            } else {
                Long operand1 = Long.parseLong(left.peekLast());
                Long operand2 = Long.parseLong(right.peekFirst());
                Long res = 0L;
                if(operator.equals("+")) res = operand1+operand2;
                else if(operator.equals("-")) res = operand1-operand2;
                else res = operand1*operand2;
                left.removeLast();
                right.removeFirst();
                left.addLast(Long.toString(res));
            }
        }
        return left;
    }
    
    private Deque<String> makeDeque(List<String> parsed) {
        Deque<String> dq = new ArrayDeque<>();
        for(String str : parsed) {
            dq.addLast(str);
        }
        return dq;
    }
}
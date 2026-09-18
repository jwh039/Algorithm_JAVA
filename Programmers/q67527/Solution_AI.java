package Programmers.q67527;

// 수식 최대화

import java.util.ArrayList;
import java.util.List;

class Solution_AI {
    // 가능한 연산자 우선순위 조합 6가지
    private static final String[][] PRIORITIES = {
        {"+", "-", "*"},
        {"+", "*", "-"},
        {"-", "+", "*"},
        {"-", "*", "+"},
        {"*", "+", "-"},
        {"*", "-", "+"}
    };

    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        // 1. 숫자와 연산자 분리
        StringBuilder numStr = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                numStr.append(c);
            } else {
                numbers.add(Long.parseLong(numStr.toString()));
                operators.add(String.valueOf(c));
                numStr.setLength(0); // StringBuilder 초기화
            }
        }
        numbers.add(Long.parseLong(numStr.toString())); // 마지막 숫자 추가

        long maxResult = 0;

        // 2. 6가지 연산자 우선순위 조합을 순회하며 계산
        for (String[] priority : PRIORITIES) {
            // 원본 데이터 보존을 위한 복사
            List<Long> tempNums = new ArrayList<>(numbers);
            List<String> tempOps = new ArrayList<>(operators);

            for (String currentOp : priority) {
                for (int i = 0; i < tempOps.size(); ) {
                    if (tempOps.get(i).equals(currentOp)) {
                        // 현재 연산자에 해당하는 두 숫자 계산
                        long res = calculate(tempNums.get(i), tempNums.get(i + 1), currentOp);
                        
                        // 계산 결과로 숫자 리스트 갱신 및 연산자 제거
                        tempNums.set(i, res);
                        tempNums.remove(i + 1);
                        tempOps.remove(i);
                    } else {
                        i++;
                    }
                }
            }

            // 3. 절댓값 비교 후 최댓값 갱신
            long result = Math.abs(tempNums.get(0));
            if (result > maxResult) {
                maxResult = result;
            }
        }

        return maxResult;
    }

    // 두 수와 연산자를 받아 계산해 주는 메서드
    private long calculate(long a, long b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            default: return 0;
        }
    }
}

package Programmers.q148653;

// 마법의 엘리베이터

class Solution_AI {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int remainder = storey % 10;
            int nextDigit = (storey / 10) % 10;

            if (remainder > 5) {
                // 올림 처리
                answer += (10 - remainder);
                storey += (10 - remainder);
            } else if (remainder < 5) {
                // 내림 처리
                answer += remainder;
            } else { // remainder == 5
                // 다음 자릿수가 5 이상이면 올림, 5 미만이면 내림
                if (nextDigit >= 5) {
                    answer += 5;
                    storey += 5;
                } else {
                    answer += 5;
                }
            }

            // 다음 자릿수로 이동
            storey /= 10;
        }

        return answer;
    }
}

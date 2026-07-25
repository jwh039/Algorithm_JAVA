package Programmers.q152996;

// 시소 짝꿍

import java.util.Arrays;

class Solution_AI {
    public long solution(int[] weights) {
        long answer = 0;
        // 몸무게 카운트 배열 (100 ~ 1000)
        long[] count = new long[1001];

        for (int w : weights) {
            count[w]++;
        }

        for (int i = 100; i <= 1000; i++) {
            if (count[i] == 0) continue;

            // 1. 같은 몸무게끼리 짝꿍 만드는 경우 nC2 = n * (n - 1) / 2
            answer += count[i] * (count[i] - 1) / 2;

            // 2. 2:3 비율 (i * 3/2)
            if (i % 2 == 0 && i * 3 / 2 <= 1000) {
                answer += count[i] * count[i * 3 / 2];
            }

            // 3. 1:2 비율 (i * 2)
            if (i * 2 <= 1000) {
                answer += count[i] * count[i * 2];
            }

            // 4. 3:4 비율 (i * 4/3)
            if (i % 3 == 0 && i * 4 / 3 <= 1000) {
                answer += count[i] * count[i * 4 / 3];
            }
        }

        return answer;
    }
}

package Programmers.q178870;

// 연속된 부분 수열의 합

// Prefix Sum + Binary Search 활용 코드 (O(NlogN))

import java.util.Arrays;

class Solution_AI {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        
        // 1. 누적 합 배열 생성 (크기: n + 1)
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + sequence[i];
        }

        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        // 2. 시작 인덱스 i를 0부터 n-1까지 순회하며 이분 탐색
        for (int i = 0; i < n; i++) {
            long target = prefixSum[i] + k; // 찾고자 하는 누적합 값

            // Arrays.binarySearch를 이용한 이분 탐색 (O(log N))
            int idx = Arrays.binarySearch(prefixSum, i + 1, n + 1, target);

            // target 값을 찾은 경우 (idx >= 0)
            if (idx >= 0) {
                int start = i;
                int end = idx - 1; // 누적 합 인덱스 offset 조절
                int currentLen = end - start;

                // 더 짧은 길이를 찾은 경우에만 업데이트 (길이가 같으면 앞쪽 인덱스 유지)
                if (currentLen < minLen) {
                    minLen = currentLen;
                    answer[0] = start;
                    answer[1] = end;
                }
            }
        }

        return answer;
    }
}

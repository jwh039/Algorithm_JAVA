package Programmers.q178870;

// 연속된 부분 수열의 합

// 내 답안과 동일 알고리즘: AI 리팩토링

class Solution_Refactor_AI {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        // right 포인터를 0부터 sequence 끝까지 이동
        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            // sum이 k보다 크거나 같으면 left 포인터를 오른쪽으로 당김
            while (sum >= k) {
                if (sum == k) {
                    int currentLen = right - left;
                    // 더 짧은 구간을 발견한 경우에만 업데이트 (길이가 같으면 앞쪽 인덱스 유지)
                    if (currentLen < minLen) {
                        minLen = currentLen;
                        answer[0] = left;
                        answer[1] = right;
                    }
                }
                sum -= sequence[left];
                left++;
            }
        }

        return answer;
    }
}
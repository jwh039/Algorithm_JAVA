package Programmers.q178870;

// 연속된 부분 수열의 합

class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0; int end = 0; int sum = sequence[0];
        int answer_start = -1; int answer_end = -1;
        while(true) {
            if(sum < k) {
                end++;
                if(end >= sequence.length) break;
                sum += sequence[end];
            } else if(sum == k) {
                if(answer_start == -1 || answer_end-answer_start > end-start) {
                    answer_start = start;
                    answer_end = end;
                }
                // 어차피 앞에서부터 탐색: 빼도 되는 조건
                /* 
                else if(answer_end-answer_start == end-start && answer_start > start) {
                    answer_start = start;
                    answer_end = end;
                }
                */
                start++;
                if(start > end) break;
                sum -= sequence[start-1];
            } else if(sum > k) {
                start++;
                if(start > end) break;
                sum -= sequence[start-1];
            }
        }
        int[] answer = new int[]{answer_start,answer_end};
        return answer;
    }
}
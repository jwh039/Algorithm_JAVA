package Programmers.q140107;

// 점 찍기

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dl = (long)d;
        for(long x=0;x<=dl;x+=k) {
            long y_2 = dl*dl-x*x;
            double y = Math.sqrt(y_2);
            int y_floor = (int)Math.floor(y);
            int count = y_floor/k + 1;
            answer += (long)count;
        }
        return answer;
    }
}

package Programmers.q77885;

// 2개 이하로 다른 비트

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<answer.length;i++) {
            answer[i] = f(numbers[i]);
        }
        return answer;
    }
    
    private long f(long x) {
        if(x%4 != 3) return x+1;
        for(int bit=1;bit<63;bit++) {
            if(((x & (1L<<bit)) != 0) && ((x & (1L<<(bit+1))) == 0)) {
                return x+(1L<<bit);
            }
        }
        return -1;
    }
}
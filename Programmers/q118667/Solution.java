package Programmers.q118667;

// 두 큐 합 같게 만들기

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int ptr1 = 0;
        int ptr2 = queue1.length-1;
        long sum = 0;
        long current_sum = 0;
        int[] queue = new int[queue1.length+queue2.length];
        
        for(int i=0;i<queue1.length;i++) {
            queue[i] = queue1[i];
            sum += (long)queue1[i]; 
        }
        current_sum = sum;
        
        for(int i=0;i<queue2.length;i++) {
            queue[i+queue1.length] = queue2[i];
            sum += (long)queue2[i];
        }
        
        if(sum%2 == 1) return -1;
        
        boolean check1 = false;
        boolean check2 = false;
        do {
            if(current_sum*2 == sum) return answer;
            else if(current_sum*2 < sum) {
                ptr2++;
                if(ptr2 >= queue.length) ptr2 = 0;
                current_sum += (long)queue[ptr2];
                answer++;
                if(ptr2 == queue1.length-1) check2 = true;
            } else {
                current_sum -= (long)queue[ptr1];
                ptr1++;
                if(ptr1 >= queue.length) ptr1 = 0;
                answer++;
                if(ptr1 == 0) check1 = true;
            }
        } while(!check1 || !check2);
        
        return -1;
    }
}
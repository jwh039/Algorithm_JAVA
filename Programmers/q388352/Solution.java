package Programmers.q388352;

// 비밀 코드 해독

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int[] comb = {1,2,3,4,5};
        int answer = 0;
        
        while(true) {
            boolean found = true;
            // comb 확인
            for(int i=0;i<q.length;i++) {
                if(intersection(q[i], comb) != ans[i]) {
                    found = false;
                    break;
                }
            }
            if(found) answer++;
            next_combination(n, comb);
            if(comb[0] == -1) break;
        }
        
        
        return answer;
    }
    
    private void next_combination(int n, int[] arr) {
        // arr의 길이는 반드시 5
        for(int i=4;i>=0;i--) {
            if(arr[i] != n-4+i) {
                arr[i]++;
                for(int j=i+1;j<5;j++) {
                    arr[j] = arr[i]+j-i;
                }
                return;
            }
        }
        arr[0] = -1;
    }
    
    private int intersection(final int[] q, final int[] ans) {
        // 두 배열 다 정렬된 상태임을 가정
        int i=0; int j=0;
        int answer = 0;
        while(true) {
            if(i>=5 || j>=5) return answer;
            if(q[i] == ans[j]) {
                i++; j++; answer++;
            } else if(q[i] > ans[j]) {
                j++;
            } else {
                i++;
            }
        }
    }
}
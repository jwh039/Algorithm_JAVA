package Programmers.q92342;

// 양궁대회

class Solution {
    int[] answer = new int[]{-1};
    int diff = -1;
    
    public int[] solution(int n, int[] info) {
        int apeach = 0; // 어피치의 현재 점수
        for(int i=0;i<info.length;i++) {
            if(info[i] > 0) apeach += (10-i);
        }
        recur(info, apeach, 0, 0, new int[]{0,0,0,0,0,0,0,0,0,0,0}, n);
        return answer;
    }
    
    private void recur(int[] info, int apeach, int lion, int current, int[] info_lion, int arrows) {
        if(arrows < 0) return;
        if(current > 10) {
            if(apeach < lion) {
                info_lion[10] += arrows;
                if(answer.length == 1) {
                    answer = info_lion;
                    diff = lion - apeach;
                } else {
                    if(lion-apeach > diff) {
                        answer = info_lion;
                        diff = lion - apeach;
                    } else if(lion-apeach == diff) {
                        if(compare(info_lion, answer)) {
                            answer = info_lion;
                            diff = lion - apeach;
                        }
                    }
                }
            }
            return;
        }
        int infoIndex = 10 - current;
        int[] copy1 = info_lion.clone();
        copy1[infoIndex] = info[infoIndex]+1;
        int temp = (info[infoIndex]==0)? apeach : apeach-current;
        recur(info, temp, lion+current, current+1, copy1, arrows-copy1[infoIndex]);
        int[] copy2 = info_lion.clone();
        recur(info, apeach, lion, current+1, copy2, arrows);
    }
    
    private boolean compare(int[] a, int[] b) {
        int i = a.length-1;
        while(i>=0) {
            if(a[i] > b[i]) return true;
            else if(a[i] < b[i]) return false;
            i--;
        }
        return false;
    }
}
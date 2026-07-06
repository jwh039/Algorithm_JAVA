package Programmers.q389479;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[] servers = new int[24];
        for(int i=0;i<24;i++) servers[i] = 0;
        int count = 0; // 서버 증설 횟수 카운터
        for(int i=0;i<24;i++) {
            int server_required = players[i]/m;
            if(server_required > servers[i]) {
                int server_added = server_required - servers[i];
                count += server_added;
                for(int j=i;j<i+k;j++) {
                    if(j >= 24) break;
                    servers[j] += server_added;
                }
            }
        }
        return count;
    }
}
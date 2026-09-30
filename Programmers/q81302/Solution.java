package Programmers.q81302;

// 거리두기 확인하기

import java.util.*;

class Solution {
    int[] dx = {-1,0,0,1};
    int[] dy = {0,-1,1,0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0;i<5;i++) answer[i] = check(places[i]);
        return answer;
    }
    
    private int check(String[] places) {
        for(int i=0;i<places.length;i++) {
            for(int j=0;j<places[0].length();j++) {
                if(places[i].charAt(j) == 'P') {
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i,j,0});
                    while(!queue.isEmpty()) {
                        int[] current = queue.poll();
                        for(int k=0;k<4;k++) {
                            int nx = current[0]+dx[k];
                            int ny = current[1]+dy[k];
                            if(nx<0 || ny<0 || nx>=5 || ny>=5) continue;
                            if(nx==i && ny==j) continue;
                            if(places[nx].charAt(ny) == 'X') continue;
                            if(places[nx].charAt(ny) == 'P') return 0;
                            if(current[2] == 0) {
                                queue.add(new int[]{nx,ny,current[2]+1});
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
}

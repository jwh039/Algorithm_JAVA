package Programmers.q148653;

// 마법의 엘리베이터

import java.util.*;

class Solution {
    public int[] dx = {-1,1,-10,10,-100,100,-1000,1000,-10000,10000,-100000,100000,-1000000,1000000,-10000000,10000000,-100000000};
    public int solution(int storey) {
        boolean[] visited = new boolean[100000001];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{storey, 0});
        visited[storey] = true;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int i=0;i<dx.length;i++) {
                int next = current[0]+dx[i];
                if(next < 0 || next>100000000) continue;
                if(visited[next]) continue;
                if(next == 0) return current[1]+1;
                queue.add(new int[]{next, current[1]+1});
                visited[next] = true;
            }
        }
        return -1;
    }
}

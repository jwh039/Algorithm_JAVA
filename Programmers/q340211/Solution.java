package Programmers.q340211;

// 충돌위험 찾기

import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        final int robots = routes.length;
        final int m = routes[0].length;
        int answer = 0;
        int[] completed = new int[robots];
        int[][] currentPoint = new int[robots][2];
        for(int i=0;i<robots;i++) {
            currentPoint[i][0] = points[routes[i][0]-1][0];
            currentPoint[i][1] = points[routes[i][0]-1][1];
        }
        answer += findCollision(currentPoint);
        
        while(true) {
            boolean moved = false;
            for(int i=0;i<robots;i++) {
                if(completed[i] >= m-1) continue;
                // 이동
                int[] dest = points[routes[i][completed[i]+1]-1];
                if(currentPoint[i][0] > dest[0]) currentPoint[i][0]--;
                else if(currentPoint[i][0] < dest[0]) currentPoint[i][0]++;
                else {
                    if(currentPoint[i][1] > dest[1]) currentPoint[i][1]--;
                    else if(currentPoint[i][1] < dest[1]) currentPoint[i][1]++;
                }
                // 도착 확인
                if(currentPoint[i][0]==dest[0] && currentPoint[i][1]==dest[1]) {
                    completed[i]++;
                }
                moved = true;
            }
            if(!moved) break;
            answer += findCollision(currentPoint);
            for(int i=0;i<robots;i++) {
                if(completed[i] >= m-1) currentPoint[i][0] = -1;
            }
        }
        
        return answer;
    }
    
    private int findCollision(final int[][] currentPoint) {
        int[][] cp_cloned = currentPoint.clone();
        Arrays.sort(cp_cloned, (p1, p2) -> {
            if(p1[0]==p2[0]) return p1[1]-p2[1];
            return p1[0]-p2[0];
        });
        boolean collision = false;
        int count = 0;
        int[] prevPoint = cp_cloned[0];
        for(int i=0;i<cp_cloned.length;i++) {
            if(cp_cloned[i][0] == -1) continue;
            if(i>0) {
                if(cp_cloned[i][0]==prevPoint[0] && cp_cloned[i][1]==prevPoint[1]) {
                    if(!collision) {
                        collision = true;
                        count++;
                    }
                    continue;
                }
            }
            collision = false;
            prevPoint = cp_cloned[i];
        }
        return count;
    }
}

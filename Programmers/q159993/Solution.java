package Programmers.q159993;

// 미로 탈출

import java.util.*;

class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int solution(String[] maps) {
        int sx=-1; int sy=-1; int lx=-1; int ly=-1; int ex=-1; int ey=-1;
        final int N = maps.length; final int M = maps[0].length();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(maps[i].charAt(j)=='S') {
                    sx = i;
                    sy = j;
                } else if(maps[i].charAt(j)=='L') {
                    lx = i;
                    ly = j;
                } else if(maps[i].charAt(j)=='E') {
                    ex = i;
                    ey = i; // 오타인데 정답; ey를 사용을 안함
                }
            }
        }
        // 시작점 -> 레버
        Queue<int[]> qu = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        qu.add(new int[]{sx,sy,0});
        visited[sx][sy] = true;
        boolean lFound = false;
        while(!qu.isEmpty()) {
            int[] currentPoint = qu.poll();
            if(maps[currentPoint[0]].charAt(currentPoint[1]) == 'L') {
                lFound = true;
                while(!qu.isEmpty()) qu.poll();
                qu.add(currentPoint);
                break;
            }
            for(int i=0;i<4;i++) {
                int nx = currentPoint[0]+dx[i];
                int ny = currentPoint[1]+dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                switch(maps[nx].charAt(ny)) {
                    case 'S':
                    case 'E':
                    case 'O':
                    case 'L':
                        if(!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            qu.add(new int[]{nx,ny,currentPoint[2]+1});
                    }
                }
            }
        }
        if(!lFound) return -1;
        
        // 레버 -> 출구
        for(int i=0;i<N;i++) Arrays.fill(visited[i], false);
        boolean eFound = false;
        while(!qu.isEmpty()) {
            int[] currentPoint = qu.poll();
            if(maps[currentPoint[0]].charAt(currentPoint[1]) == 'E') {
                eFound = true;
                return currentPoint[2];
            }
            for(int i=0;i<4;i++) {
                int nx = currentPoint[0]+dx[i];
                int ny = currentPoint[1]+dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                switch(maps[nx].charAt(ny)) {
                    case 'S':
                    case 'E':
                    case 'O':
                    case 'L':
                        if(!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            qu.add(new int[]{nx,ny,currentPoint[2]+1});
                    }
                }
            }
        }
        
        return -1;
    }
}

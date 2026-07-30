package Programmers.q159993;

// 미로 탈출

import java.util.*;

class Solution_Refactor {
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
                    ey = j; // 수정...(AI)
                }
            }
        }
        int s2l = bfs(maps, sx, sy, lx, ly, N, M);
        if(s2l == -1) return -1;
        int l2e = bfs(maps, lx, ly, ex, ey, N, M);
        if(l2e == -1) return -1;
        return s2l+l2e;
    }
    
    int bfs(String[] maps, int sx, int sy, int ex, int ey, final int N, final int M) {
        Queue<int[]> qu = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        qu.add(new int[]{sx,sy,0});
        visited[sx][sy] = true;
        while(!qu.isEmpty()) {
            int[] currentPoint = qu.poll();
            if(currentPoint[0] == ex && currentPoint[1] == ey) {
                return currentPoint[2];
            }
            for(int i=0;i<4;i++) {
                int nx = currentPoint[0] + dx[i];
                int ny = currentPoint[1] + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                switch(maps[nx].charAt(ny)) {
                    case 'S':
                    case 'E':
                    case 'O':
                    case 'L':
                        if(!visited[nx][ny]) {
                            qu.add(new int[]{nx,ny,currentPoint[2]+1});
                            visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}

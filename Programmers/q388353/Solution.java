package Programmers.q388353;

// 지게차와 크레인

import java.util.*;

class Solution {
    int[] dx = {-1,0,0,1};
    int[] dy = {0,-1,1,0};
    char[][] storageBoard;
    int n;
    int m;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        storageBoard = new char[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) storageBoard[i][j] = storage[i].charAt(j);
        }
        for(int i=0;i<requests.length;i++) {
            char container = requests[i].charAt(0);
            if(requests[i].length() == 1) {
                processAccessible(container);
            } else {
                processAll(container);
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(storageBoard[i][j] != '.') answer++;
            }
        }
        return answer;
    }
    
    private void processAccessible(char container) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> search = new ArrayDeque<>();
        Stack<int[]> target = new Stack<>();
        for(int i=0;i<n;i++) {
            search.add(new int[]{i,0});
            search.add(new int[]{i,m-1});
            visited[i][0] = true;
            visited[i][m-1] = true;
        }
        for(int j=1;j<m-1;j++) {
            search.add(new int[]{0,j});
            search.add(new int[]{n-1,j});
            visited[0][j] = true;
            visited[n-1][j] = true;
        }
        while(!search.isEmpty()) {
            int[] current = search.poll();
            if(storageBoard[current[0]][current[1]] == container) {
                target.add(current);
            } else if(storageBoard[current[0]][current[1]] == '.') {
                for(int i=0;i<4;i++) {
                    int nx = current[0]+dx[i];
                    int ny = current[1]+dy[i];
                    if(nx<0 || ny<0|| nx>=n || ny>=m) continue;
                    if(visited[nx][ny]) continue;
                    search.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
        while(!target.isEmpty()) {
            int[] current = target.pop();
            storageBoard[current[0]][current[1]] = '.';
        }
    }
    
    private void processAll(char container) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(storageBoard[i][j] == container) {
                    storageBoard[i][j] = '.';
                }
            }
        }
    }
}
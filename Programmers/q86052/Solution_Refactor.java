package Programmers.q86052;

import java.util.*;

// 빛의 경로 사이클

class Solution_Refactor {
    final int UP = 0;
    final int RIGHT = 1;
    final int DOWN = 2;
    final int LEFT = 3;
    int ROWS;
    int COLUMNS;
    boolean[][][] visited;
    
    public int[] solution(String[] grid) {
        ROWS = grid.length;
        COLUMNS = grid[0].length();
        visited = new boolean[ROWS][COLUMNS][4];
        List<Integer> answerList = new ArrayList<>();
        for(int i=0;i<ROWS;i++) {
            for(int j=0;j<COLUMNS;j++) {
                for(int k=0;k<4;k++) {
                    if(visited[i][j][k]) continue;
                    answerList.add(traversal(i,j,k,grid));
                }
            }
        }
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
    
    private int traversal(int i, int j, int k, String[] grid) {
        int result = 1;
        visited[i][j][k] = true;
        int currentI = i;
        int currentJ = j;
        int currentK = k;
        while(true) {
            int[] nextinfo = next(currentI,currentJ,currentK,grid);
            int nextr = nextinfo[0];
            int nextc = nextinfo[1];
            int nextdir = nextinfo[2];
            if(visited[nextr][nextc][nextdir]) break;
            visited[nextr][nextc][nextdir] = true;
            result++;
            currentI = nextr;
            currentJ = nextc;
            currentK = nextdir;
        }
        return result;
    }
    
    private int[] next(int i, int j, int k, String[] grid) {
        int dir = k;
        int nextr = i;
        int nextc = j;
        if(grid[i].charAt(j) == 'L') {
            dir = (dir+1)%4;
        } else if(grid[i].charAt(j) == 'R'){
            dir = (dir+3)%4;
        }
        switch(dir) {
            case UP:
                nextr--;
                if(nextr < 0) nextr = ROWS-1;
                break;
            case RIGHT:
                nextc++;
                if(nextc >= COLUMNS) nextc = 0;
                break;
            case DOWN:
                nextr++;
                if(nextr >= ROWS) nextr = 0;
                break;
            case LEFT:
                nextc--;
                if(nextc < 0) nextc = COLUMNS-1;
                break;
        }
        return new int[]{nextr, nextc, dir};
    }
}
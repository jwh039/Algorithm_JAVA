package Programmers.q169199;

// 리코쳇 로봇

import java.util.*;

class Solution {
    final int UP_DOWN = 0; final int LEFT_RIGHT = 1;
    int[][] memo;
    Queue<int[]> qu;
    
    public int solution(String[] board) {
        int rx = -1; int ry = -1; int gx = -1; int gy = -1;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length();j++) {
                if(board[i].charAt(j) == 'G') {
                    gx = i; gy = j;
                } else if(board[i].charAt(j) == 'R') {
                    rx = i; ry = j;
                }
                if(gx != -1 && rx != -1) break;
            }
        }
        memo = new int[board.length][board[0].length()];
        for(int i=0;i<memo.length;i++) {
            Arrays.fill(memo[i],-1);
        }
        qu = new ArrayDeque<>();
        memo[rx][ry] = 0;
        qu.add(new int[]{rx,ry,UP_DOWN});
        qu.add(new int[]{rx,ry,LEFT_RIGHT});
        while(!qu.isEmpty()) {
            int[] info = qu.poll();
            if(info[0] == gx && info[1] == gy) break;
            go(board, info);
        }
        
        return memo[gx][gy];
    }
    private void go(String[] board, int[] info) {
        int x = info[0]; int y = info[1];
        if(info[2] == UP_DOWN) {
            while(true) {
                if(x-1<0) break;
                if(board[x-1].charAt(y) == 'D') break;
                x--;
            }
            if(x != info[0]) {
                if(memo[x][y] == -1 || memo[x][y] > memo[info[0]][info[1]]+1) {
                    memo[x][y] = memo[info[0]][info[1]]+1;
                    qu.add(new int[]{x,y,LEFT_RIGHT});
                }
            }
            x = info[0]; y = info[1];
            while(true) {
                if(x+1>=board.length) break;
                if(board[x+1].charAt(y) == 'D') break;
                x++;
            }
            if(x != info[0]) {
                if(memo[x][y] == -1 || memo[x][y] > memo[info[0]][info[1]]+1) {
                    memo[x][y] = memo[info[0]][info[1]]+1;
                    qu.add(new int[]{x,y,LEFT_RIGHT});
                }
            }
            x = info[0]; y = info[1];
        } else if(info[2] == LEFT_RIGHT) {
            while(true) {
                if(y-1<0) break;
                if(board[x].charAt(y-1) == 'D') break;
                y--;
            }
            if(y != info[1]) {
                if(memo[x][y] == -1 || memo[x][y] > memo[info[0]][info[1]]+1) {
                    memo[x][y] = memo[info[0]][info[1]]+1;
                    qu.add(new int[]{x,y,UP_DOWN});
                }
            }
            x = info[0]; y = info[1];
            while(true) {
                if(y+1>=board[0].length()) break;
                if(board[x].charAt(y+1) == 'D') break;
                y++;
            }
            if(y != info[1]) {
                if(memo[x][y] == -1 || memo[x][y] > memo[info[0]][info[1]]+1) {
                    memo[x][y] = memo[info[0]][info[1]]+1;
                    qu.add(new int[]{x,y,UP_DOWN});
                }
            }
            x = info[0]; y = info[1];
        }
    }
}

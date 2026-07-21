package Programmers.q154540;

import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++) {
            for(int j=0;j<maps[0].length();j++) {
                visited[i][j] = false;
            }
        }
        Stack<Pair> st = new Stack<>();
        int dx[] = {-1,0,0,1};
        int dy[] = {0,-1,1,0};
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<maps.length;i++) {
            for(int j=0;j<maps[0].length();j++) {
                char ch = maps[i].charAt(j);
                int days = 0;
                if(charToInt(ch) > 0) {
                    if(visited[i][j] == false) {
                        visited[i][j] = true;
                        st.push(new Pair(i,j));
                    }
                }
                while(!st.isEmpty()) {
                    Pair p = st.pop();
                    int x = p.x;
                    int y = p.y;
                    days += charToInt(maps[x].charAt(y));
                    for(int k=0;k<4;k++) {
                        int nx = x+dx[k];
                        int ny = y+dy[k];
                        if(nx<0 || ny<0) continue;
                        if(nx>=maps.length || ny>=maps[0].length()) continue;
                        if(visited[nx][ny]) continue;
                        if(charToInt(maps[nx].charAt(ny)) < 0) continue;
                        visited[nx][ny] = true;
                        st.push(new Pair(nx,ny));
                    }
                }
                if(days > 0) {
                    al.add(days);
                }
            }
        }
        int[] answer;
        if(al.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        } else {
            answer = new int[al.size()];
            for(int a=0;a<al.size();a++) {
                answer[a] = al.get(a);
            }
            Arrays.sort(answer);
        }
        return answer;
    }
    
    private static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private int charToInt(char c) {
        if(c >= '1' && c<='9') return (int)c - (int)'0';
        else return -1;
    }
}
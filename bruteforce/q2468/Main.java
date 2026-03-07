package Bruteforce.q2468;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Stack;

public class Main {
    static int[][] region;
    public static void main(String[] args) throws IOException {
        int safeArea = 1;
        int hMax = 1, hMin = 100;
        //System.setIn(new FileInputStream("firstRepo/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        region = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
                if(hMax < region[i][j]) hMax = region[i][j];
                if(hMin > region[i][j]) hMin = region[i][j];
            }
        }
        for(int r=hMin;r<=hMax;r++) {
            int result = DFS(N,r);
            if(safeArea < result) safeArea = result;
        }
        System.out.println(safeArea);
    }

    public static int DFS(int size, int rain) {
        int safeArea = 0;
        boolean[][] visit_able = new boolean[size][size];
        int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(region[i][j] > rain) visit_able[i][j] = true;
                else visit_able[i][j] = false;
            }
        }
        Stack<Pair> stack = new Stack<>();
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(visit_able[i][j]) {
                    stack.push(new Pair(i,j));
                    while(!stack.empty()) {
                        Pair element = stack.pop();
                        int x = element.x, y = element.y;
                        visit_able[x][y] = false;
                        for(int k=0;k<4;k++) {
                            int nx = x + dx[k], ny = y + dy[k];
                            if(nx<0 || nx>=size || ny<0 || ny>=size) continue;
                            if(visit_able[nx][ny]) stack.push(new Pair(nx,ny));
                        }
                    }
                    safeArea++;
                }
            }
        }
        return safeArea;
    }

    public static class Pair {
        public int x;
        public int y;

        public Pair(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
}
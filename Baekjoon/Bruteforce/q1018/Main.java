package Baekjoon.Bruteforce.q1018;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //FileInputStream fis = new FileInputStream("firstRepo/input.txt");
        //System.setIn(fis);
        int answer = 100000;    // 쓰레기 값
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] board = new char[N][M]; 
        for(int i=0;i<N;i++) {
            String str = sc.next();
            for(int j=0;j<M;j++) board[i][j] = str.charAt(j);
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                int check = check(i,j,N,M,board);
                if(answer > check) answer = check;
            }
        }
        System.out.println(answer);
    }

    public static int check(int row, int col, int N, int M, char[][] board) {
        if(row < 0 || col < 0 || row+7>=N || col+7>=M) return 100000;   //검사하지 않겠다는 의미의 쓰레기 값
        int count = 0;
        for(int i=row;i<=row+7;i++) {
            for(int j=col;j<=col+7;j++) {
                char letter = ((i+j)%2 == 0) ? 'W' : 'B';
                if(board[i][j] != letter) count++; 
            }
        }
        return (count<=32)? count : 64-count; 
    }
}

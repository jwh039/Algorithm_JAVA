package SWEA.q1220;

// Magnetic

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int tb = sc.nextInt(); // 항상 100
            int[][] table = new int[tb][tb];
            for(int i=0;i<tb;i++) {
                for(int j=0;j<tb;j++) {
                    table[i][j] = sc.nextInt();
                }
            }
            int answer = 0;
            for(int col=0;col<tb;col++) {
                int state = 0;
                for(int row=0;row<tb;row++) {
                    if(table[row][col]==1) {
                        state = 1;
                    } else if(table[row][col]==2) {
                        if(state == 0) {
                            state = 2;
                        } else if(state == 1) {
                            state = 2;
                            answer++;
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}

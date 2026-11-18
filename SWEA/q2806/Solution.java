package SWEA.q2806;

// N-Queen

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int answer = 0;
            if(N==1) answer = 1;
            else if(N==2) answer = 0;
            else {
                int[] rows = new int[N];
                int[] diagonals1 = new int[2*N-1];
                int[] diagonals2 = new int[2*N-1];
                answer = go(0, N, rows, diagonals1, diagonals2);
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
    
    private static int go(int currentCol, int N, int[] rows, int[] diagonals1, int[] diagonals2) {
        if(currentCol >= N) return 1;
        int result = 0;
        for(int row=0;row<N;row++) {
            int dia1 = currentCol+row;
            int dia2 = currentCol-row+N-1;
            if(rows[row]>0) continue;
            if(diagonals1[dia1]>0) continue;
            if(diagonals2[dia2]>0) continue;
            rows[row]=1; diagonals1[dia1]=1; diagonals2[dia2]=1;
            result += go(currentCol+1, N, rows, diagonals1, diagonals2);
            rows[row]=0; diagonals1[dia1]=0; diagonals2[dia2]=0;
        }
        return result;
    }
}

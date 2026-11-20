package SWEA.q2817;

// 부분 수열의 합

import java.util.Scanner;

class Solution_AI
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0;i<N;i++) arr[i] = sc.nextInt();
            int[] dp = new int[1001];
            dp[0] = 1;
            for(int i=0;i<N;i++) {
                int num = arr[i];
                for(int j=1000;j>=num;j--) {
                    dp[j] += dp[j-num];
                }
            }
            System.out.println("#" + test_case + " " + dp[K]);
		}
	}
}

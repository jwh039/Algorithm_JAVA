package SWEA.q2817;

// 부분 수열의 합

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
            int K = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0;i<N;i++) arr[i] = sc.nextInt();
            System.out.println("#" + test_case + " " + go(0, N, 0, arr, K));
		}
	}
    
    private static int go(int currentIndex, int length, int currentSum, int[] arr, int K) {
        if(currentSum == K) return 1;
        if(currentSum > K) return 0;
        if(currentIndex >= length) return 0;
        int result = 0;
        result += go(currentIndex+1, length, currentSum+arr[currentIndex], arr, K);
        result += go(currentIndex+1, length, currentSum, arr, K);
        return result;
    }
}

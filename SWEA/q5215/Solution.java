package SWEA.q5215;

// 햄버거 다이어트

import java.util.Scanner;

class Solution
{
    static int answer = 0;
    static int cal_limit = 0;
    static int[][] info;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int L = sc.nextInt();
            info = new int[N][2];
            for(int i=0;i<N;i++) {
                info[i][0] = sc.nextInt();
                info[i][1] = sc.nextInt();
            }
            cal_limit = L;
            go(0, 0, 0, N);
            System.out.println("#" + test_case + " " + answer);
            answer = 0;
		}
	}
    
    private static void go(int score, int cal, int current, int len) {
        if(cal > cal_limit) return;
        if(current >= len) {
            if(answer < score) answer = score;
            return;
        }
        go(score+info[current][0], cal+info[current][1], current+1, len);
        go(score, cal, current+1, len);
    }
}

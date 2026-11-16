package SWEA.q1206;

// View

import java.util.Scanner;
//import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int[] buildings = new int[N];
            int answer = 0;
            for(int i=0;i<N;i++) buildings[i] = sc.nextInt();
            for(int i=0;i<N;i++) {
                if(buildings[i] == 0) continue;
                int compare = 0;
                if(buildings[i-2] > compare) compare = buildings[i-2];
                if(buildings[i-1] > compare) compare = buildings[i-1];
                if(buildings[i+1] > compare) compare = buildings[i+1];
                if(buildings[i+2] > compare) compare = buildings[i+2];
                answer += (buildings[i] >= compare)? (buildings[i]-compare) : 0;
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}

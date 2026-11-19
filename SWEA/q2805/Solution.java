package SWEA.q2805;

// 농작물 수확하기

import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int profit = 0;
			int N = Integer.parseInt(br.readLine());
            final int mid = N/2;
			for(int i=0;i<N;i++) {
				String line = br.readLine();
				for(int j=0;j<N;j++) {
					int crop = line.charAt(j) - '0';
					int diff1 = Math.max(mid-i,i-mid);
					int diff2 = Math.max(mid-j,j-mid);
					if(diff1+diff2 <= mid) profit += crop;
                }
			}
			System.out.println("#" + test_case + " " + profit);
		}
	}
}

package SWEA.q1208;

// Flatten

import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[] boxes = new int[100];
            int dumps = sc.nextInt();
            for(int i=0;i<100;i++) boxes[i] = sc.nextInt();
            Arrays.sort(boxes);
            for(int dump=0; dump<dumps; dump++) {
                if(boxes[0] == boxes[99]) continue;
                boxes[0]++;
                boxes[99]--;
                Arrays.sort(boxes);
            }
            System.out.println("#" + test_case + " " + (boxes[99]-boxes[0]));
		}
	}
}

package SWEA.q26389;

// 여행

import java.util.Scanner;
//import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String plan = sc.next();
            if(plan.indexOf("N") == -1 && plan.indexOf("S") != -1) System.out.println("No");
            else if(plan.indexOf("S") == -1 && plan.indexOf("N") != -1) System.out.println("No");
            else if(plan.indexOf("E") == -1 && plan.indexOf("W") != -1) System.out.println("No");
            else if(plan.indexOf("W") == -1 && plan.indexOf("E") != -1) System.out.println("No");
            else System.out.println("Yes");
		}
	}
}

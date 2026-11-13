package SWEA.q25695;

// 세 정수

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
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int Z = sc.nextInt();
			if(X == Y) {
                // B가 가장 큼
                if(X >= Z) {
                    System.out.println(Z + " " + X + " " + Z);
                } else {
                    System.out.println("-1 -1 -1");
                }
            } else if(X == Z) {
                // A가 가장 큼
                if(X >= Y) {
                    System.out.println(X + " " + Y + " " + Y);
                } else {
                    System.out.println("-1 -1 -1");
                }
            } else if(Y == Z) {
                // C가 가장 큼
                if(Y >= X) {
                    System.out.println(X + " " + X + " " + Y);
                } else {
                    System.out.println("-1 -1 -1");
                }
            } else {
                System.out.println("-1 -1 -1");
            }
		}
	}
}

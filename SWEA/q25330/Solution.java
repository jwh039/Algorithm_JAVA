package SWEA.q25330;

// 거리 문자열

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
			String S = sc.next();
            boolean result = true;
            for(char c='0'; c <= '9'; c++) {
                if(!result) break;
                int firstIndex = -1;
                int secondIndex = -1;
                for(int i=0;i<S.length();i++) {
                    if(S.charAt(i) == c) {
                        if(firstIndex == -1) firstIndex = i;
                        else if(secondIndex == -1) secondIndex = i;
                        else {
                            result = false;
                            break;
                        }
                    }
                }  
                if(secondIndex == -1 && firstIndex != -1) result = false;
                if(secondIndex != -1 && firstIndex != -1) {
                    if(secondIndex - firstIndex != (c-'0'+1)) result = false;
                }
            }
            if(result) System.out.println("yes");
            else System.out.println("no");
		}
	}
}

package SWEA.q26837;

// DNA 수열

import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            int[] As = new int[N];
            int[] Ts = new int[N];
            int[] Cs = new int[N];
            int[] Gs = new int[N];
            for(int i=0;i<N;i++) {
                if(i>0) {
                    As[i] = As[i-1];
                    Ts[i] = Ts[i-1];
                    Cs[i] = Cs[i-1];
                    Gs[i] = Gs[i-1];
                }
                if(S.charAt(i) == 'A') {
                    As[i]++;
                } else if(S.charAt(i) == 'T') {
                    Ts[i]++;
                } else if(S.charAt(i) == 'C') {
                    Cs[i]++;
                } else { // S.charAt(i) == 'G'
                    Gs[i]++;
                }
            }
            for(int i=0;i<N;i++) {
                for(int j=i;j<N;j++) {
                    int aCount = (i>0)? As[j]-As[i-1] : As[j];
                    int tCount = (i>0)? Ts[j]-Ts[i-1] : Ts[j];
                    int cCount = (i>0)? Cs[j]-Cs[i-1] : Cs[j];
                    int gCount = (i>0)? Gs[j]-Gs[i-1] : Gs[j];
                    if(aCount == tCount && cCount == gCount) answer++;
                }
            }
            System.out.println(answer);
		}
	}
}

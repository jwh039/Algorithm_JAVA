package Algorithm_JAVA.PrefixSum.q11659;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        StringTokenizer st = new StringTokenizer(firstLine);
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) nums[i] = Integer.parseInt(st.nextToken());
        // nums 배열에 대한 누적 합
        int[] sum = new int[N];
        sum[0] = nums[0];
        for(int i=1;i<N;i++) sum[i] = sum[i-1] + nums[i];
        for(int l=0;l<M;l++) {
            // M개의 줄에 대한 입력을 처리
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int result = (i==1)? sum[j-1] : sum[j-1] - sum[i-2];
            sb.append(result).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
    }
}

package Mathematics.q9613;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));  // 제출 시 지우고 낼 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            Long GCDSum = 0L;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); 
            int[] nums = new int[n];
            for(int j=0;j<n;j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0;j<n;j++) {
                for(int k=j+1;k<n;k++) {
                    GCDSum += GCD(nums[j],nums[k]);
                }
            }
            sb.append(GCDSum);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int GCD(int a, int b) {
        while(b>0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}

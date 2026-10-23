package HYUNDAI_NGV.q11002;

// CPTI

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer1 = 0;
        int answer2 = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++) {
            int cpti = str2int(br.readLine());
            if(map.containsKey(cpti)) {
                map.put(cpti, map.get(cpti)+1);
            } else {
                map.put(cpti, 1);
            }
        }
        for(int cpti : map.keySet()) {
            // cpti 완전 동일
            int count = map.get(cpti);
            answer1 += count*(count-1)/2;
            // cpti 1개 차이
            for(int i=0;i<M;i++) {
                int compare = cpti ^ (1<<i);
                if(map.containsKey(compare)) {
                    answer2 += (count * map.get(compare));
                }
            }
            // cpti 2개 차이
            for(int i=0;i<M-1;i++) {
                for(int j=i+1;j<M;j++) {
                    int compare = cpti ^ ((1<<i) | (1<<j));
                    if(map.containsKey(compare)) {
                        answer2 += (count * map.get(compare));
                    }
                }
            }
        }
        answer2 /= 2;
        System.out.print(answer1 + answer2);
    }

    private static int str2int(String str) {
        int result = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '1') result++;
            if(i < str.length()-1) result *= 2;
        }
        return result;
    }
}


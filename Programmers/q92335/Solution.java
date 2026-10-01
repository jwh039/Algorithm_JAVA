package Programmers.q92335;

// k진수에서 소수 개수 구하기

import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int i = n%k;
            sb.append((char)(i + '0'));
            n -= i;
            n /= k;
        }
        String transformed = sb.reverse().toString();
        sb.setLength(0);
        List<Long> parsed = new ArrayList<>();
        for(int i=0;i<transformed.length();i++) {
            char c = transformed.charAt(i);
            if(c == '0') {
                String parsedStr = sb.toString();
                if(!parsedStr.equals("")) {
                    parsed.add(Long.parseLong(parsedStr));
                }
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        if(sb.length() > 0) {
            long parsedLong = Long.parseLong(sb.toString());
            parsed.add(parsedLong);
            sb.setLength(0);
        }
        for(long l : parsed) {
            answer += isPrime(l);
        }
        return answer;
    }
    
    private int isPrime(long l) {
        if(l == 1L) return 0;
        for(long ll=2;ll*ll <= l;ll++) {
            if(l%ll == 0) return 0;
        }
        return 1;
    }
}
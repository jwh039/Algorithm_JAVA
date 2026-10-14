package Programmers.q389491;

// 봉인된 주문

import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        Arrays.sort(bans, (a,b) -> {
            if(a.length() == b.length()) {
                for(int i=0;i<a.length();i++) {
                    if(a.charAt(i) != b.charAt(i)) {
                        return a.charAt(i)-b.charAt(i);
                    }
                }
            }
            return a.length()-b.length();
        });
        // 몇 번을 구해야 하는가
        for(int i=0;i<bans.length;i++) {
            if(spell2num(bans[i]) <= n) n++;
            else break;
        }
        // 변환
        return num2spell(n);
    }
    
    // 'a' = 1
    private long spell2num(String spell) {
        long result = 0;
        for(int i=0;i<spell.length();i++) {
            long val = spell.charAt(i) - 'a' + 1L;
            result += val;
            if(i<spell.length()-1) result *= 26;
        }
        return result;
    }
    
    // 'a' = 1
    private String num2spell(long num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            int val = (int)(num%26L);
            if(val == 0) {
                num -= 26;
                num /= 26;
                sb.append('z');
            } else {
                num /= 26;
                sb.append((char)(val + (int)'a' - 1));
            }
        }
        sb.reverse();
        return sb.toString();
    }
}

package Programmers.q148652;

// 유사 칸토어 비트열

class Solution {
    public int solution(int n, long l, long r) {
        return recur(n, l-1, r-1, 1, 0);
    }
    
    // 편의상 index는 0-base로 변경
    // 비트열을 5개 단위(n=1인 유사 칸토어 비트열)로 '그룹'이라 지칭
    // val = (하나의 1이 품고 있는 진짜 1의 개수)
    // counted = (이미 카운트된 1의 개수)
    private int recur(final int n, final long l, final long r, final long val, final long counted) {
        final long group_l = l/5;
        final long group_r = r/5;
        final int in_group_index_l = (int)(l%5);
        final int in_group_index_r = (int)(r%5);
        // 탈출 조건(l과 r이 같은 그룹)
        if(group_l == group_r) {
            long temp = 0;
            if(val == 1) {
                if(in_group_index_l <= 2 && in_group_index_r >= 2) temp = in_group_index_r-in_group_index_l;
                else temp = in_group_index_r-in_group_index_l+1;
            }
            else if(in_group_index_r - in_group_index_l >= 2) {
                int next_l = in_group_index_l+1;
                int prev_r = in_group_index_r-1;
                if(next_l <= 2 && prev_r >= 2) temp = (prev_r-next_l)*val;
                else temp = (prev_r-next_l+1)*val;
            }
            return (int)(counted + temp);
        }
        
        // l과 r이 다른 그룹
        long counted_here = 0;
        // 그룹이 '11011'인지 or '00000'인지
        long l_temp = l;
        boolean l_contains_1 = true;
        long r_temp = r;
        boolean r_contains_1 = true;
        while(l_temp >= 5 && l_contains_1) {
            l_temp /= 5;
            l_contains_1 = (l_temp%5 != 2);
        }
        while(r_temp >= 5 && r_contains_1) {
            r_temp /= 5;
            r_contains_1 = (r_temp%5 != 2);
        }
        if(l_contains_1) {
            int start_idx = (val==1)? in_group_index_l : in_group_index_l+1;
            int end_idx = 4;
            counted_here += (end_idx - start_idx + 1) * val;
            if(start_idx<=2) counted_here -= val;
        }
        if(r_contains_1) {
            int start_idx = 0;
            int end_idx = (val==1)? in_group_index_r : in_group_index_r-1;
            counted_here += (end_idx - start_idx + 1) * val;
            if(end_idx>=2) counted_here -= val;
        }
        
        // 재귀 call
        return recur(n-1, group_l, group_r, val*4, counted+counted_here);
    }
}

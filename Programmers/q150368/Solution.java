package Programmers.q150368;

// 이모티콘 할인행사

class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = new int[emoticons.length];
        return recur(users, emoticons, discounts, 0);
    }
    
    private int[] recur(int[][] users, int[] emoticons, int[] discounts, int current) {
        int[] res = new int[]{0,0};
        if(current == emoticons.length) {
            return calculate(users, emoticons, discounts);
        }
        for(int d=10; d<=40; d+=10) {
            discounts[current] = d;
            int[] temp = recur(users, emoticons, discounts, current+1);
            if(res[0] < temp[0]) res = temp;
            else if(res[0] == temp[0] && res[1] < temp[1]) res = temp;
        }
        return res;
    }
    
    private int[] calculate(int[][] users, int[] emoticons, int[] discounts) {
        int[] result = new int[2];
        for(int i=0;i<users.length;i++) {
            int[] userData = calculateUser(users[i], emoticons, discounts);
            result[0] += userData[0];
            result[1] += userData[1];
        }
        return result;
    }
    
    private int[] calculateUser(int[] user, int[] emoticons, int[] discounts) {
        int[] result = new int[2];
        for(int i=0;i<emoticons.length;i++) {
            if(discounts[i] < user[0]) continue;
            result[1] += emoticons[i]*(100-discounts[i])/100;
            if(result[1] >= user[1]) return new int[]{1, 0};
        }
        return result;
    }
}

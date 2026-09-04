package Programmers.q258707;

// n+1 카드 게임

import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int round = 0;
        final int n = cards.length;
        final int ON_CARDS = 0;
        final int ON_HANDS = 1;
        final int DRAWN = 2;
        final int SUBMITTED = 3;
        int[] status = new int[n+1];
        for(int i=0;i<n/3;i++) {
            status[cards[i]] = ON_HANDS;
        }
        int card_ptr = n/3;
        for(round=1;card_ptr<cards.length;round++) {
            boolean next_round = false;
            status[cards[card_ptr++]] = DRAWN;
            status[cards[card_ptr++]] = DRAWN;
            // 코인 소모 0개
            for(int k=1;k<=n/2;k++) {
                if(status[k]==ON_HANDS && status[n+1-k]==ON_HANDS) {
                    status[k] = SUBMITTED;
                    status[n+1-k] = SUBMITTED;
                    next_round = true;
                    break;
                }
            }
            if(next_round) continue;
            // 코인 소모 1개
            if(coin < 1) break;
            for(int k=1;k<=n/2;k++) {
                if((status[k]==ON_HANDS && status[n+1-k]==DRAWN) || (status[k]==DRAWN && status[n+1-k]==ON_HANDS)) {
                    coin--;
                    status[k] = SUBMITTED;
                    status[n+1-k] = SUBMITTED;
                    next_round = true;
                    break;
                }
            }
            if(next_round) continue;
            // 코인 소모 2개
            if(coin < 2) break;
            for(int k=1;k<=n/2;k++) {
                if(status[k]==DRAWN && status[n+1-k]==DRAWN) {
                    coin -= 2;
                    status[k] = SUBMITTED;
                    status[n+1-k] = SUBMITTED;
                    next_round = true;
                    break;
                }
            }
            if(!next_round) break;
        }
        return round;
    }
}

package Programmers.q159994;

// 카드 뭉치

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int ptr1 = 0; int ptr2 = 0; int ptrG;
        for(ptrG = 0; ptrG<goal.length; ptrG++) {
            if(ptr1 < cards1.length && goal[ptrG].equals(cards1[ptr1])) ptr1++;
            else if(ptr2 < cards2.length && goal[ptrG].equals(cards2[ptr2])) ptr2++;
            else return "No";
        }
        return "Yes";
    }
}

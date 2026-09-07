package Programmers.q135807;

// 숫자 카드 나누기

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcd_a = arrayA[0];
        int gcd_b = arrayB[0];
        for(int i=1;i<arrayA.length;i++) {
            gcd_a = gcd(gcd_a, arrayA[i]);
        }
        for(int i=1;i<arrayB.length;i++) {
            gcd_b = gcd(gcd_b, arrayB[i]);
        }
        for(int i=0;i<arrayA.length;i++) {
            if(arrayA[i]%gcd_b == 0) {
                gcd_b = 0;
                break;
            }
        }
        for(int i=0;i<arrayB.length;i++) {
            if(arrayB[i]%gcd_a == 0) {
                gcd_a = 0;
                break;
            }
        }
        return (gcd_a > gcd_b)? gcd_a : gcd_b;
    }
    
    private int gcd(int a, int b) {
        while(b>0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}

package Programmers.q181186;

// 아방가르드 타일링

class Solution {
    final int DIV = 1_000_000_007;
    
    public int solution(int n) {  
        int[] a = new int[100001];
        int[] b = new int[100001];
        a[1] = 1; a[2] = 3; a[3] = 10;
        b[1] = 1; b[2] = 2; b[3] = 5;
        int[] sum = new int[3];
        for(int i=4;i<b.length;i++) {
            if(i%3 == 0) b[i] = 4;
            else b[i] = 2;
        }
        for(int i=4;i<=n;i++) {
            int result = b[i];
            result = add(result, a[i-1]);
            result = add(result, add(a[i-2],a[i-2]));
            result = add(result, mul(a[i-3],5));
            result = add(result, mul(sum[i%3],4));
            result = add(result, mul(sum[(i%3+1)%3],2));
            result = add(result, mul(sum[(i%3+2)%3],2));
            a[i] = result;
            sum[i%3] = add(sum[i%3], a[i-3]);
        }
        return a[n];
    }
    
    private int add(int a, int b) {
        return (a+b)%DIV;
    }
    
    private int mul(int a, int b) {
        long al = (long)a;
        long bl = (long)b;
        return (int)(al*bl%DIV);
    }
}

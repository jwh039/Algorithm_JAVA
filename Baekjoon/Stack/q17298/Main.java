package Stack.q17298;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] NGE = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) { 
            A[i] = Integer.parseInt(st.nextToken());
            NGE[i] = -1;
        }
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        for(int i=0;i<N;i++) {
            while(!numStack.empty()) {
                // 오큰수 구하는 로직
                int prevNum = numStack.peek();
                if(prevNum < A[i]) {
                    numStack.pop();
                    int prevIndex = indexStack.pop();
                    NGE[prevIndex] = A[i];
                } else break;
            }
            numStack.push(A[i]);
            indexStack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            if(i!=0) sb.append(" ");
            sb.append(NGE[i]);
        }
        System.out.println(sb.toString());
    }
}

package SWEA.q1859;

// 백만 장자 프로젝트

//import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int[] price = new int[N];
            for(int i=0;i<N;i++) price[i] = sc.nextInt();
            Deque<int[]> deque = new ArrayDeque<>();
            for(int i=0;i<N;i++) {
                while(!deque.isEmpty()) {
                    int[] compare = deque.peekLast();
                    if(compare[0] <= price[i]) deque.pollLast();
                    else break;
                }
                deque.addLast(new int[]{price[i], i});
            }
            long profit = 0L;
            int completed = -1;
            while(!deque.isEmpty()) {
                int[] sell = deque.pollFirst();
                for(int i=completed+1; i<sell[1]; i++) {
                    profit += (long)(sell[0] - price[i]);
                }
                completed = sell[1];
            }
            System.out.print("#" + test_case + " ");
            System.out.println(profit);
		}
	}
}

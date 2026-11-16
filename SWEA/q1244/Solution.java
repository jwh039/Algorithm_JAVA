package SWEA.q1244;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num = sc.nextInt();
            int count = sc.nextInt();
            boolean[][] visited = new boolean[11][1000000];
            char[] arr = String.valueOf(num).toCharArray();
            visited[0][charArr2Int(arr)] = true;
            dfs(arr, visited, 0, count);
            for(int i=999999;i>=0;i--) {
                if(visited[count][i]) {
                    System.out.println("#" + test_case + " " + i);
                    break;
                }
            }
		}
	}
    
    private static void dfs(char[] arr, boolean[][] visited, int current, int count) {
        if(current >= count) return;
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                swap(arr, i, j);
                int val = charArr2Int(arr);
                if(!visited[current+1][val]) {
                    visited[current+1][val] = true;
                    dfs(arr, visited, current+1, count);
                }
                swap(arr, i, j);
            }
        }
    }
    
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static int charArr2Int(char[] arr) {
        int result = 0;
        for(int i=0;i<arr.length;i++) {
            int val = arr[i] - '0';
            result += val;
            if(i != arr.length-1) result *= 10;
        }
        return result;
    }
}

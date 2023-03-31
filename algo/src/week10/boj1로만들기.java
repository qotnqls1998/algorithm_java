package algo;

import java.util.Scanner;

public class boj1로만들기 {
	static int N;
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();	
		
		//res = dp();
		res=dfs();
		
		System.out.println(res);
	}

	private static int dfs() {
		
		return 0;
	}
	
	private static int dp() {
		int[] dp = new int[N+1];
		
		dp[1]=0; //1은 아무런 연산없이 1
		
		for(int i=2;i<=N;i++) {
			dp[i]=dp[i-1]+1;
			
			if(i%3==0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			if(i%2==0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}	
		}
	
		return dp[N];
	}
}

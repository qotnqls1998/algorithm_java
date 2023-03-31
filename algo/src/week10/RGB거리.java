package algo;

import java.util.Scanner;

public class RGB거리 {
	static int N;
	static int[][] exp;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		exp = new int[N][3];
		
		
		int tc = getNum();
		
		for(int i=0; i<N;i++) {
			for(int j=0;j<3;j++) {
				exp[i][j]=sc.nextInt();
			}
		}

		System.out.println(tc);
//		for(int i=0;i<tc;i++) {
//			
//		}
		
	}
	
	private static int getNum() {
		dp = new int[N];
		dp[0]=3; 
		
		for(int i=1;i<N;i++) {
			dp[i]=dp[i-1] * 2;
		}
		return dp[N-1];
	}
	
}
//private static int dp() {
//	int[] dp = new int[N+1];
//	
//	dp[1]=0; //1은 아무런 연산없이 1
//	
//	for(int i=2;i<=N;i++) {
//		dp[i]=dp[i-1]+1;
//		
//		if(i%3==0) {
//			dp[i] = Math.min(dp[i], dp[i/3]+1);
//		}
//		if(i%2==0) {
//			dp[i] = Math.min(dp[i], dp[i/2]+1);
//		}	
//	}
//
//	return dp[N];
//}
//}

/*
1
3 = 3개

2
R G
R B
 3 = 6개

3
R G B 
R G R 
R B G 
R B R

*3 = 12개 

4
R G B R
R G B G
R G R G  
R G R B
 
*2*3 = 24
*/
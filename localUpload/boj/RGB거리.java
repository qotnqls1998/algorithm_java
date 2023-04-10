package boj;
import java.util.Scanner;

public class RGB°Å¸® {
	static int N;
	static int[][] exp;
	static int[][] dp;
	static int ans;
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		exp = new int[N][3];
			
		for(int i=0; i<N;i++) {
			for(int j=0;j<3;j++) {
				exp[i][j]=sc.nextInt();
			}
		}
		ans = dp();
		System.out.println(ans);

	}
	private static int dp() {
		dp = new int[N+1][3];
		
		for(int i=1;i<=N;i++) {
			dp[][0] = r + ;
			dp[][1] = g + ;
			dp[][2] = b + ;
		}
		return Math.min(a, b);
	}
	
}

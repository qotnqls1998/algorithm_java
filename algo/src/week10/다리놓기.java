package algo;

import java.util.Scanner;

public class 다리놓기 {
	static int T,n,m;
	static int[][] result;
	static int res;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		T = sc.nextInt();
		for(int i=0 ; i<T ; i++) {
			n=sc.nextInt();
			m=sc.nextInt();
			result = new int[n+1][m+1];
			
			res= func(n,m);
			System.out.println(res);
		}
	}
	
	private static int func(int n, int m){	
		
		if(result[n][m]!=0) return result[n][m];
		if(n==m || n==0 ) return 1;
		
		else {
			result[n][m] = func(n-1,m-1)+func(n,m-1);
			return result[n][m];
		}
	}
}

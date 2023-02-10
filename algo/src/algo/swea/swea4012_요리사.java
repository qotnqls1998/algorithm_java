package algo.swea;

import java.util.Scanner;

public class swea4012_요리사 {
	static int[][] arr;
	static int ans, n;
	static boolean[] select;
	//뽑는 재료는 기존에는 카드 배열에 넣은 곳에서 뽑았는데 이번에는 0~n-1까지 번호가 재료가 됨
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
			n=sc.nextInt();
			arr=new int[n][n];
			select=new boolean[n];
			ans=Integer.MAX_VALUE;
			
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					arr[j][k]=sc.nextInt();
				}
			}
			
			comb(0,0);
		}
	}
	static void comb(int idx, int cnt) {
		if(cnt == n/2) {
			int sumA=0, sumB=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(select[i]&&select[j]) {
						sumA+=arr[i][j];
					}else if(!select[i]&&!select[j]){
						sumB+=arr[i][j];
					}
				}
			}
		}
		if(idx==n) return;
		
		select[idx]=true;
		comb(idx+1,cnt+1);
		
		select[idx]=false;
		comb(idx+1,cnt+1);
		
		
	}
}

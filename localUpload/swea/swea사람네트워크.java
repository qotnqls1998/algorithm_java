package swea;
import java.util.Scanner;

public class swea사람네트워크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		int N = 0;
		
		for(int t=1 ; t<=TC ; t++) {	
			N=sc.nextInt();
			int ans=0;
			int[][] graph = new int[N+1][N+1];
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(i==j || graph[i][j]==1) continue;
					else graph[i][j] = 10000;
				}
			}
			
			for(int k=1;k<=N;k++) {
				for(int i=1;i<=N;i++) {
					for(int j=1;j<=N;j++) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
					}
				}
			}

			int min_num = 100000;
			
			for(int i=1;i<=N;i++) {
				
				int sum =0;
				
				for(int j=1;j<=N;j++) {
					if(graph[i][j]>=10000)continue;
					sum+=graph[i][j];
				}
				if(min_num > sum) {
					min_num=sum;
					ans = i;
				}
			}
			
			System.out.println("#"+t+" "+min_num);
		}
	}
}

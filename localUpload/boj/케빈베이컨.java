package boj;
import java.util.Scanner;

public class �ɺ����� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		int[][] graph = new int[N+1][N+1];
		
		//�ʱ� ����
		for(int i=1 ; i<=N ; i++){ 
			for(int j=1; j<=N ; j++) { 
				if(i==j) continue;
				graph[i][j]=100;
			}
		}
		
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph[a][b]=1;
			graph[b][a]=1;
		}
		
		
		for(int k=1;k<=N;k++) { //������
			for(int i=1 ; i<=N ; i++) { //�����
				for(int j=1; j<=N ; j++) { //������
					graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
			
		}
		
	
		int min_num=1000000;
		int ans=0;
		int sum=0;
		
		for(int i=1;i<=N;i++) {
			sum=0;
			
			for(int j=1;j<=N;j++) {
				if(graph[i][j]>=100) continue;
				else {
					sum += graph[i][j];
				}
			}
			
			//System.out.println(sum);
			if(sum < min_num) {
				min_num = sum;
				ans = i;
			}
			
		}
		System.out.println(ans);
		
	}
}

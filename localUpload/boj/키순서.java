package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 키순서 {
	static int[][] graph1;
	static int[][] graph2;
	static int N,M;
	static boolean visit[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int cnt=0;
		
		st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		graph1 = new int[N+1][N+1];
		graph2 = new int[N+1][N+1];
		
		for(int i=0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			
			graph1[a][b]=1;
			graph2[b][a]=1;	
		}
		
		for(int i=1 ; i<=N ; i++) { //모든s 정점을 확인
			boolean isTrue=true;
			visit= new boolean[N+1];
			
//			for(int j=1; j<=N;j++) {			
//				DFS(i,j);	
//			}
			floyd();
			
			
			for(int k=1 ; k <=N ; k++) {
				if(i==k) continue;
				if(visit[k] == false) {
					isTrue = false;
					break;
				}
			}
			
			if(isTrue==true) {//모든 visit이 충족된 것만
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	private static void floyd() {
		
		
	}

	private static void DFS(int i, int j) {

		if(graph1[i][j]==1) {
			for(int k=1;k<=N;k++) {
				if(graph1[j][k]==1 && visit[k]==false ) DFS(j,k);
			}
			visit[j]=true;
		}
		
		if(graph2[i][j]==1) {
			for(int k=1;k<=N;k++) {
				if(graph2[j][k]==1 && visit[k]==false) DFS(j,k);
			}
			visit[j]=true;
		}
		
	}
}

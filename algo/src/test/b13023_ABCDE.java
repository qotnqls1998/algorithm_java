package test;

import java.util.Scanner;

public class b13023_ABCDE {
	static int[][] map;
	static boolean[] visit;
	static int N,M;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		map=new int[N][N];
		visit=new boolean[N];
		
		for(int i=0;i<M;i++) {
			int from=sc.nextInt();
			int to=sc.nextInt();
			
			map[from][to]=map[to][from]=1;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i]&&map[i][j]==1)
					DFS(i);
				
			}
		}
		
	}
	private static void DFS(int x) {
		visit[x]=true;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i]&&map[i][j]==1)
					DFS(i);
				
			}
		}
		
		
		
	}
	private static boolean check(int nx, int ny) {
		if(nx>=0 && nx<M &&ny>=0 &&ny<N) {
			return true;
		}
		else return false;
	}
}

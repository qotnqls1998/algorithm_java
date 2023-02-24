package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1012_유기농배추 {
	static int[][] map;
	static boolean[][] visit;
	static int M,N,K;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		int TC=Integer.parseInt(br.readLine());
		
		for(int t=0;t<TC;t++) {
			st = new StringTokenizer(br.readLine());
			M =Integer.parseInt(st.nextToken()); 
			N =Integer.parseInt(st.nextToken());
			K =Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visit = new boolean[N][M];
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				
				int y= Integer.parseInt(st.nextToken()) ;
				int x= Integer.parseInt(st.nextToken());
				
				map[x][y]=1;
			}
			cnt=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1 && !visit[i][j]) {
						DFS(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
	}
	
	private static void DFS(int x, int y) {
		int[] dx= {-1,1,0,0};//상하좌우
		int[] dy= {0,0,-1,1};
		
		visit[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(check(nx,ny)) {
				if(map[nx][ny]==1 &&!visit[nx][ny]) {
					DFS(nx,ny);
				}
			}	
		}
	}
	
	private static boolean check(int nx, int ny) {
		if(nx>=0 && nx<N && ny>=0 && ny<M)
			return true;
		
		else return false;
	}
}

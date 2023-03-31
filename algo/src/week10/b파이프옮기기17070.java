package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b파이프옮기기17070 {
	static int n, res;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		visit = new boolean[n+1][n+1];
		
		res=0;
		
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<n+1;j++) {
				map[i][j]=Integer.parseInt(st.nextToken()); 
			}
		}
		map[1][1]=1;
		map[n][n]=1;
		
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				System.out.print(map[i][j]+" ");
				
//				if(map[i][j]==1 && !visit[i][j]) {
//					DFS(i,j);
//				}
			}
			System.out.println();
		}
		
	}
	private static void DFS(int x, int y) {
		int[] dx= {1,1,0};//상하좌우
		int[] dy= {1,0,1};
		
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
		if(nx>=1 && nx<n+1 && ny>=1 && ny<n+1)
			return true;
		
		else return false;
	}
}

package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b4963_섬의개수 {
	static int[][] map;
	static boolean[][] visit;
	static int w,h;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w =Integer.parseInt(st.nextToken()); 
			h =Integer.parseInt(st.nextToken());
			if(w==0&&h==0)break;
			
			map = new int[h][w];
			visit = new boolean[h][w];
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
						map[i][j]=Integer.parseInt(st.nextToken());
					}
			}
			
			cnt=0;
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
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
		int[] dx= {-1,1,0,0, 1,-1,1,-1};//상하좌우 대각선4방향
		int[] dy= {0,0,-1,1, 1,-1,-1,1};
		
		visit[x][y]=true;
		
		for(int i=0;i<8;i++) {
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
		if(nx>=0 && nx<h && ny>=0 && ny<w)
			return true;
		
		else return false;
	}
}

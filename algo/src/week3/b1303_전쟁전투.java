package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1303_전쟁전투 {
	static int[][] map;
	static boolean[][] visit;
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		int team=0;
		int enemy=0;
		
		map=new int[M][N];
		visit=new boolean[M][N];
		
		for(int i=0;i<M;i++) {
			String s=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='W'&&!visit[i][j]) {
					int tmp =DFS(i,j);
					team += tmp*tmp;
					
				}else if(map[i][j]=='B'&&!visit[i][j]) {
					int tmp = DFS(i,j);
					enemy += tmp*tmp;
				}
			}
		}
		
		System.out.print(team+" "+enemy);
	}
	private static int DFS(int x, int y) {
		int[] dx= {0,0,-1,1};
		int[] dy= {1,-1,0,0};
		
		int result=1;
		visit[x][y]=true;
		
		for(int i=0;i<dx.length;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(check(nx, ny)) {
				if(!visit[nx][ny]&& ( map[x][y]==map[nx][ny]) ) {
					result+=DFS(nx,ny);
				}
			}
			
		}
		
		return result;
	}
	private static boolean check(int nx, int ny) {
		if(nx>=0 && nx<M &&ny>=0 &&ny<N) {
			return true;
		}
		else return false;
	}
}

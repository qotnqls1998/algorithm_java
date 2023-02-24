package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1926_그림 {
	static int[][] map;
	static boolean[][] visit;
	static int cnt;
	static int num;
	static int N,M;
	static int max_num=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		visit=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visit[i][j]&&map[i][j]==1) {
					num = DFS(i,j);
					cnt++;
					max_num=Math.max(num,max_num);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max_num);
	}
	
	private static int DFS(int x, int y) {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,1,-1};
		
		num=1;
		visit[x][y]=true;
		for(int i=0;i<dx.length;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(check(nx,ny)){
				if(!visit[nx][ny]&&map[nx][ny]==1) {
					num+=DFS(nx,ny);
				}
			}
		}
		return num;
	}
	
	private static boolean check(int nx, int ny) {
		if(nx>=0 && nx<N &&ny>=0&&ny<M) return true;
		return false;
	}
}

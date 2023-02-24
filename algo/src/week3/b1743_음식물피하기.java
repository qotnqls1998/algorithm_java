package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1743_음식물피하기 {
	static int N,M,K;
	static int[][] point;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,  0, 1,-1}; //우 좌 하 상
	static int[] dy = {1, -1, 0, 0};
	static int max_trash=0;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());//통로의 세로
		M=Integer.parseInt(st.nextToken());//통로의 가로
		K=Integer.parseInt(st.nextToken());
		point= new int[K+1][3];
		map = new int[N+1][M+1];
		visit = new boolean[N+1][M+1];
		
		for(int i=1;i<=K;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=2;j++) {
				point[i][j]=Integer.parseInt(st.nextToken());
			
			}
			map[point[i][1]][point[i][2]]=1;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(map[i][j]==1) {
					cnt=DFS(i,j);
					max_trash = Math.max(cnt, max_trash);
				}
			}
		}
		System.out.println(max_trash);
	}

	private static int DFS(int i, int j) {
		int result=1;
		visit[i][j]=true;
		
		//아직 방문 안한 애중에
		for(int k=0;k<4;k++) {			
			int nx=i+dx[k];
			int ny=j+dy[k];
			
			if(nx>=1&&nx<N+1&&ny>=1&&ny<M+1 ) {
				if(!visit[nx][ny]&&map[nx][ny]==1) {
					result+=DFS(nx,ny);
				}
			}
		}	
		return result;
		
	}
	
	
}

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {
	static int n,m;
	static char[][] map;
	static int[][] dist;
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		dist = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0; j<m; j++) {
				dist[i][j] = -1;
			}
		}
		
		bfs();
		ans = dist[n-1][m-1]+1;
		System.out.println(ans);
	}
	private static void bfs() {
		
		int dx[] = {0,0,-1,1};
		int dy[] = {1,-1,0,0};
		Queue<Point> que = new LinkedList<>();
		dist[0][0]=0;
		que.add(new Point(0,0));
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			for(int i=0;i<4;i++) {
				int nx = dx[i] + p.x;
				int ny = dy[i] + p.y;
				
				if( nx< 0 || nx >=n || ny<0 || ny>=m )continue;
				if( dist[nx][ny]!=-1 || map[nx][ny] != '1' ) continue;
				dist[nx][ny] = dist[p.x][p.y] +1;
				que.add(new Point(nx, ny));
			}
			
		}
		
		
	}
}

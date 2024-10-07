import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
	static int map[][];
	static int n,m;
	static int cnt;
	static int max_area;
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0; j<m; j++) {
				
				if(map[i][j]==1 && visit[i][j]==false)
					bfs(i,j);
				
			}
		}
		
		
		
		System.out.println(cnt);
		System.out.println(max_area);
	}
	private static void bfs(int x, int y) {
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		visit[x][y] = true;
		cnt++;
		
		Queue<Point> que = new LinkedList<>();
		
		que.add(new Point(x,y));
		int area =0 ;
		
		while(!que.isEmpty()) {
			area++;
			Point p = que.poll();
			
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				//조건이 아닐시 
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				if(visit[nx][ny] || map[nx][ny] != 1) continue;
				
				visit[nx][ny]= true;
				que.add(new Point(nx,ny));
			}
			max_area = Math.max(max_area, area);
			
		}
		
	}
}
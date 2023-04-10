package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {
	static int n;
	static int[][] map;
	static int ans;
	static int start_x,start_y;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					start_x=i;
					start_y=j;
				}
			}
		}
		BFS();
		//아기상어가 엄마에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간
		System.out.println(ans);
		
	}
	private static void BFS() {
		int[] dx = {-1,0,0,1}; //상 좌 
		int[] dy = {0,-1,1,0};
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(start_x, start_y));
		int shark_size=2;
		while(!q.isEmpty()) {
			int current=0; //현재먹은 물고기
			
			Point p = q.poll();
			int tmp_x = p.x;
			int tmp_y = p.y;
			
			
			for(int i=0;i<4;i++) {
				int nx = tmp_x+dx[i];
				int ny = tmp_x+dy[i];
				
				if(isCheck(nx,ny) && shark_size>map[nx][ny]) {
					//먹음
					current++;
					if(current == shark_size) {
						shark_size++;
						current=0;	
					}
					map[nx][ny]=9;		
					map[tmp_x][tmp_x]=0;
					
					q.add(new Point(nx, ny));
					ans++;
					continue;
				}
			}
			System.out.println();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}	
		}
	}
	private static boolean isCheck(int nx, int ny) {
		if(nx>=0 && nx<n && ny>=0 && ny<n)
			return true;
		return false;
	}
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

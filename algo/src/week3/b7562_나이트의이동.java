package week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b7562_나이트의이동 {
	static int l;//체스판 한변의 길이
	static int x1,y1; //현재 칸
	static int x2,y2; //이동하려는 칸
	static int nx,ny;
	static int[][] visit;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); //tc 갯수 입력
		
		for(int i=0;i<tc;i++) {
			l = sc.nextInt();//체스판 한변의 길이
				
			visit= new int[l][l];
				
			x1 = sc.nextInt(); //현재 있는 칸
			y1 = sc.nextInt();
				
			x2 = sc.nextInt();//이동하려고 하는 칸
			y2 = sc.nextInt();		
			
			//최소 몇번 움직여야하는 지 계산
			bfs(x1,y1);
			
		}
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		int[] dx = {-1,-2, 1, 2,-1, 1, 2,-2 }; //왼쪽 위 2 , 오른쪽 위 2
		int[] dy = {-2,-1, 2, 1, 2,-2,-1, 1 };
		
		q.add(new Point(x,y));
		
		visit[x][y]=0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x==x2 && p.y==y2) {
				System.out.println(visit[p.x][p.y]);
				return;
			}
			
			for(int i=0;i<8;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				
				if(check(nx, ny)) {
					if(visit[nx][ny]==0) {
						visit[nx][ny]= visit[p.x][p.y]+1;
						q.add( new Point(nx, ny) );
					}
				}
			}
		}
	}

	private static boolean check(int x, int y) {
		if(x>=0 && x<l && y>=0 && y<l) {
			return true;
		}
		return false;
	}
}
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

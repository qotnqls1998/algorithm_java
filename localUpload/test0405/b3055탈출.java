package test0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b3055Ż�� {
	static int ans;
	static char[][] map;
	static int R,C;
	static boolean[][] visit;
	static boolean[][] visit_water;
	static int start_x, start_y;
	
	static List<Point> list;
	static Queue<Point> q = new LinkedList<>();
	static Queue<Point> q1 = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map=new char[R][C];
		
		visit=new boolean[R][C];
		visit_water=new boolean[R][C];
		
		list = new ArrayList<>();
		
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='*') {
					list.add(new Point(i, j));
				}
				if(map[i][j]=='S') {
					start_x=i;
					start_y=j;
				}
			}
		}
		int ans =BFS_water();
		if(ans != -1)System.out.println(ans);
		else System.out.println("KAKTUS");

	}
	private static int BFS_water() {
		int[] dx = {1,-1, 0,0}; //���� �¿�
		int[] dy = {0, 0,-1,1};
		
		//��ġ
		int cnt =0;
		visit[start_x][start_y]=true;
		q1.add(new Point(start_x, start_y));
		
		//��
		for(Point l : list) {
			int x = l.x;
			int y = l.y;
			visit_water[x][y]=true;
			q.add(new Point(x, y));
		}
		
		while(!q1.isEmpty()) {
			int size = q.size();
			int size1 = q1.size();
			
			//���� ���ű����� �ϰ� stop
			for(int l=0;l<size;l++) {
				Point p = q.poll();
				int tmp_x=p.x;
				int tmp_y=p.y;
				
				for(int i=0;i<4;i++) {
					//���Ž��
					int nx = tmp_x+dx[i];
					int ny = tmp_y+dy[i];
					
					if(isCheck(nx, ny) && visit_water[nx][ny]!=true ) { //������ �ȹ���� �湮���� ������
						if(map[nx][ny]=='.' || map[nx][ny]=='S') {
							visit_water[nx][ny]=true;
							map[nx][ny]='*';
							q.add(new Point(nx,ny));
						}
					}
				}
			}	
			for(int l=0;l<size1;l++) {
				
				Point p = q1.poll();
				int tmp_x=p.x;
				int tmp_y=p.y;
				
				for(int i=0;i<4;i++) {
					//���Ž��
					int nx = tmp_x+dx[i];
					int ny = tmp_y+dy[i];
					
					if(isCheck(nx, ny) && visit[nx][ny]!=true ) { //������ �ȹ���� �湮���� ������
						if(map[nx][ny]=='.') {
							visit[nx][ny]=true;
							map[nx][ny]='S';
							map[tmp_x][tmp_y]='.';//�����ִ���
							
							q1.add(new Point(nx,ny));
						}
						
						if(map[nx][ny]=='D') {
							cnt++;
							
							return cnt;
						}
					}
				}
			}	

			cnt++;		
		}
		return -1;
	}
	
	private static boolean isCheck(int nx, int ny) {
		if(nx>=0 && nx<R && ny>=0 && ny<C)
			return true;
		return false;
	}
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}

}

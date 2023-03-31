package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b말이되고픈원숭이 {
	
	static int[][] map;
	static int[][] visit;
	
	static int res;
	static int nx, ny;
	static int K;
	static int w,h;
	
	static int[] mx= {1,0,0,-1};
	static int[] my= {0,1,-1,0};
	static int[] hx= {2, 1, -2, -1, 2, -1, -2, 1};
	static int[] hy= {1, 2, -1, -2, -1, 2, 1, -2};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		w =  Integer.parseInt(st.nextToken());
		h =  Integer.parseInt(st.nextToken());
	
		map = new int[w][h];
		visit = new int[][];
		
		for(int i=0;i<w;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<h;j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
		
		
	}
	private static char[] bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add( new Point(0,0,0) );
		visit[0][0][0] = true;
		
		int time=0;
		
		
	
	}

	static class Point{
		int i,j,skill;
		
		public Point(int i, int j, int skill) {
			this.i=i;
			this.j=j;
			this.skill = skill;
		}
	}
}

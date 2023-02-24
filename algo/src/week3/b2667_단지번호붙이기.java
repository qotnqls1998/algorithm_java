package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b2667_단지번호붙이기 {
	static int[][] map;
	static boolean[][] visit;
	static int cnt;
	static int num;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		List<Integer> arrnum = new ArrayList<>();
		
		map=new int[N][N];
		visit=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]&&map[i][j]==1) {
					num = DFS(i,j);
					cnt++;
					arrnum.add(num);
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(arrnum);
		for(int n:arrnum) {
			System.out.println(n);
		}
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
		if(nx>=0 && nx<N &&ny>=0&&ny<N) return true;
		return false;
	}
}

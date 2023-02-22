package algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1873_배틀 {
	static char[][] map;
	static char[] cmd;
	static int nowx, nowy;
	static int H,W,N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			
			for(int j=0;j<H;j++) {
				String s = br.readLine();
				for(int k=0;k<W;k++) {
					map[j][k]= s.charAt(k);
					if(map[j][k]=='<'||map[j][k]=='v'||map[j][k]=='^'||map[j][k]=='>') {
						nowx=j;
						nowy=k;
					}
						
				}
			}
			
			N= Integer.parseInt(br.readLine());
			cmd = new char[N];
			
			String tmp=br.readLine();
			for(int j=0;j<H;j++) {
				cmd[j]=tmp.charAt(j);
			}
			
			//메소드 호출
			Attack(nowx,nowy,0);
			
			//출력
			for(int j=0;j<H;j++) {
				for(int k=0;k<W;k++) {
					System.out.print(map[j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	private static void Attack(int nx, int ny, int cnt) {
		int[] dx= {1, 0,-1, 0}; // 아래, 오른, 위, 왼쪽
		int[] dy= {0, 1, 0,-1};
		
		if(cnt==N-1) {
			return;
		}
		for(int i=0;i<N;i++) {
			if(cmd[i]=='U') {
				map[nx][ny]='^';
				int next_x=nx-1;
				int next_y=ny;
				if(map[next_x][next_y]=='.') {//위에가 평지라면 swap
					map[next_x][next_y]=map[nx][ny];
					map[nx][ny]='.';
				}
			}else if(cmd[i]=='D') {
				map[nx][ny]='v';
				int next_x=nx+1;
				int next_y=ny;
				if(map[next_x][next_y]=='.') {
					map[next_x][next_y]=map[nx][ny];
					map[nx][ny]='.';
				}
			}else if(cmd[i]=='L') {
				map[nx][ny]='<';
				int next_x=nx;
				int next_y=ny-1;
				if(map[next_x][next_y]=='.') {//위에가 평지라면 swap
					map[next_x][next_y]=map[nx][ny];
					map[nx][ny]='.';
				}
			}else if(cmd[i]=='R') {
				map[nx][ny]='>';
				int next_x=nx;
				int next_y=ny+1;
				if(map[next_x][next_y]=='.') {//위에가 평지라면 swap
					map[next_x][next_y]=map[nx][ny];
					map[nx][ny]='.';
				}
			}else if(cmd[i]=='S') {
				//바라보는 방향으로 슛
				System.out.println("s");
				System.out.println();
			}
		
			for(int j=0;j<H;j++) {
				for(int k=0;k<W;k++) {
					System.out.print(map[j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
		
	}
}

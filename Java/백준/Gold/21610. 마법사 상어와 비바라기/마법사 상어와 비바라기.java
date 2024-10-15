import java.util.*;
import java.io.*;


public class Main {
	static int n,m;
	static int di,si;
	static int map[][];
	static int visit[][];
	static int ans;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		visit = new int[n][n];
		
		for(int i=0;i<n;i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		//처음 구름 생성 
		int dx[] = {0,0,-1,-1};
		int dy[] = {0,1,0,1};
		
		for(int i=0;i<4;i++) {
			int nx = (n-1)+dx[i];
			int ny = dy[i];
			
			visit[nx][ny] = 2;
		}
	
		//printMap();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			di = Integer.parseInt(st.nextToken())-1;
			si = Integer.parseInt(st.nextToken());
			
			//System.out.println((i+1) + " 번쨰  ");
			
			move();
			//System.out.println((i+1) + " 이동완료  ! ");
			//printMap();
			//System.out.println();
			
			
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ans = ans+map[i][j];
			}
		}
		System.out.println(ans);
	}
	private static void move() {
		//구름 이동 
		int dx[] = {0,n-1,n-1,n-1,0,1,1,1};
		int dy[] = {n-1,n-1,0,1,1,1,0,n-1};
		int nx =0;
		int ny=0;
		
		//printMap1();
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j]==2) {
					q.offer(new int[] {i,j});
					visit[i][j]=0;
			}	
			}}
		
		while(!q.isEmpty()) {
			int arr[] = q.poll();
			int arrx = arr[0];
			int arry = arr[1];
			
			//int temp = visit[arrx][arry]; //현재 있던곳 0으로.. 비워 .. 	 
			//visit[arrx][arry]=0;
			
			nx = (arrx+dx[di]*si) % n;
			ny = (arry+dy[di]*si) % n;
			
			visit[nx][ny] = 2;
			
			
			
		}
		
	
		addWater();
		
	}
	private static void addWater() {
		int dx[] = {-1,-1,1,1};
		int dy[] = {-1,1,1,-1};
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j]==2) {
					map[i][j]++;
					visit[i][j]=1; // 구름 삭제 
					}
				}
			}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j]==1) {
					
					for(int k=0; k<4;k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(!check(nx,ny)) continue;
						if(map[nx][ny]!=0) map[i][j]++;
					}
				}
				
			}
		}

		nextCloud();
		
	
	}
	private static void nextCloud() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j]==1) {
					continue; // 아까 구름 생긴곳 
				}
				
				if(map[i][j] >=2) {
					visit[i][j] =2;
					map[i][j]= map[i][j]-2;
				}
				
				}
			}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j]==1) {
					visit[i][j]=0;
				}
			}
		}
//		System.out.println("구름 생기고 물이 들어들음 .. ");
//		printMap();
//		printMap1();
			
	}
	private static boolean check(int x, int y) {
		if(x<0||x>=n||y<0||y>=n) return false;
		return true;
	}
	private static void printMap() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]+" ");
				//System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void printMap1() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				
				System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	
}
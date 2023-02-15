package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16935_배열돌리기3 {
	static int[][] map;
	static int[][] newmap;
	static int N;
	static int M;
	static int R;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N =  Integer.parseInt(st.nextToken());	
		M =  Integer.parseInt(st.nextToken());	
		R =  Integer.parseInt(st.nextToken());	
		
		map = new int[N][M];
		newmap = new int[N][M];
		//저장
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int A =  Integer.parseInt(br.readLine());	
		
		//바꾸기전
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		int tmp=0;
		//상하 반전
		if(A==1) {
			for(int k=0;k<R;k++)
				for(int i=0;i<N/2;i++) {
					for(int j=0;j<M;j++) {
						tmp = map[i][j];
						map[i][j]=map[N-1-i][j];
						map[N-1-i][j]=tmp;
					}
				}
		}else if(A==2) {//좌우 반전
			for(int k=0;k<R;k++)
				for(int i=0;i<N;i++) {
					for(int j=0;j<M/2;j++) {
						tmp = map[i][j];
						map[i][j]=map[i][M-1-j];
						map[i][M-1-j]=tmp;
					}
				}
		}else if(A==3) {//오른쪽 90도 회전
			for(int k=0;k<R;k++) {
				
				newmap = new int[M][N];
				
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						newmap[i][j]=map[j][i];
					}
				}
				//덮어써
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++) {
						map[i][j]=newmap[i][j];
					}
				}
			}
		}else if(A==4) {//왼쪽 90도 회전
			
			
			
			
		}else if(A==5) {
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<M/2;j++) {
					int[][] tmp2 = new int[N/2][M/2];
					
					
							
				}
			}
			
		}else if(A==6) {
			
		}
		
		
		System.out.println();
		
		//바꾸기 후
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(newmap[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}
}

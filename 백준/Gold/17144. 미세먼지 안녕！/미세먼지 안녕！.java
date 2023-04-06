import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C,T;
	static int[][] map;
	static int[][] add_map;
	static int[][] minus_cnt;
	static int[][] minus_num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		
		map=new int[R][C];
		add_map=new int[R][C];
		minus_cnt=new int[R][C];
		minus_num=new int[R][C];
		
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int l=0;l<T;l++) {
		
		add_map=new int[R][C];
		minus_cnt=new int[R][C];
		minus_num=new int[R][C];
			
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				//미세먼지가 없거나 공기청정기가 있는 방에는 spread하지 않음
				if(map[i][j]!=0 && map[i][j]!=-1) {
					spread(i,j);
				}
			}
		}
		
		int[] air=new int[2];
		//air[0]는 위쪽 공기청정기
		//air[1]는 아래쪽 
		int cnt=0;
		//분산이 끝나고
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				//동시에 다 스프레드 한 값을 더함. 그리고 내가 뿌린 값을 빼줭
				if(map[i][j]!=-1) {
					map[i][j]+=add_map[i][j];
					map[i][j] -= minus_cnt[i][j]*minus_num[i][j];
				}
				if(map[i][j]==-1) {
					air[cnt++]=i;
				}
				
			}
		}
	
			
			//공기청정기 윗쪽 돌리기
			//step1 왼쪽
			for(int i=air[0]-1;i>0;i--) {
				map[i][0]=map[i-1][0];
			}
			//step2 위
			for(int i=0;i<C-1;i++) {
				map[0][i]=map[0][i+1];
			}
			//step3 오른쪽
			for(int i=0;i<air[0];i++) {
				map[i][C-1]=map[i+1][C-1];
			}
			
			//System.out.println(air[0]);
			//step4 아래
			for(int i=C-1;i>1;i--) {
				map[air[0]][i]=map[air[0]][i-1];
		
			}
			map[air[0]][1]=0;
			
			//공기청정기 아랫쪽 돌리기
			//step1 왼쪽 변- 위로 올리기
			for(int i=air[1]+1;i<R-1;i++) {
				map[i][0]=map[i+1][0];
			}
			//step2 아랫쪽 변 - 왼쪽으로 
			for(int i=0;i<C-1;i++) {
				map[R-1][i]=map[R-1][i+1];
			}
			//step3 오른쪽 변 - 밑으로 
			for(int i=R-1;i>air[1];i--) {
				map[i][C-1]=map[i-1][C-1];
			}
			//step4 위쪽변 - 오른족으로
			for(int i=C-1;i>1;i--) {
				map[air[1]][i]=map[air[1]][i-1];
		
			}
			map[air[1]][1]=0;
		}
		
		//결과물 
		int sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				//System.out.print(map[i][j]+"  ");
				if(map[i][j]!=-1)
					sum+=map[i][j];
			}
			//System.out.println();
		}
		System.out.println(sum);
	}
	private static void spread(int x, int y) {
		int[] dx= {0,0,1,-1};
		int[] dy= {1,-1,0,0};
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(check(nx,ny)) {
				int tmp_minus=map[x][y]/5;
				add_map[nx][ny] += tmp_minus;
				minus_cnt[x][y]+=1;
				minus_num[x][y]=tmp_minus;
				//map[x[y]-=tmp_minus;
			}
			
		}
	}
	private static boolean check(int nx, int ny) {
		if(nx>=0 && nx<R && ny>=0 && ny<C &&map[nx][ny]!=-1) {
			return true;
		}
		else return false;
	}
}
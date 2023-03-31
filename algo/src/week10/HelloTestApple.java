package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HelloTestApple {
	static int T,N;
	static int[][] map;
	static int apple_num;
	static int result;
	static int nowx,nowy;
	static int dir;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		T = Integer.parseInt(br.readLine());	
		
		for(int tc=0;tc<T;tc++) {
			result=0;
			N = Integer.parseInt(br.readLine());
			map=new int[N][N];
			
			StringTokenizer st;
			int max_apple=0;
				
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(max_apple<map[i][j])
						max_apple=map[i][j];
				}
			}		
			//사과가 있는 곳 담을 index
			int[][] apple_map = new int[max_apple][2];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]!=0) {
						//사과 가 있는곳 차례대로 저장
						apple_map[ map[i][j]-1 ][0]=i;
						apple_map[ map[i][j]-1 ][1]=j;
					}
				}
			}	
			//시작 인덱스 !
			nowx=0;
			nowy=-1;

			int cnt=0;
			dir=1; //1: 우,  2: 하 ,  3: 좌, 4: 상
			boolean visit=false;
			
			while(true) {
				//시작할때 무조건 한칸 이동	
				move(nowx,nowy,dir);
				int tmp=cnt;
				
				//미리 계산
				int tmp_x=apple_map[tmp][0];
				int tmp_y=apple_map[tmp][1];
				int apple_x=apple_map[cnt][0];
				int apple_y=apple_map[cnt][1];
				
				
				//간 값에 사과가 있네 ? 먹고 다음거 찾자
				if( nowx == apple_x && nowy == apple_y) {
					//여기가 관건
					visit=false;
					cnt++;
					//다음꺼 방향 잡아주기!!
					
				}
				//사과를 다먹었으면 .. break
				if(cnt==max_apple) {
					break;
					}
				
				//나는 지금 오른쪽 보고있는데 .. 
				if(dir ==1) {
					if((apple_y < tmp_y) && (apple_x<tmp_x) ) {
						for(int i=0;i<2;i++) {
							move(nowx,nowy,dir);
							rotate(nowx,nowy);
						}
					}
					if((apple_y < tmp_y) && (apple_x> tmp_x)) {
						rotate(nowx,nowy);
					}
				}
				//나는 지금 밑에보고 있는데 ..
				else if(dir ==2) {
					// 다음께 왼쪽 위에 있네~
					if( (apple_y< tmp_y) && (apple_x< tmp_x) ) {
						rotate(nowx,nowy);
						}
					// 다음께 오른쪽 아래에 있네~
					if((apple_y> tmp_y) && (apple_x< tmp_x)) {
						for(int i=0;i<2;i++) {
							move(nowx,nowy,dir);
							rotate(nowx,nowy);
						}
					}	
				}
						
				//나는 지금 왼쪽에보고 있는데 ..
				else if(dir ==3) {
					//다음사과 왼쪽
					if( (apple_y > tmp_y) && (apple_x> tmp_x)) {
						for(int i=0;i<2;i++) {
							move(nowx,nowy,dir);
							rotate(nowx,nowy);
						}	
					}
					//다음사과 오른쪽
					if( (apple_y > tmp_y) && (apple_x< tmp_x)) {
						rotate(nowx,nowy);
					}
				}
			
				
				//나는 지금 위에보고 있는데 .. 
				else if(dir ==4) {
					//다음사과 왼쪽
					if( (apple_y< tmp_y) && (apple_x > tmp_x)) {
						for(int i=0;i<2;i++) {
							move(nowx,nowy,dir);
							rotate(nowx,nowy);
						}
					}
					//다음사과 오른쪽
					if((apple_y> tmp_y) && (apple_x > tmp_x)) {
						rotate(nowx,nowy);
					}	
				}
				
				//지금은 사과찾는 중입니다!! 
				if(visit == false) {	
					//먼저 같은 열에 있는지 탐색
					if( dir ==1 && apple_map[cnt][1] == nowy ) {
						// 사과가 아랫쪽
						if( apple_map[cnt][0] > nowx) {
							rotate(nowx,nowy);
						}			
						// 사과가 위쪽
						else if(apple_map[cnt][0] < nowx) {
							for(int i=0;i<3;i++) {
								move(nowx,nowy,dir);
								rotate(nowx,nowy);
							}
						}
						visit=true;		
					}	
					
					//같은 행에 있으면 찾으러 ㄱ ㄱ 내려가는중..
					if(dir==2 && apple_map[cnt][0] == nowx) {
						//왼쪽
						if(apple_map[cnt][1] < nowy) {
							rotate(nowx,nowy);
						}
						//오른쪽
						else if(apple_map[cnt][1] > nowy) {
							for(int i=0;i<3;i++) {
								move(nowx,nowy,dir);
								rotate(nowx,nowy);
							}
						}
						visit=true;
					}	
					
					//올라가는중 .. 같은 행 검사
					if(dir==4 && apple_map[cnt][0] == nowx) {
						if(apple_map[cnt][1] < nowy) {//사과가 왼쪽
							for(int i=0;i<3;i++) {
								move(nowx,nowy,dir);
								rotate(nowx,nowy);
							}
						}
						else if(apple_map[cnt][1] > nowy) { //사과가 오른쪽
							rotate(nowx,nowy);
						}
						visit=true;
					}
								
					//왼쪽으로 가는중 룰루 같은 열검사
					if(dir==3 && apple_map[cnt][1] == nowy) {
						if(apple_map[cnt][0] < nowx) { //사과가 위쪽
							rotate(nowx,nowy);
						}else if(apple_map[cnt][0] > nowx) { //사과가 아래쪽
							for(int i=0;i<3;i++) {
								move(nowx,nowy,dir);
								rotate(nowx,nowy);
							}
						}
						visit=true;
					}
				}//visit 이 false 라면 = 아직 다음사과 찾는중
				
			}//while문끝
			System.out.println("#"+(tc+1) +" "+ result);
		}
	}
	
	private static void rotate(int x, int y) {
		dir+=1;
		if(dir>4) {
			dir-=4;
		}
		result++;
	}
	
	private static void move(int x, int y, int dir) {	
		if(dir==1) {
			//오른쪽으로 한칸
			nowx=x;
			nowy=y+1;
		}
		if(dir==2) {
			//아래쪽으로 한칸
			nowx=x+1;
			nowy=y;
		}
		if(dir==3) {
			//왼쪽으로 한칸
			nowx=x;
			nowy=y-1;
		}
		if(dir==4) {
			//위쪽으로 한칸
			nowx=x-1;
			nowy=y;
		}
		
//		if(map[nowx][nowy]==0)
//			map[nowx][nowy]=7;
	}
}
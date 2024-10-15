import java.io.*;
import java.util.*;

//최소 사각지대 수 찾기
public class Main {
    static int n,m; //map 가로,세로
    static int k; //cctv 갯수
    static int[][] cctv;
    static int tc=1;
    static int tmpMin;
    static int min=100;
    static int[][] map;
    static int[][] cpMap;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j]<=5) k++;
            }
        }
        cctv = new int[k][2];

        int idx=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(map[i][j] >= 1 && map[i][j]<=5) {
                    cctv[idx][0] = i;
                    cctv[idx][1] = j;
                    idx++;
                }
            }
        }

        cpMap = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                cpMap[i][j] = map[i][j] ; // 앞으로 사용할 복사 맵
            }
        }

        //감시 시작
        for(int i=0; i<k; i++){
            tc = tc * 4;
        }

        for(int i=0; i<tc; i++){
            //숫자에서 가져오기
            int nowN = i;

            for(int j=0; j<k; j++){
                int x = cctv[j][0];
                int y = cctv[j][1];

                int c = nowN % 4;
                nowN = nowN / 4;

                if(cpMap[x][y]==1){
                    cam(x,y,c);
                }
                else if(cpMap[x][y]==2){
                    cam(x,y,c);
                    cam(x,y,c+2);
                }
                else if(cpMap[x][y]==3){
                    cam(x,y,c);
                    cam(x,y,c+1);
                }
                else if(cpMap[x][y]==4){
                    cam(x,y,c);
                    cam(x,y,c+1);
                    cam(x,y,c+2);
                }
                else{
                    cam(x,y,c);
                    cam(x,y,c+1);
                    cam(x,y,c+2);
                    cam(x,y,c+3);
                }

            }

            //해당 case 조사
            findBlk();
            min = Math.min(min, tmpMin);
            //System.out.println("tmp:"+tmpMin);

            //숫자 초기화
            tmpMin = 0 ;

            //맵 초기화
            for(int l=0; l<n; l++){
                for(int u=0; u<m; u++) {
                    cpMap[l][u] = map[l][u] ;
                }
            }
        }
        System.out.println(min);

    }
    //방향이 주어졌을때 map을 물들이기
    private static void cam(int x,int y,int d) {
        d = d%4;

        while(true){
            x += dx[d];
            y += dy[d];
            if(check(x,y) || cpMap[x][y]==6) return;
            if(cpMap[x][y]!=0) continue;  //다른 cctv가 있을때 넘김
            cpMap[x][y] = 7;
        }
    }

    //범위 벗어나가면 false 리턴
    private static boolean check(int x, int y){
        return x<0||x>=n||y<0||y>=m;
    }

    //현재 사각지대 갯수 세기
    private static void findBlk() {
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               // System.out.print(cpMap[i][j]+" ");
                if(cpMap[i][j] == 0) tmpMin++;
            }
            //System.out.println();
        }
    }

}

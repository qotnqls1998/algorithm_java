import java.util.*;
import java.io.*;

public class Main {
    //스티커 붙히기
    static int n;
    static int m;
    static int k; //스티커 갯수
    static int[][] sticker;
    static int[][] note;
    static int r,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        note = new int[n][m]; //빈 종이 (노트북)

        //스티커 입력받기
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            sticker=new int[11][11];

            for(int j=0;j<r;j++){
                st = new StringTokenizer(br.readLine());
                for(int l=0;l<c;l++){
                    sticker[j][l]=Integer.parseInt(st.nextToken());
                }
            }

            //스티커 붙히기
            //4방향 rotate
            for(int j=0;j<4;j++){
                boolean isPost = false;
                for(int l=0;l<n-r+1;l++){
                    if(isPost)break;
                    for(int o=0;o<m-c+1;o++){
                        if(pastable(l,o)) {
                            isPost = true;
                            break; // 붙힐수 있으면 break
                        }
                    }
                }
                if(isPost)break;



                rotate(); //90도 회전 후 다음에도 확인
            }


        }
//        for(int q=0;q<n;q++){
//            for(int w=0;w<m;w++){
//                System.out.print(note[q][w]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        //출력
        int ans = check();
        System.out.println(ans);

    }
    private static int check(){
        int num =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(note[i][j] ==1) num++;
            }
        }
        return num;
    }
    //스티커의 최대 가로,세로는 10
    private static boolean pastable(int x, int y){

        //붙힐수 있는지 확인
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                //이미 그자리에 스티커가 있는 경우 못붙힘
                if(note[i+x][j+y]==1 && sticker[i][j]==1){
                    return false;
                }
            }
        }

        //붙히기
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(note[i+x][j+y]==0 && sticker[i][j]==1){
                    note[i+x][j+y]=1;
                }
            }
        }

        return true; //붙히기 성공
    }
    private static void rotate(){
        int[][] tmp = new int[11][11];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                tmp[i][j] = sticker[i][j];
            }
        }
        for(int i=0;i<c;i++){
            for(int j=0;j<r;j++){
                sticker[i][j]=tmp[r-1-j][i];
            }
        }

        int tmp_num =0;
        tmp_num = r;
        r = c ;
        c = tmp_num;
    }




}
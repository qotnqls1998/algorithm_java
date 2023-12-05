import java.io.*;
import java.util.*;

public class 계란치기 {
    static int n;
    static int egg[][];
    static int now_idx;
    static int bk_num;
    public static void main(String[] args) throws IOException, Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        n = Integer.parseInt(br.readLine());
        egg = new int[n][2];

        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            egg[i][0]=Integer.parseInt(st.nextToken());
            egg[i][1]=Integer.parseInt(st.nextToken());
        }

        now_idx=0;
        brokeEgg(0,0);

        //정답 출력
        System.out.println(bk_num);
    }

    private static void brokeEgg(int n_idx, int cnt){
        //리턴 조건
        //n_idx가 n개이상 ( n개 모두 다 본 상태. )
        // cnt (깨진 갯수가 ) (n-1일때 )
        if(cnt >= n-1||n_idx==n  ){

            bk_num=Math.max(bk_num,cnt);
            return;
        }

        //깨진계란 x
        if (egg[n_idx][0]<=0){
            brokeEgg(n_idx+1,cnt);
        }else{
            for(int i=0;i<n;i++){
                if(i==n_idx) continue;
                if (egg[i][0] > 0) {
                    egg[i][0]-=egg[n_idx][1];
                    egg[n_idx][0]-=egg[i][1];

                    brokeEgg(n_idx+1,cnt + (egg[i][0] <=0 ? 1 : 0) + (egg[n_idx][0] <=0 ? 1 : 0) );

                    egg[i][0]+=egg[n_idx][1];
                    egg[n_idx][0]+=egg[i][1];
                }

            }
        }

    }
}

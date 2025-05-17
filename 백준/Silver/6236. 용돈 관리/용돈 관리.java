import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int ans;
    static int[] account;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        account = new int[n];

        for(int i =0;i<n;i++){
            account[i] = Integer.parseInt(br.readLine());
        }
        ans = binSearch();
        System.out.println(ans);

    }
    private static int binSearch() {

        int mid =0;
        //int cnt =0;

        int st = Arrays.stream(account).max().getAsInt();
        int ed = Arrays.stream(account).sum();

        while(st<=ed){
            mid = (st+ed)/2; // 인출하는 돈
            int money = mid; //가진돈
            int cnt=1 ; //첫 인출
            for(int i =0;i<n;i++){
                money = money - account[i];  //지출
                //돈 다쓸경우
                if(money<=0){
                    cnt ++; //추가 인출
                    money = mid-account[i];

                }
            }
            //인출 횟수 늘면
            if(cnt > m){
                st = mid +1 ;
            }else{
                ed = mid -1;
            }
        }

        return mid;
    }
}
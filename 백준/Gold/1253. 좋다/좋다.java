import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int arr[];
    static int ans;
    static int start, end;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = twoPointer();

        System.out.println(ans);
    }
    private static int twoPointer(){
        int sum = 0;
        //정렬
        Arrays.sort(arr);


        for(int i=0;i<n;i++){
            long find = arr[i];
            start = 0;
            end = n-1;

            while(start<end){
                if (arr[start] + arr[end] == find){
                    if(start != i && end != i){
                        sum++;
                        break;
                    }
                    else if(start == i){
                        start ++;
                    }
                    else if(end == i){
                        end --;
                    }
                }
                else if(arr[start] + arr[end] < find ){
                    start ++;
                }else {
                    end --;
                }

            }

        }


        return sum ;
    }
}
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[26];
		String word = br.readLine();
		
		for(int i=0;i<word.length();i++) {
			//System.out.println(word.charAt(i));
			int idx = word.charAt(i);
			
			//대문자 
			if( 65 <= idx && idx <= 90) {
				arr[idx-65] ++;
			}
			//소문자  
			else if ( 97<=word.charAt(i)) {
				arr[idx-97] ++;
			}
			
		}
		int max = -1;
		char ans = '?';
		
		for(int i=0;i<26;i++) {
			if(max < arr[i]) {
				max = arr[i];
				ans = (char) (i + 65);
			}
			else if(max == arr[i]) {
				ans = '?';
				//break;
			}
		}
		
		System.out.println(ans);
		
		
		
	}
}
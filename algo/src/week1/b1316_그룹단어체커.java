package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1316_그룹단어체커 {
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		visit= new boolean[26];
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			visit= new boolean[26];
			String s=br.readLine();
			if(checkGroup(s)) {
				cnt++;
			}	
		}
//		for(int i=0;i<26;i++) {
//			System.out.println(i +" : "+visit[i]);
//		}
		System.out.print(cnt);
	}

	private static boolean checkGroup(String s) {
		
		for(int i=0;i<s.length();i++) {
			//첫번째 글짜는 무조건 첫방문이니 true
			if(i==0)
				visit[s.charAt(i)-'a']=true;
			else {
				//앞글자의문자와 같다면 넘기자
				if(s.charAt(i)==s.charAt(i-1)) {
					continue;
				}
				else {//앞글자의 문자와 다른데 이미 visit배열에 방문했던 경우
					if(visit[s.charAt(i)-'a'])
						return false;
					else {
						visit[s.charAt(i)-'a']=true;
					}
				}
			}
		}
		
		return true;
	}
}

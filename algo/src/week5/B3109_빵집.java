package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3109_빵집 {
	static boolean[][] visited;
	static boolean check;
	static char[][] map;
	static int r;
	static int c;
	static int cnt2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);

			}
		}
		int cnt = 0;

		for (int i = 0; i < r; i++) {
			// System.out.println(visited[i][j]);
			check = false;
			visited[i][0] = true;

			Load(i, 0);
			if (check)
				cnt++;

		}

		System.out.println(cnt);

	}

	private static boolean Load(int x, int y) {
		int[] dx = { -1, 0, 1 };// 대각선 위 , 오른쪽, 대각선 아래
		int[] dy = { 1, 1, 1 };

		// if(y == c-1) return true;

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위 체크
			if (0 <= ny && ny < c && 0 <= nx && nx < r) {
				if ((map[x + dx[i]][y + dy[i]] == '.') && !(visited[x + dx[i]][y + dy[i]]) && !check) {
					visited[nx][ny] = true;
					if (ny == c - 1) {
						check=true;
					} else {
						boolean tmp = Load(nx, ny);
						if(tmp == true)
							return true;
					}
				}
			}
		}

		return false;
	}
}

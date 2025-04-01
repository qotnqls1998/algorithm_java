import java.util.*;

class Point {
    int ry, rx, by, bx, cnt;
    
    Point(int ry, int rx, int by, int bx, int cnt) {
        this.ry = ry;
        this.rx = rx;
        this.by = by;
        this.bx = bx;
        this.cnt = cnt;
    }
}

public class Main {
    static int N, M;
    static char[][] board;
    static Set<String> visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        
        board = new char[N][M];
        visited = new HashSet<>();
        
        int rx = 0, ry = 0, bx = 0, by = 0;
        
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    ry = i;
                    rx = j;
                } else if (board[i][j] == 'B') {
                    by = i;
                    bx = j;
                }
            }
        }
        
        System.out.println(BFS(ry, rx, by, bx));
    }
    
    static int[] move(int y, int x, int dy, int dx) {
        int distance = 0;
        while (board[y + dy][x + dx] != '#' && board[y][x] != 'O') {
            y += dy;
            x += dx;
            distance++;
        }
        return new int[]{y, x, distance};
    }
    
    static int BFS(int ry, int rx, int by, int bx) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(ry, rx, by, bx, 1));
        visited.add(ry + "," + rx + "," + by + "," + bx);
        
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            
            if (cur.cnt > 10) return -1;
            
            for (int i = 0; i < 4; i++) {
                int[] redMove = move(cur.ry, cur.rx, dy[i], dx[i]);
                int[] blueMove = move(cur.by, cur.bx, dy[i], dx[i]);
                
                int nry = redMove[0], nrx = redMove[1], disr = redMove[2];
                int nby = blueMove[0], nbx = blueMove[1], disb = blueMove[2];
                
                if (board[nby][nbx] == 'O') continue;
                if (board[nry][nrx] == 'O') return cur.cnt;
                
                if (nry == nby && nrx == nbx) {
                    if (disr > disb) {
                        nry -= dy[i];
                        nrx -= dx[i];
                    } else {
                        nby -= dy[i];
                        nbx -= dx[i];
                    }
                }
                
                String state = nry + "," + nrx + "," + nby + "," + nbx;
                if (!visited.contains(state)) {
                    visited.add(state);
                    queue.add(new Point(nry, nrx, nby, nbx, cur.cnt + 1));
                }
            }
        }
        return -1;
    }
}
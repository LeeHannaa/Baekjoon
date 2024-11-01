/*
[문제 요약]
유기농 배추 밭이 있다. 배추흰지렁이를 통해서 배추를 보호하는 시스템.
인접한 배추 지역마다 배추흰지렁이가 한마리만 있으면 된다. 인접은 동서남북 4방향.
0은 배추 없음, 1은 배추 있음
[입력]
TestCase - T
가로 M 세로 N 배추 개수 K
K반복 - x,y 배추 위치 입력받기
[출력]
배추 개수 출력
*/
/*
BFS (QUEUE)
1. T입력받기 (T 반복)
2. M N K 입력받기
3. K 반복하면서 배추 위치 x,y 입력받기 -> field에 배추 위치 표시
    3-1. field를 탐방하면서 방문한 곳인지 아닌지 확인
        3-1-1. 방문하지 않고 배추가 있는 곳이면 bfs 탐색 시작
    3-2. 이어지지 않은 경우 count++;
4. count 출력

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Baekjoon1012 {
    static int t;
    static int m,n,k;
    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, -1, 0, 1};
    static boolean[][] visited;
    static boolean[][] field;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            field = new boolean[m][n];
            visited = new boolean[m][n];

            for (int c = 0; c < k; c++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = true; // 배추 위치 표시
            }

            int count = 0;
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (field[x][y] && !visited[x][y]) { // 방문하지 않은 배추가 있으면
                        bfs(x, y);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
        br.close();
    }    

    static public void bfs(int sx, int sy){
        Queue<int[]> cabbages = new LinkedList<>();
        cabbages.add(new int[]{sx, sy});
        visited[sx][sy] = true;
        while (!cabbages.isEmpty()) {
            int[] current = cabbages.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int n_x = x + directionX[i];
                int n_y = y + directionY[i];

                if (inRange(n_x, n_y) && field[n_x][n_y] && !visited[n_x][n_y]) {
                    cabbages.add(new int[]{n_x, n_y});
                    visited[n_x][n_y] = true;
                }
            }
        }
    }
    static public boolean inRange(int x, int y){
        return (x >= 0 && x < m && y >=0 && y < n);
    }
}

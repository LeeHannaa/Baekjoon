/*
[문제 요약]
토끼 왼쪽에는 늑대가 오기 때문에 토끼는 (r+1, c+1), (r, c+1), (r-1, c+1) 3가지의 방향으로만 움직일 수 있다.
'.'은 빈 공간을, '#'은 벽을, 'R'은 토끼를, 'C'는 당근을, 'O'는 정보섬 쪽문을 나타낸다.
토끼가 어떤 쪽문에 도착했을때 반드시 그 문으로 탈출할 필요는 없으며, 더 움직여서 다른 쪽문으로 탈출해도 된다. 
토끼가 정보섬을 빠져나가면서 얻을 수 있는 당근의 최대 개수를 출력한다. 정보섬에서 빠져나갈 수 없는 경우에는 -1을 출력한다.
*/
/*
[DP]
1. n과 m 입력받기
2. n번 반복하면서 각각의 길 상태 입력받기 (maze[])
3. 현재 토끼의 공간에서 다음으로 넘어가기 위한 것은 (x+1, y+1), (x+1, y-1), (x+1, y) 이렇게 이동 가능
    3-1. 다음 위치가 #거나, n*m 범위를 벗어난 경우 이동 불가능
    3-2. 다음 위치가 C인 경우 당근 획득 (carrot++)
    3-3. 다음 위치가 0인 경우 탈출 가능
        3-3-1. 탈출 진행 여부를 어떻게 판단할 것인가
            3-3-1-1. 재귀로 진행하면서 다음 경우에 탈출이 불가능하게 되는 경우는 이전 경우에 탈출하도록 설정
            3-3-1-2. 해당 단계를 넘어가면서 세방면 다 방문해보기
4. 당근 갯수 출력, 탈출 불가능 경우 -1 출력
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;

public class Baekjoon17130{
    static int n, m;
    static String maze[][]; // 미로 상황
    static int dp[][];  // 당근 dp
    static int[] directionX = {1, 1, 1}; // x 이동
    static int[] directionY = {-1, 0, 1}; // y 이동
 
    static int rx, ry; // 토끼 위치

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean pass = false;

        maze = new String[n][m];
        dp = new int[n][m];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = String.valueOf(s.charAt(j));
                if(maze[i][j].equals("R")){
                    rx = j;
                    ry = i;
                }
                if(!pass && maze[i][j].equals("O")) pass = true; // 탈출구가 없을 경우
            }
        }
        if(!pass) System.out.println("-1"); // 탈출구가 애초에 없을 경우
        else solve();

    }

    public static void solve(){
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        dp[ry][rx] = 0; // 토끼 위치

        // 세로 방향으로 탐색
        for(int i = rx; i < m; i++){ // x
            for(int j = 0; j < n; j++){ // y
                if(maze[j][i].equals("#")) continue; // 벽이라면 패스
                for(int k = 0; k < 3; k++){ // 방향 이동
                    int n_x = i - directionX[k]; // 이전 x 위치
                    int n_y = j - directionY[k]; // 이전 y 위치
                    if(isRange(n_x, n_y) && dp[n_y][n_x] != -1){ // 이전 경우가 범위 내면서 방문했을 경우
                        // 이전에 당근이 있었다면 현재 = max(이전 dp + 1) or (현재 dp)
                        if(maze[n_y][n_x].equals("C")) dp[j][i] = Math.max(dp[j][i], dp[n_y][n_x] + 1); 
                        // 이전에 당근이 없었다면 현재 = max(이전 dp) or (현재 dp)
                        else dp[j][i] = Math.max(dp[j][i], dp[n_y][n_x]);
                    }
                }
            }
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j].equals("O") && max < dp[i][j]) max = dp[i][j]; // 쪽문이 있을 경우 max 값 업데이트
            }
        }
        if(max >= 0) System.out.println(max);
        else System.out.println("-1");
        
    }

    public static boolean isRange(int x, int y){
        if(x >= 0 && y >= 0 && x < m && y < n) return true;
        else return false;
    }
}

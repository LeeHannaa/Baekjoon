/*
통제 할 수 없는 미친 로봇이 평면위에 있다. 그리고 이 로봇은 N번의 행동을 취할 것이다.
각 행동에서 로봇은 4개의 방향 중에 하나를 임의로 선택한다. 그리고 그 방향으로 한 칸 이동한다.
로봇이 같은 곳을 한 번보다 많이 이동하지 않을 때, 로봇의 이동 경로가 단순하다고 한다. (로봇이 시작하는 위치가 처음 방문한 곳이다.) 
로봇의 이동 경로가 단순할 확률을 구하는 프로그램을 작성하시오. 예를 들어, EENE와 ENW는 단순하지만, ENWS와 WWWWSNE는 단순하지 않다. (E는 동, W는 서, N은 북, S는 남)
=> 같은 곳을 방문하지 않고 N번동안 이동할 때의 확률을 구하는 것이다. 
=> 이동할 확률을 구하는 방법은 같은 공간을 방문하지 않고 이동하며, 이동할 때매다 이동할 방향의 확률을 곱해서 그 값을 모두 더해주면 된다.
*/
/*
1. k E W S N 입력받기
2. 
*/

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1405 {
    static int n;
    static double percent[];
    static boolean visited[][];
    static int d_x[] = {0,0,1,-1};
    static int d_y[] = {1,-1,0,0};
    static double solution;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        percent = new double[4];
        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < 4; i++) percent[i] = Integer.parseInt(st.nextToken()) * 0.01;
        
        

        visited = new boolean[30][30];
        solution = 0;

        dfs(15, 15, 0, 1);
        System.out.println(solution);       
        br.close();
    }
    public static void dfs(int x, int y, int c, double per){
        if(c == n) {
            solution += per;
            return;
        }
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + d_x[i];
            int ny = y + d_y[i];
            if(isRange(nx, ny)) {
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, c + 1, per * percent[i]);
                    visited[nx][ny] = false;
                }
            }
        }
    }
    public static boolean isRange(int x, int y){
        return (x >= 0 && y >= 0 && x < 30 && y < 30);
    }
}

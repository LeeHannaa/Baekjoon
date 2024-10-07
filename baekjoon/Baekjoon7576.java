/*
[입력]
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. 
M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M,N ≤ 1,000 이다. 
둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다. 
즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다. 
정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.

토마토가 하나 이상 있는 경우만 입력으로 주어진다.
[출력]
여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 
만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
*/
/*
0. boxs 내부에 0이 없다면 - 바로 다 익은 경우 0 출력
0-1. 익은 토마토는 바로 q에 넣기
1. queue꺼내기 (반복 - 현재 단계 q 사이즈 만큼)
2. 4방향 탐색
2-1. 조건
    2-1-1. visited[][] 미방문 && 범위가 m,n내 && boxs[][]가 -1이 아닌 경우 -> queue에 삽입
        2-1-1-1. boxs가 0인 경우 days ++
3-1. 모든 탐색 후 0이 없다면 days 출력
3-2. 0이 있다면 -1 출력
*/

import java.util.Scanner;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Baekjoon7576 {
    static int m,n;
    static boolean visited[][];
    static int boxs[][];
    static int dx[] = {0, 1, 0, -1}; // 위부터 시계
    static int dy[] = {-1, 0, 1, 0};
    static int days = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); //가로
        n = sc.nextInt(); //세로
        boxs = new int[n][m];
        visited = new boolean[n][m];
        boolean all = true;
        Queue<Tomato> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                boxs[i][j] = sc.nextInt();
                if(all && boxs[i][j] == 0) all = false;
                if(boxs[i][j] == 1){
                    q.add(new Tomato(j, i));
                    visited[i][j] = true;
                }
            }
        }

        if(all) System.out.println(0);
        else bfs(q);

        sc.close();
    }

    public static void bfs(Queue<Tomato> q){
        while(!q.isEmpty()){
            int size = q.size();
            boolean day_check = false;
            for (int s = 0; s < size; s++) {
                Tomato tomato = q.poll();
                for(int i = 0; i < 4; i++){
                    int nx = tomato.x + dx[i];
                    int ny = tomato.y + dy[i];
                    if(inRange(nx, ny) && !visited[ny][nx] && boxs[ny][nx] != -1) {
                        q.add(new Tomato(nx, ny));
                        visited[ny][nx] = true;
                        if(boxs[ny][nx] == 0) {
                            boxs[ny][nx] = 1;
                            day_check = true;
                        }
                    }
                }
            }
            if(day_check) days++;
        }
        
        boolean pass = Arrays.stream(boxs).flatMapToInt(Arrays::stream).anyMatch(value -> value == 0);
        if(pass) System.out.println(-1);
        else System.out.println(days);
    }

    public static boolean inRange(int x, int y){
        if(0 <= x && x < m && 0 <= y && y < n) return true;
        return false;
    }

    public static class Tomato{
        int x;
        int y;

        public Tomato(int x, int y){
            this.x = x;
            this.y = y;
        }
    } 
}

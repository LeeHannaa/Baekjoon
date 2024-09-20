/*
정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.

한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 

두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 
지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.
[입력]
여러개의 테스트 케이스
첫줄에는 w, h가 입력됨.
그 아래는 h만큼 1(땅), 0(바다)가 입력됨
[출력]
각 테스트케이스에 따라 섬의 개수를 구함
*/

/*
1. w h를 입력받기
2. h만큼 반복해서 섬의 구조를 입력받기 (1은 섬, 0은 바다) -> 섬 이동 경로는 가로, 세로, 대각이다.
3. 섬의 개수 구하기
    3-1. 현재 노드를 기준으로 상하좌우, 대각상하좌우를 비교해서 섬이 연결되어있으면 q에 추가
    3-2. q가 빌때까지 연결된 섬 확인
    3-3. q가 비었다면 섬의 개수 증가 후 다음 노드 탐색
        3-4. 
            1. 탐색 조건 -> 방문하지 않았던 노드 + 섬인 노드
            2. 현재 노드의 위치가 정사각형 내에 있는지
4. 0 0을 입력받을때까지 반복
*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Baekjoon4963 {
    static int w, h;
    static int arr[][]; //섬의 구조
    static int dirX[] = {0,0,-1,1,-1,1,-1,1}; // 상하좌우, 대각선상좌우, 대각선하좌우
    static int dirY[] = {-1,1,0,0,-1,-1,1,1}; // 상하좌우, 대각선상좌우, 대각선하좌우
    static boolean[][] visited;
    static int count;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        h = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(w!=0 && h!=0){
            count = 0;
            arr = new int[h][w];
            visited = new boolean[h][w];
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            bfs();
            sb.append(count + "\n");
            w = sc.nextInt();
            h = sc.nextInt();
        }
        System.out.print(sb);
        sc.close();
    }

    private static void bfs(){
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(arr[i][j] != 1 || visited[i][j]) continue;
                Queue<Node> q = new LinkedList<Node>();
                visited[i][j] = true;

                q.add(new Node(i,j));
                while(!q.isEmpty()){
                    Node now = q.poll();
                    for(int a = 0; a<8; a++){
                        int nx = dirX[a] + now.x;
                        int ny = dirY[a] + now.y;
                        if(nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
                        if(visited[ny][nx] || arr[ny][nx] != 1) continue;

                        visited[ny][nx] = true;
                        q.add(new Node(ny, nx));
                    }
                }
                count++;
            }
        }
    }

    static class Node {
		int y,x;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}

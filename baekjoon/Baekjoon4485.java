/*
1. n 입력받기 -> 0이면 종료
2. n*n 미로 입력받기
3. 미로의 시작부분 [0,0]에서 [n-1,n-1]까지 가는 최소 가치 구하기
[다익스트라 알고리즘 -  dp + 우선순위 큐]
    3-1. DP로 구현하면서 최단 거리 파악
4. 최단 거리 sb에 저장
5. 출력
*/

import java.io.*;
import java.util.*;

public class Baekjoon4485 {
    static int n;
    static int maze[][];
    static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(n>0){
            maze = new int[n][n];
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    maze[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 다익스트라 알고리즘 적용
            int cost = bfs();
            sb.append("Problem " + (index+1) + ": " + cost + "\n");
            n = Integer.parseInt(br.readLine());
            index++;
        }
        System.out.println(sb);
    }
    static int bfs() {
		Queue<Node> q = new PriorityQueue<>();
		int[][] dp = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		q.add(new Node(0, 0, maze[0][0]));
		dp[0][0] = maze[0][0];
		
		while(!q.isEmpty()) {
			Node pos = q.poll();
			int px = pos.x, py = pos.y;
			int cost = pos.cost;
			
			if(px == n-1 && py == n-1) {
				return cost;
			}
			
			for(int i=0; i<4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1) continue;
				
				if(cost+maze[ny][nx] < dp[ny][nx]) {
					dp[ny][nx] =cost+maze[ny][nx];
					q.add(new Node(nx,ny,cost+maze[ny][nx]));
				}
				
			}
		}
		return -1;
	}
    static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}

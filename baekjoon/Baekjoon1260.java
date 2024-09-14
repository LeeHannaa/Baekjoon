import java.util.Scanner;

/*
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
[입력]
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
[출력]
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
*/

/*
1. 정점개수 N, 간선개수 M, 탐색 시작 번호 V 입력 받기
2. M반복
2-1. 간선이 연결하는 정점의 두 번호 입력받아서 인접행렬에 저장
3. DFS 수행
3-1. 방문 했는지 check 배열 생성
3-2. V부터 시작해서 재귀함수로 N만큼 반복하면서 check하지 않고, 연결도 되어있는 정점의 숫자 저장
4. BFS 수행
4-1. V를 queue에 저장
4-2. check[v] 방문으로 변경
4-3. queue를 poll한 정점 주변에 연결된 정점 q에 담으면서 check 방문으로 변경
4-3. q를 poll하면서 q가 빈배열일때 까지 poll한 정점 주변에 이웃한 정점 있다면 q에 담는 작업 반복
5. 각 실행한 결과들 출력
*/
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Baekjoon1260 {
    static int N, M, V;
    static boolean[] check;
    static int[][] graph;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        graph = new int[N+1][N+1];
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            int f = sc.nextInt();
            int s = sc.nextInt();
            graph[f][s] = graph[s][f] = 1;
        }
        check = new boolean[N+1];
        dfs(V, sb);
        sb.append("\n");
        check = new boolean[N+1];
        bfs(V, sb);
        System.out.print(sb);
        sc.close();
    }

    private static void dfs(int start, StringBuilder sb){
        check[start] = true;
        sb.append(start + " ");
        
        for(int i = 1; i <= N; i++){
            if(graph[start][i] == 1 && !check[i]) dfs(i, sb);
        }
    }

    private static void bfs(int start, StringBuilder sb){
        q.add(start);
        check[start] = true;
        while(!q.isEmpty()){
            start = q.poll();
            sb.append(start + " ");
            for(int i = 1; i <= N; i++){
                if(!check[i] && graph[start][i] == 1){
                    q.add(i);
                    check[i] = true;
                }
            }
            
        }
    }
}

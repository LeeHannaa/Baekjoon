/*
신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 
1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 
하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 
컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
[입력]
첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 
이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
[출력]
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
*/

/*
1. 총 컴퓨터 수 N 입력받기
2. 연결된 컴퓨터 쌍의 수 C 입력받기
3. C번 반복하면서 서로 연결된 쌍 입력받기
3-1. 입력 받은 수를 인접 행렬에 넣어주기
4. 1과 연결된 부분의 dfs를 실행 (재귀) -> count 세기
5. count 출력
*/

import java.util.Scanner;

public class Baekjoon2606 {
    static int N;
    static int C;
    static int[][] graph;
    static int count = 0;
    static boolean[] check;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        graph = new int[N][N];
        check = new boolean[N];

        for(int i = 0; i < C; i++){
            int f = sc.nextInt();
            int s = sc.nextInt();
            graph[f-1][s-1] = graph[s-1][f-1] = 1;
        }
        dfs(1);
        System.out.println(count-1);
        sc.close();
    }

    private static void dfs(int start){
        check[start-1] = true;
        count++;

        for(int i = 0; i<N; i++){
            if(graph[start-1][i] == 1 && !check[i]) dfs(i+1);
        }

    }
    
}

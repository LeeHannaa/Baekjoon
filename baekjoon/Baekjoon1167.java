/*
트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.

*point*
dijkstra -> 시간 초과
가장 긴 지름을 만드는 노드 node1과 node2가 있다고 가정 / 임의의 노드 1개에서 가장 먼 노드는 node1 or node2.
가장 긴 지름에 참여하는 노드 1개를 구하고 나머지 하나의 노드를 구하면 node1과 node2를 둘 다 구할 수 있음
*/
/*
1. 트리의 정점 개수 V 입력받기
2. V반복동안 정점번호, 정점까지 거리 입력 받고 마지막은 -1
3. 임의의 노드에서 가장 먼 곳의 노드를 구해서 저장
4. 저장한 노드에서 또 제일 먼 곳의 노드를 구하기 -> max 저장
5. max 출력
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Baekjoon1167{
    static int v;
    static int max = 0;
    static ArrayList<Node>[] nodes;
    static boolean visited[];
    static int node;
    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        nodes = new ArrayList[v + 1]; 
        for(int i = 1; i <= v; i++) nodes[i] = new ArrayList<>();

        for(int i = 0; i < v; i++){
            int now = sc.nextInt();
            while(true){
                int e = sc.nextInt();
                if(e == -1) break;
                int cost = sc.nextInt();
                nodes[now].add(new Node(e, cost));
            }
        }

        visited = new boolean[v+1];
        dfs(1, 0);

        visited = new boolean[v+1];
        dfs(node, 0);

        System.out.println(max);
        
        sc.close();
    }

    public static void dfs(int n, int length){
        if(length > max){
            max = length;
            node = n;
        }
        visited[n] = true;
        for(int i = 0; i < nodes[n].size(); i++){
            Node no = nodes[n].get(i);
            if(!visited[no.e]){
                dfs(no.e, no.cost + length);
                visited[no.e] = true;
            }
        }
    }

    public static class Node{
        int e;
        int cost;

        public Node(int e, int cost){
            this.e = e;
            this.cost = cost;
        }
    }
}
/*
농부 현서는 농부 찬홍이에게 택배를 배달해줘야 합니다. 그리고 지금, 갈 준비를 하고 있습니다. 
평화롭게 가려면 가는 길에 만나는 모든 소들에게 맛있는 여물을 줘야 합니다. 물론 현서는 구두쇠라서 최소한의 소들을 만나면서 지나가고 싶습니다.
농부 현서에게는 지도가 있습니다.
N (1 <= N <= 50,000) 개의 헛간과, 소들의 길인 M (1 <= M <= 50,000) 개의 양방향 길이 그려져 있고, 각각의 길은 C_i (0 <= C_i <= 1,000) 마리의 소가 있습니다. 
소들의 길은 두 개의 떨어진 헛간인 A_i 와 B_i (1 <= A_i <= N; 1 <= B_i <= N; A_i != B_i)를 잇습니다. 
두 개의 헛간은 하나 이상의 길로 연결되어 있을 수도 있습니다. 농부 현서는 헛간 1에 있고 농부 찬홍이는 헛간 N에 있습니다.
*/

import java.util.*;
 
public class Baekjoon5972 {
    
    static int n, m;
    static int[] dist;
    static ArrayList<Node>[] list;
    static boolean[] visited;
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        n = scan.nextInt();
        m = scan.nextInt();
 
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            int cost = scan.nextInt();
            list[s].add(new Node(e, cost));
            list[e].add(new Node(s, cost));
        }
 
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, 50000001); //50000 * 1000 + 1
        dijkstra();
        System.out.println(dist[n]); //목적지는 n
        scan.close();
    }
 
    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[1] = 0; //시작 지점은 1
        q.offer(new Node(1, 0));
 
        while(!q.isEmpty()) {
            Node current = q.poll();
 
            if(!visited[current.d]) visited[current.d] = true;
            else continue;
 
            for(int i = 0; i < list[current.d].size(); i++) {
                Node next = list[current.d].get(i);
                if(dist[next.d] > dist[current.d] + next.cost) {
                    dist[next.d] = dist[current.d] + next.cost;
                    q.offer(new Node(next.d, dist[next.d]));
                }
            }
        }
       
    }
 
    public static class Node implements Comparable<Node> {
        int d;
        int cost;
 
        public Node(int d, int cost) {
            this.d = d;
            this.cost = cost;
        }
 
        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}
/*
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
*/
/*
[다익스트라]
1. n과 k 입력받기
2. count_list -1로 초기화
3. count = 0으로 시작
    3-1. 우선순위큐에 넣어서 하나씩 탐색 (다익스트라)
    3-2. 현재 위치에서 x-1, x+1로 가는 위치는 count_list에 현재 count + 1
    3-3. 현재 위치에서 x*2로 가는 위치는 count_list에 현재 count
    3-4. n이 k와 같아지면 중단
4. count 출력
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Baekjoon13549{
    static final int INF = 100000;
    static int n,k;
    static int count_list[];

    public static class Node implements Comparable<Node>{
        int x;
        int time;

        public Node(int x, int time){
            this.x = x;
            this.time = time;
        }

        public int compareTo(Node n) {
            return this.time - n.time;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        count_list = new int[INF+1];
        Arrays.fill(count_list, INF+1);

        int count = solve();

        System.out.println(count);

        br.close();

    }
    public static int solve(){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        count_list[n] = 0;
        queue.add(new Node(n,0));
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.x == k) return now.time;
            if(now.x-1 >= 0 && count_list[now.x-1] > now.time+1){
                count_list[now.x-1] = now.time+ 1;
                queue.add(new Node(now.x-1, now.time + 1));
            }
            if(now.x+1 <= 100000 && count_list[now.x+1] > now.time+1) {
                count_list[now.x+1] = now.time+ 1;
                queue.add(new Node(now.x+1, now.time + 1));
            }
            if(now.x*2 <= 100000 && count_list[now.x * 2] > now.time) {
                count_list[2*now.x] = now.time;
                queue.add(new Node(2*now.x, now.time));
            }
        }
        return -1;
    }

    
}

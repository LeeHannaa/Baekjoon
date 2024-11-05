/*
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
- 수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.
*/
/*
[BFS] - 가장 빨리 달성되는 경로를 파악해서 count 계산!
1. 수빈이의 위치와 동생의 위치를 입력받는다.
2. 100000칸의 배열을 만들어 방문 여부와 동시에 몇번째 이동된 부분인지 확인
    2-1. n과 k가 같아질 경우 stop
    2-2. n-1 >= 0 && 방문하지 않았다면 count증가, queue n-1 삽입
    2-2. n+1 <= 100000 && 방문하지 않았다면 count증가, queue n+1 삽입
    2-3. n*2 <= 100000 && 방문하지 않았다면 count증가, queue n*2 삽입
3. count 출력
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Beakjoon1697 {
    static int n;
    static int k;
    static int count_list[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        n = Integer.parseInt(input.nextToken());
        k = Integer.parseInt(input.nextToken());
        count_list = new int[100001];

        int count = check();

        System.out.println(count);
        br.close();
    }

    public static int check(){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        count_list[n] = 0;
        
        while(!queue.isEmpty()){
            n = queue.poll();
            if(n == k) return count_list[n];
            if (n-1>=0 && count_list[n-1] == 0)
			{
				count_list[n-1] = count_list[n]+1;
				queue.add(n-1);
			}
			if (n+1 <= 100000 && count_list[n+1] == 0)
			{
				count_list[n+1] = count_list[n]+1;
				queue.add(n+1);
			}
			if (2*n <= 100000 && count_list[2*n] == 0)
			{
				count_list[2*n] = count_list[n]+1;
				queue.add(2*n);
			}
        }
        return -1;
        
    }
    
}

/*
크리스마스에는 산타가 착한 아이들에게 선물을 나눠준다. 올해도 산타는 선물을 나눠주기 위해 많은 노력을 하고 있는데, 전세계를 돌아댕기며 착한 아이들에게 선물을 나눠줄 것이다. 
하지만 산타의 썰매는 그렇게 크지 않기 때문에, 세계 곳곳에 거점들을 세워 그 곳을 방문하며 선물을 충전해 나갈 것이다. 
또한, 착한 아이들을 만날 때마다 자신이 들고있는 가장 가치가 큰 선물 하나를 선물해 줄 것이다.
이제 산타가 선물을 나눠줄 것이다. 차례대로 방문한 아이들과 거점지의 정보들이 주어졌을 때, 아이들이 준 선물들의 가치들을 출력하시오. 
만약 아이들에게 줄 선물이 없다면 -1을 출력하시오.
*/
/*
1. n을 입력받기
2. n만큼 반복
    2-1. a 입력받기
        2-1-1. if(a>0) a개의 선물을 입력받기 
            2-1-1-1. priority queue에 저장하기 (내림차순)
        2-1-2. if(priority queue에 숫자가 있다면) st에 저장
        2-1-3. else st에 -1 저장
3. st 출력     
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Collections;

public class Baekjoon14235 {
    static int n;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a > 0){
                for(int j = 0; j < a; j++){
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
            else{
                if(pq.isEmpty()) sb.append("-1\n");
                else sb.append(pq.poll() + "\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}

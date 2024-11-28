/*
[다익스트라 (그리디) - 한 지점에서 특정 지점까지의 최단 경로]
[플로이드 워셜 (DP) - 모든 지점에서 다른 모든 지점까지의 최단 경로]
어느 회원이 다른 모든 회원과 친구이면, 이 회원의 점수는 1점이다. 어느 회원의 점수가 2점이면, 다른 모든 회원이 친구이거나 친구의 친구임을 말한다. 
또한 어느 회원의 점수가 3점이면, 다른 모든 회원이 친구이거나, 친구의 친구이거나, 친구의 친구의 친구임을 말한다.
4점, 5점 등은 같은 방법으로 정해진다. 각 회원의 점수를 정할 때 주의할 점은 어떤 두 회원이 친구사이이면서 동시에 친구의 친구사이이면, 이 두사람은 친구사이라고 본다.
회장은 회원들 중에서 점수가 가장 작은 사람이 된다. 회장의 점수와 회장이 될 수 있는 모든 사람을 찾는 프로그램을 작성하시오.
*/
/*
플로이드 워셜 - 각 지점을 돌아가면서 해당 지점을 거쳐 출발지에서 도착지로 이동할 수 있는 경로를 업데이트해가는 알고리즘
1. n 입력받기
2. friends INF로 초기화
3. 친구 관계를 입력받으면서 friends에 친구 관계 1로 표현
4. 플로이드 워셜 -> DPa,b = min(Dab, Dak + Dkb)
5. 친구 점수 나열하는 scores에 점수 저장
6. 점수 중 최저점 기준으로 sb에 담고 출력
[출력]
첫째 줄에는 회장 후보의 점수와 후보의 수를 출력하고, 두 번째 줄에는 회장 후보를 오름차순으로 모두 출력한다.
*/

import java.io.*;
import java.util.*;

public class Baekjoon2660 {
    static int INF = 1000;
    static int n;
    static int friends[][];
    static int scores[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        friends = new int[n+1][n+1];
        scores = new int[n+1];

        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                if(a!=b) friends[a][b] = INF;
            }
        }

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1) break;
            friends[a][b] = friends[b][a] = 1;
        }

        // 플로이드 워셜
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <= n; b++){
                    friends[a][b] = Math.min(friends[a][b], friends[a][k] + friends[k][b]);
                }
            }
        }

        int final_score = INF;
        for (int a = 1; a <= n; a++) {
            int score = 0;
            for (int b = 1; b <= n; b++) {
                if (friends[a][b] != INF) {
                    score = Math.max(score, friends[a][b]); // 친구의 친구 관계까지 고려해서 최대값 추출
                }
            }
 
            scores[a] = score;
            final_score = Math.min(final_score, score);
        }
       
        
        StringBuilder sb = new StringBuilder();
        StringBuilder candidates = new StringBuilder();
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(scores[i] == final_score){
                count++;
                candidates.append(i + " ");
            }
        }
        sb.append(final_score + " " + count + "\n");
        sb.append(candidates);

        System.out.println(sb);
    }
}

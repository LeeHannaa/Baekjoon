/*
이 문제는 아주 평범한 배낭에 관한 문제이다.
한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다. 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.
준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 
아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
[요약]
N개의 물건 -> 각 무게 W, 가치 V를 가짐 / 최대 K만큼의 무게를 넣을 가방 -> 가치의 최대값
*/
/*
[DP - 쪼갤 수 없는 짐 (0/1 Knapsack Problem)] vs Fraction Knapsack Problem 의 경우 탐욕 알고리즘(Greedy) -> 짐을 쪼갤 수 있는 경우
1. n과 k 입력받기 -> DP[n+1][k+1]
2. n 만큼 반복하면서 각 물건의 w v 입력받기 -> item[n+1][2] (weight, value)
3. 탐색 시작
    3-1. 이전 아이템의 가치 기준
    3-2. 각 무게에서 자신의 무게를 뺄 수 있는 경우
        3-2-1. 이전 아이템 가치 vs 남은 무게의 가치 + 현재 자신의 가치
4. 최댓값 출력
*/

import java.io.*;
import java.util.*;

public class Baekjoon12865 {
    static int dp[][];
    static int items[][];
    static int n, k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        items = new int[n+1][2];
        dp = new int[n+1][k+1];
        
        for(int i = 1; i <= n; i++){
            StringTokenizer item = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(item.nextToken()); // w
            items[i][1] = Integer.parseInt(item.nextToken()); // v
        }

        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= k; b++){
                dp[a][b] = dp[a-1][b];
                if(b - items[a][0] >= 0) dp[a][b] = Math.max(dp[a-1][b], dp[a-1][b - items[a][0]] + items[a][1]);
            }
        }

        System.out.println(dp[n][k]);

        br.close();
    }
    
}

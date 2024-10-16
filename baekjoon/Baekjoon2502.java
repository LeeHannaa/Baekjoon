/*
[문제 요약] 떡먹는 호랑이
호랑이는 어제 + 그저께 받은 떡의 개수만큼 더 받아야 할머니를 보내준다.
오늘은 몇개의 떡을 주었는지, 며칠이 되었는지를 입력받는데 D, K로 입력 받는다.
구해야 할 것은 처음 만난 날의 떡 개수 A와 그 다음 날 떡의 개수 B를 구해야한다.
*/
/*
1. D와 K를 입력받기
2. P1[n], P2[n]에 따른 각각의 피보나치 수열 정리
    2-1. D날의 떡개수 = K = (P1[n-1] + P1[n-2])A + (P2[n-1] + P2[n-2])B
    2-2. P1[0] = 0, P1[1] = 0, P1[2] = 1, P1[3] = 1, p1[4] = 1, p1[5] = 2....
    2-3. P2[0] = 0, P2[1] = 0, P2[2] = 1, P2[3] = 1, p1[4] = 2...
*/

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Baekjoon2502 {
    static int d, k;
    static int a = 0;
    static int b = 0;
    static int P[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        P = new int[d+1];
        P[1] = 0;
        P[2] = 1;

        for(int i = 3; i <= d; i++){
            P[i] = P[i-2] + P[i-1];
        }

        for(int i = 1; i <= k; i++){
            if((k - i*P[d-1]) % P[d] == 0){
                a = i;
                b = (k - (i*P[d-1])) / P[d];
                break;
            }
        }

        System.out.println(a);
        System.out.println(b);
    }
}

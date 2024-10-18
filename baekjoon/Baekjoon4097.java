/*
[입력]
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 N이 주어져 있다. (1 ≤ N ≤ 250,000) 
둘째 줄부터 N개의 줄에는 매일 매일의 수익 P가 주어진다. (-10,000 ≤ P ≤ 10,000) 
수익은 첫 날부터 순서대로 주어진다. 입력의 마지막 줄에는 0이 주어진다.
[출력]
각 테스트 케이스에 대해서 가장 많은 수익을 올린 구간의 수익을 출력한다. 단, 구간이 비어있으면 안 된다.
*/
/*
1. n 수 입력받기
2. n만큼 반복하면서 수익 입력받기
    2-1. 양수를 입력받는 순간을 기준으로 음수 다음 양수가 나오기 전까지 DP[]로 더해감
    2-2. 음수 다음으로 양수가 나오면 다시 그 시점부터 위와 동일하게 DP[]로 더해감
3. DP[]구간을 체크하면서 구간을 다 더하는 경우와 특정 구간을 선택하는 경우 중 더 높은 경우를 선택함.
4. maxResult를 출력함
*/

import java.util.Scanner;

public class Baekjoon4097 {
    static int n;
    static int DP[];

    public static void main(String[] args){
        int maxResult;
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        while(n > 0) {
            DP = new int[n];
            maxResult = -10001;
            int before = 0;
            boolean positive = false;
            for(int i = 0; i < n; i++){
                int now = sc.nextInt();
                if(!positive && now > 0) positive = true;
                if(positive){
                    if(i == 0) DP[i] = now;
                    else if(now > 0 && before < 0) {
                        if(DP[i-1] > 0) DP[i] =  DP[i-1] + now;
                        else DP[i] = now;
                    }
                    else DP[i] =  DP[i-1] + now;
                }
                else DP[i] = now;
                before = now;
            }
            for(int i = 0; i < n; i++) if(DP[i] > maxResult) maxResult = DP[i];
            sb.append(maxResult + "\n");
            n = sc.nextInt();
        }
    
        System.out.println(sb);
        sc.close();
    }
}

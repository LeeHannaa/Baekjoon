/*
피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
*/
/*
1. n 입력받기
2. F(0) = 0, F(1) = 1 기본 세팅
3. 재귀함수를 통해 F(n) = F(n-1) + F(n-2) 입력
4. P(n) 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2747 {
    static int n;
    static int[] F;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        F = new int[n + 1];
        F[0] = 0;
        F[1] = 1;

        for(int i = 2; i <= n; i++){
            F[i] = F[i-1] + F[i-2];
        }
        
        System.out.println(F[n]);
    }
}

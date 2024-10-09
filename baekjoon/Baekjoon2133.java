/*
3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.
*/
/*
1. n 입력 받기
2-1. n이 홀수이면 0 출력 후 종료
2-2. n이 짝수이면
        - DP배열 생성 후 DP[2] -> 3 (2 -> 2/2 : 몫으로 판단)
        - 식은 모든 경우 예외가 2개씩 발생 (서로 연결) -> DP[n] = (DP[n-2]*DP[2]) + (2*(DP[n-4] + ... + DP[2])) + 예외2
3. 출력
*/

import java.util.Scanner;

public class Baekjoon2133 {
    static int n;
    static int[]DP;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int range = n/2 + 1;
        if(n % 2 != 0) System.out.println(0);
        else{
            DP = new int[range];
            DP[1] = 3;
            for(int i = 2; i < range; i++){
                DP[i] = DP[i-1] * DP[1] + 2;
                for(int j = i - 2; j > 0; j--){
                    DP[i] += (DP[j] * 2);
                }
            }
            System.out.println(DP[range-1]);
        }
        sc.close();
    }
}

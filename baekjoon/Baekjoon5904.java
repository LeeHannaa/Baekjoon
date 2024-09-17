/*
Moo는 술자리에서 즐겁게 할 수 있는 게임이다. 이 게임은 Moo수열을 각 사람이 하나씩 순서대로 외치면 되는 게임이다.
Moo 수열은 길이가 무한대이며, 다음과 같이 생겼다. 

m o o m o o o m o o m o o o o m o o m o o o m o o m o o o o o 
Moo 수열은 다음과 같은 방법으로 재귀적으로 만들 수 있다. 먼저, S(0)을 길이가 3인 수열 "m o o"이라고 하자. 
1보다 크거나 같은 모든 k에 대해서, S(k)는 S(k-1)과 o가 k+2개인 수열 "m o ... o" 와 S(k-1)을 합쳐서 만들 수 있다.

S(0) = "m o o"
S(1) = "m o o m o o o m o o"
S(2) = "m o o m o o o m o o m o o o o m o o m o o o m o o"
위와 같은 식으로 만들면, 길이가 무한대인 문자열을 만들 수 있으며, 그 수열을 Moo 수열이라고 한다.

N이 주어졌을 때, Moo 수열의 N번째 글자를 구하는 프로그램을 작성하시오.
*/
/*
1. 몇번째 숫자를 출력할지 N 입력받기
2. N을 기준으로 Moo(N)의 총 길이 구하기
2-1. 기본 길이(total_len) = 3 [moo]
2.2 마지막 길이 (default_len) = 기본 길이와 동일 (default_len)
2-3. k(반복되는 배열 수)에 따라 늘어나는 기본 길이 = 2 * default_len + (1 + k + 2)
2-4. 총 길이와 현재 k를 통해 Moo 함수 실행
3. Moo 배열 내 N의 위치에 따른 알파벳 구하기
3-1. 총 길이에 따른 기본 길이 구하기(base_len) = (총길이 - (1+k+2))/2
3-2. k == 0 -> N이 1이면 m / 아니면 o
3-3. k가 0이 아니고 N이 base_len에 속하면
    3-3-1. Moo(base_len, k-1)
3-4. base_len <= N && N < base_len + (1+k+2)
    3-4-1. base_len + 1 == N -> m
    3-4-2. o
3-5. N >= base_len + (1+k+2)
    3-5-1. N = N - base_len - (1+k+2);
            Moo(N, k-1)
*/

import java.util.Scanner;

public class Baekjoon5904 {
    static int N;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        int total_len = 3;
        int k = 0;

        while(N > total_len){
            k++;
            total_len = total_len * 2 + (1 + k + 2);
        }
        Moo(total_len, k);
        sc.close();
    }

    private static void Moo(int total_len, int k){
        int base_len = (total_len - (1 + k + 2)) / 2;
        if(k==0){
            if(N == 1) System.out.println("m");
            else System.out.println("o");
            return;
        }
        else if(N < base_len) {
            Moo(base_len, k-1);
        }
        else if(base_len <= N && N <= base_len + (1 + 2 + k)){
            if(base_len + 1 == N) System.out.println("m");
            else System.out.println("o");
            return;
        }
        else if(N >= base_len + (1 + 2 + k)){
            N = N - (base_len + (1 + 2 + k));
            Moo(base_len, k-1);
        }
    }
    
}

/*
요즘 민규네 동네에서는 스타트링크에서 만든 PS카드를 모으는 것이 유행이다.
PS카드는 PS(Problem Solving)분야에서 유명한 사람들의 아이디와 얼굴이 적혀있는 카드이다. 각각의 카드에는 등급을 나타내는 색이 칠해져 있고, 다음과 같이 8가지가 있다.

카드는 카드팩의 형태로만 구매할 수 있고, 카드팩의 종류는 카드 1개가 포함된 카드팩, 카드 2개가 포함된 카드팩, ... 카드 N개가 포함된 카드팩과 같이 총 N가지가 존재한다.

카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값을 구하는 프로그램을 작성하시오. 
N개보다 많은 개수의 카드를 산 다음, 나머지 카드를 버려서 N개를 만드는 것은 불가능하다. 즉, 구매한 카드팩에 포함되어 있는 카드 개수의 합은 N과 같아야 한다.
[입력]
구매하려는 카드 개수 N
P1부터 Pn까지의 카드 팩 가격 (순서대로)
*/

/*
DP
1. 구매하려는 카드 개수 N 입력받기
2. N까지 반복하면서 카드팩 가격 입력받기
3. DP로 해결
3-1. i개의 카드를 구매하는 방법 -> 1개를 사고 i-1개의 카드를 산다, 2개를 사고 i-2개의 카드를 산다 .... i개를 산다.
3-2. 일반항 : Card[N] = Record[i] + Card[N-i];
*/

import java.util.Scanner;

public class Baekjoon11052 {
    
    public static void main(String[] args){
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int cards[] = new int[N+1];
        int records[] = new int[N+1];

        for(int i = 1; i <= N; i++) cards[i] = sc.nextInt();

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                records[i] = Math.max(records[i], cards[j] + records[i - j]); // records를 변경해가면서 최적의 값을 최종 records에 담기
            }
        }

        System.out.println(records[N]);


        sc.close();
    }

}

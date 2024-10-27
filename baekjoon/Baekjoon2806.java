/*
국내 생물학자들은 기존에 보지 못했던 신기한 DNA 분자를 발견했다. 이 분자는 A와 B로만 이루어진 N글자로 나타낼 수 있다. 
이 분자는 계속해서 돌연변이를 한 다음에, A로만 된 분자로 변한다.
어느 날, 이 분자를 연구하던 학자들은 두 종류의 돌연변이를 일으킨다는 사실을 알아내었다. 
첫 번째 돌연변이는 분자의 한 글자가 다른 글자로 바뀌는 것이다. (A -> B 또는 B -> A) 
두 번째 돌연변이는 첫 K개 글자를 모두 다른 글자로 바꾸는 것이다.
DNA 분자가 주어졌을 때, 돌연변이를 최소 몇 번 일으키면, 전부 A로 된 분자가 되는지 구하는 프로그램을 작성하시오.
*/
/*
[DP]
1. n 입력받기
2. n글자 입력받기 (String)
3. 최소일 수 계산
    3-1. i번째까지 모두 A로 만드는 최소 경우의 수
    3-2. i번째까지 모두 B로 만드는 최소 경우의 수
4. 최소일 출력
*/

import java.util.Scanner;

public class Baekjoon2806 {
    static int n;
    static String word;
    static int DP[][];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        word = sc.nextLine();

        DP = new int[2][n];
        if(word.charAt(0) == 'A') {
            DP[0][0] = 0;
            DP[1][0] = 1;
        } else{
            DP[0][0] = 1;
            DP[1][0] = 0;
        }

        for(int i = 1; i < n; i++){
            char dna = word.charAt(i);

            if(dna == 'A'){
                DP[0][i] = DP[0][i-1];
                DP[1][i] = Math.min(DP[1][i-1] + 1, DP[0][i] + 1);
            } else {
                DP[1][i] = DP[1][i-1];
                DP[0][i] = Math.min(DP[0][i-1] + 1, DP[1][i] + 1);
            }
        }

        int days = Math.min(DP[0][n-1], DP[1][n-1] + 1);
        System.out.println(days);

        sc.close();
    }
    
}

/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.
*/
/*
1. n과 m 입력 받기
2. 현재 위치와 담긴 수를 기점으로 dfs 구현
2-2. 담긴 수가 m개면 리스트 출력
*/

import java.util.Scanner;

public class Baekjoon15650 {
    static int n;
    static int m;
    static int list[];

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
 
		n = sc.nextInt();
		m = sc.nextInt();

        list = new int[m];
        dfs(1, 0);

        sc.close();

    }
    public static void dfs(int now, int depth) {
        if(depth == m) {
            for (int value : list) {
				System.out.print(value + " ");
			}
			System.out.println();
			return;
        }

		for (int i = now; i <= n; i++) {
			list[depth] = i;
			dfs(++i, ++depth);
            i--; depth--;
		}
    }
}

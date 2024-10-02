import java.util.Scanner;

/*
학생 N명이 미술 대회에 참가하였다. 이 대회에서는 주최자 한 명과 심판 한 명이 수상자를 결정하며, 수상자 결정 방식은 다음과 같다.
주최자와 심판이 각자 모든 학생들의 작품에 점수를 매긴다. 두 사람 모두 점수를 매길 때 서로 다른 두 작품에 같은 점수를 주지 않는다.
주최자가 M명의 학생을 골라 특별상을 수여한다.
심판은 특별상을 받지 않은 학생들이 그린 작품 중 자신이 매긴 점수가 가장 높은 K개의 작품을 추리고, 그에 해당하는 K명의 학생에게 본상을 수여한다.
주최자는 대회에서 종류와 상관 없이 상을 받는 학생들의 작품에 대해 자신이 매긴 점수의 합이 최대가 되도록 하려고 한다. 가능한 합의 최댓값을 구하여라.
*/
/*
1. n m k 입력받기
2. 심판의 점수를 기준으로 상위 k명을 선택 -> points에 합산
3. 나머지 기준으로 주최자 점수 기준으로 우선순위큐를 사용해 m명 선택 -> points에 합산
4. 출력
*/

import java.util.Scanner;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Baekjoon25391 {
    static int n, m, k;
    static Art arts[];
    static long points = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        arts = new Art[n];
        for(int i = 0; i < n; i++){
            int point1 = sc.nextInt();
            int point2 = sc.nextInt();
            arts[i] = new Art(point1, point2);
        }
        Arrays.sort(arts, (a1, a2) -> a2.k_point - a1.k_point);

        PriorityQueue<Integer> remain_arts = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            if(i < k) points += arts[i].m_point;
            else remain_arts.add(arts[i].m_point);
        }
        
        for (int i = 0; i < m; i++) {
            points += remain_arts.poll(); 
        }

        System.out.print(points);

        sc.close();
    }

    public static class Art{
        int m_point;
        int k_point;

        public Art(int m_point, int k_point){
            this.m_point = m_point;
            this.k_point = k_point;
        }
    }
}

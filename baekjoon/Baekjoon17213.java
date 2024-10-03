/*
민건이네 과일 농장은 N가지 종류의 과일을 재배하는 중이다. 평소 민건이에게 앙심을 품고 있던 지환이는 민건이를 골탕 먹이기 위하여 민건이네 과일 농장에서 과일들을 훔치기로 다짐했다. 
지환이는 완벽한 범죄를 위하여 처음 생각한 개수 만큼만 훔치려고 한다. 이때 지환이가 훔칠 수 있는 경우의 수가 몇가지나 될 지 알아보자. 단, 모든 종류의 과일을 적어도 1개는 훔친다.
*/
/*
1. n과 m입력 받기 (꼭 하나 이상 종류를 가져야함으로 m = 입력수 - n)
2. 중복 조합 문제
2-1. 
*/

import java.util.Scanner;

public class Baekjoon17213{
    static int n,m;
    static long total = 1;
    static long under = 1;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        m = Integer.parseInt(sc.nextLine());
        m = m - n;
        int r = m + n - 1;
        int h = n - 1;
        
        for(int i = 0; i < h ; i++){
            total *= (r - i);
            under *= (i + 1);
        }
        total = total / under;

        System.out.println(total);
        sc.close();
    }
}
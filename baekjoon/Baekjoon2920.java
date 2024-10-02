/*
다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.
1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
*/
/*
1. 8번 입력받기
1-1. 입력받으면서 오름차순 -> as...
1-2. 내림차순 -> de...
1-3. 둘 다 아니면 mixed
2. 출력
*/

import java.util.Scanner;

public class Baekjoon2920 {
    public static void main(String[] args){
        int check = 0;
        int last_num = 0;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 8; i++){
            int num = sc.nextInt();
            if(i != 0){
                if(last_num < num) check++;
                else if(last_num > num) check--;
            }
            last_num = num;
        }
        if(check == 7) System.out.print("ascending");
        else if(check == -7) System.out.print("descending");
        else System.out.print("mixed");
        
        sc.close();
    }
}

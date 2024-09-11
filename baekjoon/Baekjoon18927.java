/*
처음에 0이 하나 포함되어있는 배열 A가 있다. 이때, 다음 쿼리를 수행해야 한다.
1 x: A의 가장 뒤에 x를 추가한다.
2 x: A에서 x를 제거한다. A에 x가 두 개 이상 있는 경우에는 가장 앞에 있는 하나만 제거한다. 항상 A에 x가 있는 쿼리만 주어진다.
3: A에 포함된 모든 원소를 더한 값을 출력한다.
4: A에 포함된 모든 원소를 XOR한 값을 출력한다.
*/
/*
1. 0이 담긴 배열을 하나 준비한다.
2. 몇번의 쿼리를 수행할지 정수 M을 입력받기
3. 쿼리 1,2,3,4 중에 하나를 입력받고 1,2에 해당할 경우 해당 숫자 x 입력받기
4. 쿼리에 따라서 각각 실행
4-1. 1번 : 배열A에 x 추가
4-2. 2번 : 배열A에 x와 일치하는 제일 앞에 정수 제거
4-3. 3번 : 배열A에 모든 정수의 합 출력
4-4. 4번 : 배열A에 모든 정수 XOR 값 출력 (^)
*** 시간초과 문제점 -> 생각의 전환 ***
- 연산이 필요할 때 배열을 확인하는 것이 아닌 데이터 추가 or 삭제 시 바로바로 연산 실행
5. 반복이 끝나면 종료
*/

import java.util.Scanner;

public class Baekjoon18927{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Long sum = (long)0;
        Long xor = (long) 0;
        for(int i = 0; i < M; i++){
            int num = sc.nextInt();
            if(num == 1){
                long x = sc.nextLong();
                sum += x;
                xor = xor ^ x;
            }
            else if(num == 2){
                long x = sc.nextLong();
                sum -= x;
                xor = xor ^ x;
            }
            else if(num == 3){
                sb.append(sum  + "\n");
            }
            else if(num == 4){
                sb.append(xor + "\n");
            }
            else break;
        }
        System.out.print(sb.toString());

        sc.close();
    }
}
/*
최근 준하가 구입한 라디오는 매우 하이테크 한데, 그 라디오에는 다음과 같은 버튼이 있다.
첫 번째 버튼은 주파수를 1MHz 증가시킨다.
두 번째 버튼은 주파수를 1MHz 감소시킨다.
나머지 N개의 버튼은 즐겨찾기 기능으로, 미리 지정된 주파수로 이동한다.

현재 주파수 A와 듣고싶은 주파수 B가 주어질 때, 
주파수 A에서 B로 갈 때 눌러야 하는 가장 적은 버튼수를 구해주자.
*/
/*
1. 정수 A와 B 입력받기
2. 정수 N 입력받기
3. N 반복
    3-1. 미리 주어지는 주파수 입력받기
    3-2. 원하는 주파수인 B가 존재하는지 확인
        3-2-1. 존재한다면 반복문 빠져나와서 1을 출력 후 종료
    3-3. 존재하지 않는다면 min에 입력받은 주파수와 B의 주파수 차이를 저장 -> 최솟값
4. A와 B의 차이와 min과 비교하여 더 작은 것 파악
    4-1. A와 B의 차이가 더 작다면 -> 차이 출력 후 종료
    4-2. min이 더 작다면 -> min + (B-min) 값 출력 후 종료
*/

import java.util.Scanner;

public class Baekjoon3135 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        boolean pass = false;
        int min = 1001;

        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            if(num == b) pass = true;
            else{
                if(Math.abs(num-b) < min) min = Math.abs(num-b);
            }
        }
        if(a==b) System.out.println(0);
        else if(pass) System.out.println(1);
        else System.out.println(Math.min(Math.abs(a - b), min + 1));

        sc.close();
    }
}

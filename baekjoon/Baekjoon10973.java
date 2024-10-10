/*
1부터 N까지의 수로 이루어진 순열이 있다. 이때, 사전순으로 바로 이전에 오는 순열을 구하는 프로그램을 작성하시오.
사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다.
*/
/*
1. n 입력받기
2. 순열 입력받기
3-1. 입력받은 순열이 제일 처음이면 (오름차순과 일치) -> -1 출력
3-2. 아니면 이전 순열 출력
    3-2-1. 뒤에 숫자가 앞의 숫자보다 작은 경우 선택 (위치 변수는 최대값 s_point)
        3-2-1-1. 이에 해당할 때 해당 위치 이후에 선택된 배열 값보다 작은 경우 선택 (위치 변수는 최대값 m_point)
        3-2-1-2. 위치 이후 오름차순이 아니라면 s_p랑 m_p랑 교체
        3-2-1-3. s_p + 1 부터는 내림차순으로 뒤집음.
*/

import java.util.Scanner;

public class Baekjoon10973 {
    static int n;
    static int[] numbers;
    static int s_p = 0;
    static int m_p = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n];
        boolean first = true;
        
        for(int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
            if(i > 0 && numbers[i-1] > numbers[i]) {
                first = false;
                s_p = i-1;
            }
        }

        if(first) System.out.println(-1);
        else findBeforeArray();

        sc.close();
    }

    public static void findBeforeArray(){
        for(int i = s_p + 1; i < n; i++){
            if(numbers[s_p] > numbers[i]) m_p = i;
        }
        swap(s_p, m_p);
        int back = n - 1;
        int front = s_p + 1;
        while(front < back) {
            swap(front, back);
            front++;
            back--;
        }

        for(int i = 0; i < n; i++){
            System.out.print(numbers[i] + " ");
        }
    }

    public static void swap(int a, int b){
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}

/*
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 
정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
[입력]
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 
둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 
숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 
넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 
이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
[출력]
첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
*/
/*
1. 상근이가 가지고 있을 카드 숫자 N 입력받기
2. 상근이가 가지고 있는 카드 숫자 N개 반복으로 입력받기 (A배열)
3. 정수 M개의 카드를 지정할 숫자 M 입력받기
5. A배열 소팅하기
6. 정수 M개의 카드 숫자 M개 반복으로 입력받기 (B배열)
6-1. 입력받은 key값을 정렬된 A 배열에 lowerBound 값과 upperBound값의 인덱스를 구해 차를 stringbuilder에 저장
7. sb 출력하기
*/

import java.util.Scanner;
import java.util.Arrays;

public class Baekjoon10816{ 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int aList[] = new int[N];
        for(int i = 0; i < N; i++){
            aList[i] = sc.nextInt();
        }
        Arrays.sort(aList);
        
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            int key = sc.nextInt();
            sb.append(upperBound(aList, key)-lowerBound(aList, key) + " ");
        }
        System.out.println(sb);
        sc.close();
    }

    private static int lowerBound(int[] list, int key){
        int lower = 0;
        int higher = list.length;
        while(lower < higher){
            int mid = (lower + higher) / 2;
            if(key <= list[mid]) higher = mid;
            else lower = mid + 1;
        }
        return lower;
    }

    private static int upperBound(int[] list, int key){
        int lower = 0;
        int higher = list.length;
        while(lower < higher){
            int mid = (lower + higher) / 2;
            if(key < list[mid]) higher = mid;
            else lower = mid + 1;
        }
        return lower;
    }
}
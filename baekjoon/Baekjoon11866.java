/*
요세푸스 문제는 다음과 같다.
1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 
한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 
예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
*/

/*
1. N(총 인원)과 K(제거될 위치) 입력받기
2. Queue에 N까지의 숫자를 담기
2. Queue 길이가 1보다 클때까지 반복
2-1. Queue에서 K -1 번째까지 숫자들을 제일 뒤로 보내기
2-2. 반복이 끝나면 K번째 숫자를 객체에 담기
3. 길이가 1이면 해당 숫자 객체에 담고 > 추가
4. 담긴 숫자를 차례대로 보여주기
*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Baekjoon11866 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            queue.add(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        while(queue.size() > 1){
            for(int i = 0; i < K-1; i++){
                int num = queue.poll();
                queue.add(num);
            }
            stringBuilder.append(queue.poll()).append(", ");
        }
        stringBuilder.append(queue.poll()).append(">");
        System.out.println(stringBuilder);
    }
}
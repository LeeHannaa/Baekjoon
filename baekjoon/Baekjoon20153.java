/*
영웅이는 2의 거듭제곱을 좋아해서 A를 최대한 많은 항의 2의 거듭제곱의 합으로 표현한다. 표현된 2의 거듭제곱은 지수가 0 이상의 서로 다른 정수이다.
예를 들어 31은 5개의 항으로 표현된다. 우리는 이것을 영웅이의 표현법이라고 부를 것이다.
N개의 자연수 A1, A2, ..., AN이 주어진다. 이 중 최대 한 개의 자연수를 제거하고, 나머지를 영웅이의 표현법으로 나타내자.
그 후 각 정수 x에 대해 2x가 홀수 개 존재하면 2x를 더하고, 짝수 개 존재하면 더하지 않는다. 이렇게 했을 때 얻을 수 있는 최대 합을 2번 출력하라.
*/
/*
1. 각 자연수를 이진수로 변환
2. 2의 거듭제곱 카운트
3. 거듭제곱이 홀수 개일 경우 더하기
4. 자연수를 제거했을 때의 최대 합을 계산
5. 최대 합 두번 출력
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Baekjoon20153 {
    static int n;
    static int numbers[];
    static int twos[] = new int[22];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        numbers = new int[n];
        for(int i = 0; i < n; i ++){
            numbers[i] = Integer.parseInt(input[i]);
        }

        for (int num : numbers) {
            for (int i = 0; i < 22; i++) {
                if ((num & (1 << i)) != 0) {
                    twos[i]++;
                }
            }
        }

        int maxSum = calculateMaxSum();

        for (int num : numbers) {
            for (int i = 0; i < 22; i++) {
                if ((num & (1 << i)) != 0) {
                    twos[i]--;
                }
            }
            maxSum = Math.max(maxSum, calculateMaxSum());
            for (int i = 0; i < 22; i++) {
                if ((num & (1 << i)) != 0) {
                    twos[i]++;
                }
            }
        }
        System.out.print(maxSum);
        System.out.print(maxSum);
    }
    private static int calculateMaxSum() {
        int sum = 0;
        for (int i = 0; i < 22; i++) {
            if (twos[i] % 2 != 0) {
                sum += (1 << i);
            }
        }
        return sum;
    }
}

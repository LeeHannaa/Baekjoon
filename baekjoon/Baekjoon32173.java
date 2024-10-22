/*
[문제 요약]
1-N 번호표를 가지고 학생들이 줄을 선다.
1번 번호표는 1번에 서고 S1의 만족도를 가진다.
2번부터는 1. 줄의 맨 앞에 서서 Si의 만족도를 가진다. 2. 줄의 맨 뒤에 서서 만족도 0을 가진다.
i가 j보다 작을 때 j가 i 앞에 있다면 i는 새치기를 당했으므로 만족도가 -Si로 변경된다.
이때 학생의 만족도의 총합의 최댓값을 구할 것.
*/
/*
[그리디]
1. n 입력받기
2. 만족도 입력받아서 배열에 저장
    2-1. 기준으로 현재 Si - (list값) 만족도보다 (list값)이 높으면 제일 앞으로 이동 + 제일 앞이었던 만족도 -로 변경 
    2-2. 제일 앞에 만족도보다 낮으면 제일 뒤로 이동 -> 현재 만족도 0으로 변경 / i가 n-1이 아니면 누적값에 현재 만족도 -로 더해줌
3. 최종 만족도 출력
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon32173 {
    static int n;
    static long max = 0;
    static int defalut[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        defalut = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        long minus = 0;
        
        for(int i = 0; i < n; i++){
            defalut[i] = Integer.parseInt(st.nextToken());
            if(i == 0){
                minus = -defalut[i];
                max = defalut[i];
            }
            else {
                if(minus + defalut[i] < max) minus = minus - defalut[i];
                else {
                    max = defalut[i] + minus;
                    minus = minus - defalut[i];
                }
            }
        }
        System.out.println(max);
    }
    
}

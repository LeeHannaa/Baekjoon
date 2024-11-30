/*
가리송과 안드레송은 정산소에서 일하고 있고, 미래를 예측하고자 한다. 둘에게는 큰 n x n 정사각형이 주어진다. 처음에 각 배열의 원소 (x,y)는 x + y 로 채워져있다. (1 ≤ x, y ≤ n). 
미래 예측을 하는데에 두가지 타입의 쿼리가 들어온다.
“R r” ㅡ r행의 모든 값들을 합한 결과를 출력하고, r행을 모두 0으로 바꾼다.
“C c”ㅡ c열의 모든 값들을 합한 결과를 출력하고, c열을 모두 0으로 바꾼다.
쿼리 결과를 구하는 프로그램을 작성하시오.
*/
/*
1. n q (쿼리 개수) 입력받기
2. n * n 배열에 x+y 값을 각 입력으로 초기화
3. q 반복
    3-1. 쿼리 입력받기
    3-2. 쿼리에 따라 이행
        3-2-1. “R r” ㅡ r행의 모든 값들을 합한 결과 출력 + r행 0으로 변경 (가로 -> y축 숫자)
        3-2-2. “C c”ㅡ c열의 모든 값들을 합한 결과를 출력 + c열 0으로 변경 (세로 -> x축 숫자)
4. 쿼리 결과들 저장한 sb 출력
*/

import java.io.*;
import java.util.*;

public class Baekjoon11735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        // 초기 변수 설정
        int rcnt = 0; // 사용된 행의 개수
        int ccnt = 0; // 사용된 열의 개수
        long rdel = 0; // 사용된 행 번호의 합
        long cdel = 0; // 사용된 열 번호의 합
        long hap = (long) n * (n + 1) / 2; // [1..n]의 합
        
        // 방문 여부를 체크할 배열
        boolean[] vr = new boolean[n + 1]; // 행 방문 여부
        boolean[] vc = new boolean[n + 1]; // 열 방문 여부
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int index = Integer.parseInt(st.nextToken());
            
            if (type.equals("R")) {
                if (vr[index]) {
                    sb.append(0).append("\n"); // 이미 사용된 행은 0 출력
                } else {
                    vr[index] = true; // 방문 처리
                    long result = (n - ccnt) * (long) index + hap - cdel;
                    sb.append(result).append("\n");
                    rcnt++; // 사용된 행 개수 증가
                    rdel += index; // 사용된 행 번호의 합 증가
                }
            } else {
                if (vc[index]) {
                    sb.append(0).append("\n"); // 이미 사용된 열은 0 출력
                } else {
                    vc[index] = true; // 방문 처리
                    long result = (n - rcnt) * (long) index + hap - rdel;
                    sb.append(result).append("\n");
                    ccnt++; // 사용된 열 개수 증가
                    cdel += index; // 사용된 열 번호의 합 증가
                }
            }
        }
        
        System.out.print(sb); // 최종 결과 출력
    }
}

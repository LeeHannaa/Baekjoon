/*
자연수 n과 k가 있을 때 이항 계수 구하는 문제
*/
/*
1. n과 k 입력받기
2. 단순 계산 문제
*/

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11050 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int u_multiply = 1;
        int d_multiply = 1;
        for(int i = 0; i < k; i++){
            u_multiply *= (n-i);
            d_multiply *= (k-i);
        }
        int result = u_multiply / d_multiply;
        System.out.println(result);

        br.close();
    }
}

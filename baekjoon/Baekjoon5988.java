/*
짝이 없는 경재는 매일 홀로 있다보니 홀수를 판별할 수 있는 능력이 생겼다. 창식이는 경재의 말이 사실인지 그 능력을 시험해보려 한다. 
창식이의 의심이 끝이 없을 것 같아 N개만 확인하기로 정했다.
N개의 정수가 주어지면 홀수인지 짝수인지를 출력하는 프로그램을 만들어 경재의 능력을 검증할 수 있게 도와주자.
[출력]
N개의 줄에 걸쳐 한 줄씩 정수 K가 홀수라면 'odd'를, 짝수라면 'even'을 출력한다.
**** int - 10^9 / long - 10^18 / BigInteger
*/
/*
1. n 입력받기
2. n반복
    2-1. 입력받은 숫자가 2로 나누어진다면 sb에 even 저장
    2-2. 아니라면 sb에 odd 저장
3. sb 출력
*/

import java.io.*;
import java.math.BigInteger;
public class Baekjoon5988{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            BigInteger number = new BigInteger(br.readLine());
            if(number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) sb.append("even\n");
            else sb.append("odd\n");
        }
        System.out.println(sb);
    }

}
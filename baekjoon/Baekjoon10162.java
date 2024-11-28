/*
[문제 요약]
A - 5분, B - 1분, C - 10초
A,B,C를 적절히 눌러서 최소한의 터치로 T초를 맞춰야 함.
[출력]
A B C 누른 횟수 차례대로 출력 
*/
/*
1. A - 300초, B - 60초, C - 10초로 설정
2. T를 입력받은 후 A부터 최대한 많이 선택할 수 있는 만큼 선택하기
3. 횟수들 저장 후 출력
*/


import java.io.*;

public class Baekjoon10162 {
    static int t;
    static int aCount, bCount, cCount;
    static int a = 300;
    static int b = 60;
    static int c = 10;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        if(t % 10 != 0) System.out.println("-1");
        else{
            aCount = t / 300;
            t = t % 300;
            bCount = t / 60;
            t = t % 60;
            cCount = t / 10;
            t = t % 10;
            System.out.println(aCount + " " + bCount + " " + cCount);
        }
       
    }
}

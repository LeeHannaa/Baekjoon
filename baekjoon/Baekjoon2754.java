/*
어떤 사람의 C언어 성적이 주어졌을 때, 평점은 몇 점인지 출력하는 프로그램을 작성하시오.
A+: 4.3, A0: 4.0, A-: 3.7
B+: 3.3, B0: 3.0, B-: 2.7
C+: 2.3, C0: 2.0, C-: 1.7
D+: 1.3, D0: 1.0, D-: 0.7
F: 0.0
*/
/*
1. 성적 입력받기
2. 조건문에 따라 평점 나누기
3. 평점 출력
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baekjoon2754 {
    static double score;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String grade = br.readLine();

        if(grade.equals("A+")) score = 4.3;
        else if(grade.equals("A0")) score = 4.0;
        else if(grade.equals("A-")) score = 3.7;
        else if(grade.equals("B+")) score = 3.3;
        else if(grade.equals("B0")) score = 3.0;
        else if(grade.equals("B-")) score = 2.7;
        else if(grade.equals("C+")) score = 2.3;
        else if(grade.equals("C0")) score = 2.0;
        else if(grade.equals("C-")) score = 1.7;
        else if(grade.equals("D+")) score = 1.3;
        else if(grade.equals("D0")) score = 1.0;
        else if(grade.equals("D-")) score = 0.7;
        else score = 0.0;

        System.out.println(score);
    }

}

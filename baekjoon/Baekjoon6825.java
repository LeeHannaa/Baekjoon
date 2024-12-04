/*
다음 공식을 사용하여 BMI를 계산합니다
BMI = 체중/(신장 × 키).
환자의 키와 몸무게를 입력하고 BMI를 계산하며 아래 표에서 해당 메시지를 표시하는 프로그램을 작성합니다.
More than 25	Overweight
Between 18.5 and 25.0 (inclusive)	Normal weight
Less than 18.5	Underweight
*/

import java.io.*;

public class Baekjoon6825 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        float w = Float.parseFloat(br.readLine());
        float h = Float.parseFloat(br.readLine());
        
        float bmi = w / (h*h);

        if(bmi > 25) System.out.println("Overweight");
        else if(bmi <= 25 && bmi > 18.5) System.out.println("Normal weight");
        else System.out.println("Underweight");

        br.close();
    }
    
}

/*
꿍은 도비에게 영어단어들을 제시한 후 어떤 단어가 대소문자를 구분하지 않고 사전순으로 가장 앞서는지 맞추면 양말을 주어 자유를 얻게해준다고 하였다.
하지만 인성이 좋지 않은 꿍은 사실 그러고 싶지 않았기 때문에 대소문자를 마구 섞어가며 단어들을 제시했다. 예를 들어, apPle은 Bat보다 앞서지만 AnT보다는 뒤에 있는 단어다.
도비에게 희망은 여러분뿐이다! 여러분이 도비에게 자유를 선물해주도록 하자!
*/
/*
1. n개의 테스트케이스 입력받기 (0 입력 시 종료)
2. 입력받은 문자 소문자로 변경
3. min값을 설정하여 가장 앞서는 단어 확인 후 sb에 담기
4. sb 출력
*/

import java.util.Scanner;

public class Baekjoon2204{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        String word;
        String result = "";

        while(n > 0){
            result = sc.next();
            for(int i = 1; i < n; i++){
                word = sc.next();
                if(result.toLowerCase().compareTo(word.toLowerCase()) > 0) result = word;
            }
            sb.append(result + "\n");
            n = sc.nextInt();
        }
        System.out.print(sb);
        sc.close();
    } 
}
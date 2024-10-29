/*
세계적으로 유명한 엄지민 자동차 회사는 효율적인 킥다운 장치를 만들어달라는 의뢰를 받았다. 
킥다운이란 자동차에서 낮은 기어로 바꾸는 장치를 의미한다. 연구 끝에 효율적인 킥다운 장치는 '이'와 '홈'이 불규칙하게 배열되어 있는 기어로 만들어져야 한다는 것을 알았다.
첫 번째 그림과 같이 두 기어 파트가 서로 마주보고 있게 된다. 튀어나온 것이 기어의 이, 들어간 곳이 홈이다. 
그리고 이들을 두 번째 그림과 같이 서로 맞물리게 끼우는 것으로 킥다운 장치를 만들 수 있다. 
하지만 문제는 맞물리게 하였을 때 가로 너비가 짧을수록 효율적인 킥다운 장치가 된다. 때문에 문제는 두 기어가 주어졌을 때 맞물리게 하는 가장 짧은 가로 너비를 구하는 것이다.
*/
/*
1. part1 기아랑 part2 기아를 입력받는다.
2. part2를 part1의 오른쪽으로 이동시키며 겹칠 수 있는 경우를 검사
3. part1을 part2의 오른쪽으로 이동시키며 검사
    2,3-1.valid 변수를 통해 '2'가 겹치는 충돌이 없는지 확인 -> 최소 길이 갱신
5. 길이 출력
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baekjoon1195 {
    static String part1;
    static String part2;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        part1 = br.readLine();
        part2 = br.readLine();

        int minLength = part1.length() + part2.length();

        for (int i = 0; i <= part2.length(); i++) {
            boolean valid = true;
            for (int j = 0; j < part1.length() && j + i < part2.length(); j++) {
                if (part1.charAt(j) == '2' && part2.charAt(j + i) == '2') {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                minLength = Math.min(minLength, Math.max(part1.length() + i, part2.length()));
            }
        }

        for (int i = 0; i <= part1.length(); i++) {
            boolean valid = true;
            for (int j = 0; j < part2.length() && j + i < part1.length(); j++) {
                if (part2.charAt(j) == '2' && part1.charAt(j + i) == '2') {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                minLength = Math.min(minLength, Math.max(part2.length() + i, part1.length()));
            }
        }

        System.out.println(minLength);
        br.close();
    }
}

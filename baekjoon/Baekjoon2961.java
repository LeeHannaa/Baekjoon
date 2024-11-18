/*
여러 재료를 이용해서 요리할 때, 그 음식의 신맛은 사용한 재료의 신맛의 곱이고, 쓴맛은 합이다.
시거나 쓴 음식을 좋아하는 사람은 많지 않다. 도영이는 재료를 적절히 섞어서 요리의 신맛과 쓴맛의 차이를 작게 만들려고 한다.
또, 물을 요리라고 할 수는 없기 때문에, 재료는 적어도 하나 사용해야 한다.
재료의 신맛과 쓴맛이 주어졌을 때, 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램을 작성하시오.
*/
/*
1. 음식 재료 개수 n 입력받기
2. n 반복
    2-1. 신맛S 쓴맛B 입력받기
    2-2. 재료를 선택할 때 신맛은 곱, 쓴맛은 합
    2-3. 각 재료의 신맛 + 쓴맛의 최소값을 알아내야함
        2-3-1. 1~n까지 반복해서 조합으로 bruteforce 방법
        2-3-2. min으로 최소값 갱신
3. min 출력
*/

import java.util.*;
import java.io.*;
public class Baekjoon2961 {
    static int n;
    static Food foods[];
    static boolean selected[];
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        foods = new Food[n];
        selected = new boolean[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            foods[i] = new Food(s,b);
        }

        combination(0);
        System.out.println(min);

        br.close();
    }

    public static void combination(int count){
        if(count == n){
            min = Math.min(min, calculate());
            return;
        }

        selected[count] = true;
        combination(count+1);
        selected[count] = false;
        combination(count+1);
    }

    public static int calculate(){
        int s_multiply = 1;
        int b_sum = 0;
        for(int i = 0; i < n; i++){
            if(selected[i]){
                s_multiply *= foods[i].s;
                b_sum += foods[i].b;
            }
        }
        if(s_multiply == 1 && b_sum == 0) return Integer.MAX_VALUE;
        return Math.abs(s_multiply - b_sum);

    }

    static class Food{
        int s;
        int b;

        public Food(int s, int b){
            this.s = s;
            this.b = b;
        }
    }
}

/*
오늘은 공주님이 태어난 경사스러운 날이다. 왕은 이 날을 기념하기 위해 늘 꽃이 피어있는 작은 정원을 만들기로 결정했다.

총 N개의 꽃이 있는 데, 꽃은 모두 같은 해에 피어서 같은 해에 진다. 하나의 꽃은 피는 날과 지는 날이 정해져 있다. 
예를 들어, 5월 8일 피어서 6월 13일 지는 꽃은 5월 8일부터 6월 12일까지는 꽃이 피어 있고, 6월 13일을 포함하여 이후로는 꽃을 볼 수 없다는 의미이다. 
(올해는 4, 6, 9, 11월은 30일까지 있고, 1, 3, 5, 7, 8, 10, 12월은 31일까지 있으며, 2월은 28일까지만 있다.)

이러한 N개의 꽃들 중에서 다음의 두 조건을 만족하는 꽃들을 선택하고 싶다.

공주가 가장 좋아하는 계절인 3월 1일부터 11월 30일까지 매일 꽃이 한 가지 이상 피어 있도록 한다.
정원이 넓지 않으므로 정원에 심는 꽃들의 수를 가능한 적게 한다. 
N개의 꽃들 중에서 위의 두 조건을 만족하는, 즉 3월 1일부터 11월 30일까지 매일 꽃이 한 가지 이상 피어 있도록 꽃들을 선택할 때, 선택한 꽃들의 최소 개수를 출력하는 프로그램을 작성하시오. 
*/

/*
1. 총 꽃의 개수 N 입력 받기
2. N반복
2-1. 피는달 피는일 지는달 지는일 순으로 입력받기
3. 정렬하기
    3-1. 피는날은 빠른 날 기준으로 정렬
    3-2. 지는날은 느린 날 기준으로 정렬
4. 정렬된 순서를 기준으로 3/1일을 포함하는 제일 이전의 값을 기준으로 정렬된 순서대로 최선의 결과를 선택 (정렬 순서 자체가 최선의 선택을 할 수 있게 담아져 있음)
    4-1. 꽃을 담을 때마다 count++
5. 출력
    5-1. 다 담았고 처음과 끝의 꽃이 날짜 조건이 만족된다면 count 출력
    5-2. 만족하지 못한다면 0 출력
*/

import java.util.Scanner;
import java.util.Arrays;

public class Baekjoon2457 {
    static int N;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Flower[] flowers = new Flower[N];

        for(int i = 0; i < N; i++){
            int s_m = sc.nextInt();
            int s_d = sc.nextInt();
            int f_m = sc.nextInt();
            int f_d = sc.nextInt();
            flowers[i] = new Flower(s_m * 100 + s_d, f_m * 100 + f_d);
        }
        Arrays.sort(flowers);        

        int s_date = 301;
        int f_date = 1131;
        int count = 0;
        int last_date = 0;
        int index = 0;

        while(s_date < f_date){
            boolean pass = false;
            for(int i = index; i < N; i++){
                if(flowers[i].start > s_date) break;
                if(flowers[i].end > last_date) {
                    last_date = flowers[i].end;
                    index = i + 1;
                    pass = true;
                }
            }
            if(pass){
                s_date = last_date;
                count++;
            }
            else break;
        }
        if(last_date > f_date) System.out.println(count);
        else System.out.println(0);

        sc.close();
    }


    public static class Flower implements Comparable <Flower>{
        int start, end;

        public Flower(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower f){
            if(this.start != f.start){
                return this.start - f.start;
            } else {
                return f.end - this.end;
            }
        }
    } 
    
}

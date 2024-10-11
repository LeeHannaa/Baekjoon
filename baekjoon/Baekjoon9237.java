/*
농부 상근이는 마당에 심기 위한 나무 묘목 n개를 구입했다. 
묘목 하나를 심는데 걸리는 시간은 1일이고, 상근이는 각 묘목이 다 자라는데 며칠이 걸리는지 정확하게 알고 있다.
상근이는 마을 이장님을 초대해 자신이 심은 나무를 자랑하려고 한다. 
이장님을 실망시키면 안되기 때문에, 모든 나무가 완전히 자란 이후에 이장님을 초대하려고 한다. 즉, 마지막 나무가 다 자란 다음날 이장님을 초대할 것이다.
상근이는 나무를 심는 순서를 신중하게 골라 이장님을 최대한 빨리 초대하려고 한다. 이장님을 며칠에 초대할 수 있을까?
*/
/*
1. 나무 개수 n 입력 받기
2. n만큼 반복하면서 pq에 넣기
3. pq대로 파악하기
    3-1. if(해당 순서 + 이전수 > 해당 순서 + 현재수) 그 다음 경우 보지 않고 현재까지의 최대 날짜 +1이 이장님 초대 일
4. 이장님 초대일 출력
*/

// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.IOException;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;

public class Baekjoon9237 {
    static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            pq.add(sc.nextInt());
        }
        int day = 0;
        int nowDay = 0;
        for(int i = 1; i <= n; i++){
            nowDay = pq.poll() + i;
            if(day < nowDay) day = nowDay;
        }
        System.out.println(day + 1);

        sc.close();
    }
}

/*
영우는 개구리다 개굴개굴개굴
영우는 지금 n개의 돌이 일렬로 놓여있는 돌다리에 있다. 그리고 돌다리의 돌에는 숫자가 하나씩 적혀있다. 
영우는 이 숫자가 적혀있는 만큼 왼쪽이나 오른쪽으로 점프할 수 있는데, 이때 돌다리 밖으로 나갈 수는 없다.

영우는 이 돌다리에서 자기가 방문 가능한 돌들의 개수를 알고 싶어한다. 
방문 가능하다는 것은 현재위치에서 다른 돌을 적절히 밟아 해당하는 위치로 이동이 가능하다는 뜻이다.

현재 위치가 주어졌을 때, 영우가 방문 가능한 돌들의 개수를 출력하시오.
*/
/*
1. 돌다리 N의 개수 입력받기
2. N만큼 반복해서 돌에 적힌 숫자들 입력받기
3. 출발점 S입력받기
4. DFS를 통해서 구현
    4-1. visited[] || s 위치에 따라 함수 실행 여부 판단
    4-2. 범위 내 s가 위치 시 stones[s] + s, s- stones[s]를 다시 dfs로 호출
5. 밟을 수 있는 돌 출력
*/

import java.util.Scanner;

public class Baekjoon14248 {
    static int count = 0;
    static int[] stones;
    static boolean[] visited;
    static int N;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N+1];
        stones = new int[N+1];

        for(int i = 1; i <= N; i++){
            stones[i] = sc.nextInt();
        }
        int s = sc.nextInt();
        dfs(s);
        System.out.println(count);
        sc.close();
    }
    
    public static void dfs(int s){
        if(s > N || s < 1 || visited[s]) return;
        int front = s + stones[s];
        int back = s - stones[s];
        count++;
        visited[s] = true;
        dfs(front);
        dfs(back);
    }
}

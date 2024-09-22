/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
*/
/*
백트래킹
1. N과 M 입력받기
2. 방문여부변수[N], 하나의 배열 리스트변수[M], 백트래킹 포인트 체크-> 깊이 변수 depth 생성
3. dfs 실행
    3-1. depth == M : 배열리스트변수 sb에 저장 후 리턴
    3-2. N번의 반복을 통해 -> 현재 방문하지 않았다면 : 방문표시 -> 배열[depth]에 현재 수 담기 -> dfs(depth늘려서)
        3-2-1. 그 이후 다음 노드를 확인하기 위해 부모 노드 미방문 표시
4. sb 출력
*/

import java.util.Scanner;

public class Baekjoon15649 {
    static int N, M;
    static boolean visitied[];
    static int arr[];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visitied = new boolean[N];
        arr = new int[M];

        dfs(0);

        System.out.println(sb);
        sc.close();
    } 

    public static void dfs(int depth){
        if(depth == M){
            for(int i = 0; i < M; i++) sb.append(arr[i] + " ");
            sb.append("\n");
            return;
        }
        for(int i = 0; i<N; i++){
            if(!visitied[i]){
                visitied[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                visitied[i] = false;
            }
        }
    }
}

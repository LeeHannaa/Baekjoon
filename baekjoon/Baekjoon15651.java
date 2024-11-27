/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
*/
/*
[중복 가능한 수열]
1. n과 m 입력받기
2. dfs
*/


import java.io.*;
import java.util.*;

public class Baekjoon15651 {
    static int n,m;
    static int result[];
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // 한 줄에 보일 숫자
        result = new int[m];
        dfs(0);
		System.out.println(sb);

        br.close();
    }

    public static void dfs(int depth) {
        if(depth == m){
            for (int i = 0; i < m; i++) {
				sb.append(result[i]).append(' ');
			}
			sb.append('\n');
			return;
        }
        for(int i = 1; i <= n; i++){
            result[depth] = i;
            dfs(depth + 1);
        }
    }
}

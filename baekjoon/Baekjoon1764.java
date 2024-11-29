/*
김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
*/
/*
1. 듣도 못한 n 보도 못한 m 입력받기
2. n까지 듣도 못한 사람 명단 받기
3. m까지 보도 못한 사람 명단 받기
    3-1. n에서 나온 사람 이름과 동일하다면 정답 리스트에 넣기
4. 정답리스트 출력
*/

import java.io.*;
import java.util.*;

public class Baekjoon1764 {
    static int n,m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        Set<String> nlist = new HashSet<>();
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            nlist.add(br.readLine());
        }
        List<String> result = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < m; i++){
            String mName = br.readLine();
            if(nlist.contains(mName)){
                count ++;
                result.add(mName);
            }
        }
        Collections.sort(result);

        System.out.println(count);
        for (String name : result) {
            System.out.println(name);
        }

        br.close();
    }
}

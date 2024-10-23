/*
김탑은 TV를 사러 인터넷 쇼핑몰에 들어갔다. 쇼핑을 하던 중에, TV의 크기는 그 TV의 대각선의 길이로 나타낸 다는 것을 알았다. 
하지만, 김탑은 대각선의 길이가 같다고 해도, 실제 TV의 크기는 다를 수도 있다는 사실에 직접 TV를 보러갈걸 왜 인터넷 쇼핑을 대각선의 길이만 보고있는지 후회하고 있었다.
인터넷 쇼핑몰 관리자에게 이메일을 보내서 실제 높이와 실제 너비를 보내달라고 했지만, 관리자는 실제 높이와 실제 너비를 보내지 않고 그것의 비율을 보내왔다.
TV의 대각선 길이와, 높이 너비의 비율이 주어졌을 때, 실제 높이와 너비의 길이를 출력하는 프로그램을 작성하시오.
*/
/*
피타고라스 정의로 대각선 비 구하기
1. 대각선 길이 * 높이 비 / 대각선 비 = 높이
2. 대각선 길이 * 너비 비 / 대각선 비 = 너비
3. 높이와 너비 출력
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon1297 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int h_ratio = Integer.parseInt(st.nextToken());
        int w_ratio = Integer.parseInt(st.nextToken());

        double d_ratio =  Math.sqrt(h_ratio*h_ratio + w_ratio*w_ratio);

        int h = (int) Math.floor(d * h_ratio / d_ratio);
        int w = (int) Math.floor(d * w_ratio / d_ratio);

        System.out.print(h + " " + w);
    }
    
}

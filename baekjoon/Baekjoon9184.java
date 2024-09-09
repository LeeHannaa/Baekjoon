/*
재귀 호출만 생각하면 신이 난다! 아닌가요?
다음과 같은 재귀함수 w(a, b, c)가 있다.
if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns: 1
if a > 20 or b > 20 or c > 20, then w(a, b, c) returns: w(20, 20, 20)
if a < b and b < c, then w(a, b, c) returns: w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
otherwise it returns: w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
위의 함수를 구현하는 것은 매우 쉽다. 하지만, 그대로 구현하면 값을 구하는데 매우 오랜 시간이 걸린다. (예를 들면, a=15, b=15, c=15)
a, b, c가 주어졌을 때, w(a, b, c)를 출력하는 프로그램을 작성하시오.
[입력]
입력은 세 정수 a, b, c로 이루어져 있으며, 한 줄에 하나씩 주어진다. 입력의 마지막은 -1 -1 -1로 나타내며, 세 정수가 모두 -1인 경우는 입력의 마지막을 제외하면 없다.
[출력]
입력으로 주어진 각각의 a, b, c에 대해서, w(a, b, c)를 출력한다.
*/
/*
*DP*
: 메모리를 사용해(배열 혹은 자료 구조를 만든다) 중복 연산을 줄이고(연산한 결과를 배열에 담는다) 중복 연산을 줄여서 수행 속도를 개선한다.
[기준]
1. DFS, BFS로 해결할 수 있지만 경우의 수가 너무 많은 경우
2. 경우의 수들에 중복 연산이 많은 경우
*메모이제이션(Memoization)*
이미 연산한 내용에 대해 중복 연산을 수행하지 않도록!!
*/

import java.util.Scanner;


public class Baekjoon9184 {
    static int [][][] memoization = new int[21][21][21];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int result;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        do{
            if(a == -1 && b == -1  && c == -1) break;
            else result = w(a,b,c);
            if (i == 0) {
                sb.append("w(" + a + ", " +  b + ", " + c + ") = " + result);
                i++;
            }
            else sb.append("\n" + "w(" + a + ", " +  b + ", " + c + ") = " + result);
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
        }while(a!= -1 || b!= -1  || c!= -1);
        System.out.println(sb);
        sc.close();
    }

    public static int w(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) return w(20,20,20);
        else if(memoization[a][b][c] != 0 ) return memoization[a][b][c];
        else if (a < b && b < c) {
            memoization[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return memoization[a][b][c];
        }
        else {
            memoization[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
            return memoization[a][b][c];
        }
    }
    
}

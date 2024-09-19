/*
각각 부피가 A, B, C(1≤A, B, C≤200) 리터인 세 개의 물통이 있다. 
처음에는 앞의 두 물통은 비어 있고, 세 번째 물통은 가득(C 리터) 차 있다. 

이제 어떤 물통에 들어있는 물을 다른 물통으로 쏟아 부을 수 있는데, 이때에는 한 물통이 비거나, 다른 한 물통이 가득 찰 때까지 물을 부을 수 있다. 
이 과정에서 손실되는 물은 없다고 가정한다.

이와 같은 과정을 거치다보면 세 번째 물통(용량이 C인)에 담겨있는 물의 양이 변할 수도 있다. 
첫 번째 물통(용량이 A인)이 비어 있을 때, 세 번째 물통(용량이 C인)에 담겨있을 수 있는 물의 양을 모두 구해내는 프로그램을 작성하시오.
*/

/*
A가 비었을 때 C 물통에 담길 수 있는 물의 양 BFS로 확인
1. 물통 A, B, C의 용량을 입력받기
2. 물을 붓는 경우
2-1. 한 물통이 비는 경우 (주는 물통이 비는 경우) -> A = A + B; B = 0; (B->A로 물을 이동)
2-2. 다른 한 물통이 가득 차는 경우 (받는 물통이 가득 차는 경우) -> B = B - (A' - A); A = A'(풀용량); (B->A로 물을 이동)
2-3. A->B, A->C, B->A, B->C, C->A, C->B 6가지 상황 체크 후 조건에 만족하면 해당 상황을 겪었다고 상태변수에 표시
*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class Baekjoon2251{
    static int A, B, C;
    static ArrayList<Integer> answer;
    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        answer = new ArrayList<>();
        
        bfs();
        Collections.sort(answer);
        for(int i = 0; i<answer.size(); i++) System.out.print(answer.get(i) + " ");
        
        sc.close();
    }

    static public void bfs(){
        Queue<Bottle> q = new LinkedList<>();
        boolean visited[][][] = new boolean [A+1][B+1][C+1];
        q.add(new Bottle(0,0,C));

        while(!q.isEmpty()){
            Bottle now = q.poll();
            if(visited[now.A][now.B][now.C]) continue;
            if(now.A == 0) answer.add(now.C);
            visited[now.A][now.B][now.C] = true;

            if(now.A + now.B >= B){ //A->B 일때 B가 꽉 찬 경우
                q.add(new Bottle(now.A - (B-now.B), B, now.C));
            }else{// A->B 일때 A가 비는 경우
                q.add(new Bottle(0,now.A + now.B, now.C));
            }
            if(now.A + now.C >= C){ //A->C 일때 C가 꽉 찬 경우
                q.add(new Bottle(now.A - (C-now.C), now.B, C));
            }else{// A->C 일때 A가 비는 경우
                q.add(new Bottle(0,now.B, now.A + now.C));
            }

            if(now.B + now.A >= A){ //B->A 일때 A가 꽉 찬 경우
                q.add(new Bottle(A, now.B - (A-now.A), now.C));
            }else{// B->A 일때 B가 비는 경우
                q.add(new Bottle(now.A + now.B, 0, now.C));
            }
            if(now.B + now.C >= C){ //B->C 일때 C가 꽉 찬 경우
                q.add(new Bottle(now.A, now.B - (C-now.C), C));
            }else{// B->C 일때 B가 비는 경우
                q.add(new Bottle(now.A, 0, now.B + now.C));
            }

            if(now.C + now.A >= A){ //C->A 일때 A가 꽉 찬 경우
                q.add(new Bottle(A, now.B, now.C - (A-now.A)));
            }else{// C->A 일때 C가 비는 경우
                q.add(new Bottle(now.A + now.C, now.B, 0));
            }
            if(now.C + now.B >= B){ //C->B 일때 B가 꽉 찬 경우
                q.add(new Bottle(now.A, B, now.C - (B-now.B)));
            }else{// C->B 일때 C가 비는 경우
                q.add(new Bottle(now.A, now.B + now.C, 0));
            }
        }

    }

    public static class Bottle{
        int A, B, C;

        public Bottle(int A, int B, int C){
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }
}
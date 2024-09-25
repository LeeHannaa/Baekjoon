/*
총 25명의 여학생들로 이루어진 여학생반은 5×5의 정사각형 격자 형태로 자리가 배치되었고, 얼마 지나지 않아 이다솜과 임도연이라는 두 학생이 두각을 나타내며 다른 학생들을 휘어잡기 시작했다. 
곧 모든 여학생이 ‘이다솜파’와 ‘임도연파’의 두 파로 갈라지게 되었으며, 얼마 지나지 않아 ‘임도연파’가 세력을 확장시키며 ‘이다솜파’를 위협하기 시작했다.

위기의식을 느낀 ‘이다솜파’의 학생들은 과감히 현재의 체제를 포기하고, ‘소문난 칠공주’를 결성하는 것이 유일한 생존 수단임을 깨달았다. ‘소문난 칠공주’는 다음과 같은 규칙을 만족해야 한다.

이름이 이름인 만큼, 7명의 여학생들로 구성되어야 한다.
강한 결속력을 위해, 7명의 자리는 서로 가로나 세로로 반드시 인접해 있어야 한다.
화합과 번영을 위해, 반드시 ‘이다솜파’의 학생들로만 구성될 필요는 없다.
그러나 생존을 위해, ‘이다솜파’가 반드시 우위를 점해야 한다. 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다.
여학생반의 자리 배치도가 주어졌을 때, ‘소문난 칠공주’를 결성할 수 있는 모든 경우의 수를 구하는 프로그램을 작성하시오.
*/
/*
1. 자리배치 변수 seats[][]에 자리 구성 입력받기
2. 조합으로 25명중에 7명 선택 과정
    2-1. if(7명 되었는지 확인 변수 check) 
        2-1-1. if(S수 확인 변수 s_count가 4이상) 서로 연결되었는지 확인 함수
    2-2. 현재 index에서 25까지 반복 (i)
        2-2-1. if(현재 방문 여부 변수 visitied[]) pass
        2-2-2. if(현재 seats[]에 S가 앉아있다면) 2번 반복(현재 i+1, check++, s_count++)
        2-2-3. else 2번 반복(현재 i+1, check++, s_count)
3. 서로 연결되어있는지 확인 함수
    3-1. 현재 선택된 자리 변수 selected[]들이 서로 연결되었는지 확인 (BFS)
4. count 출력
*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Baekjoon1941{
    static int count = 0;
    static int check = 0;
    static char seats[];
    static boolean selected[];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        seats = new char[25];
        selected = new boolean[25];
        for(int i = 0; i < 5; i++){
            String line = sc.nextLine();
            for(int j = 0; j < 5; j++) seats[i*5 + j] = line.charAt(j);
        }
        combination(0,0,0);

        System.out.println(count);
        
        sc.close();
    }

    public static void combination(int index, int check, int s_count){
        if(check == 7){
            if(s_count >= 4) {
                connection(index-1);
            }
            return;
        }
        for(int i = index; i < 25; i++){
            selected[i] = true;
            if(seats[i] == 'S') combination(i+1, check+1, s_count+1);
            else combination(i+1, check+1, s_count);
            selected[i] = false;
        }
    }

    public static void connection(int index){
        Queue<Seat> q = new LinkedList<>();
        boolean[] visited = new boolean[25];
        int x = index / 5;
        int y = index % 5;
        q.add(new Seat(x, y));
        visited[index] = true;
        int line = 1;
        while(!q.isEmpty()){
            Seat now = q.poll();
            for(int i = 0; i < 4; i++){
                int ndx = now.x + dx[i];
                int ndy = now.y + dy[i];
                int check_index = ndx * 5 + ndy;
                if(inRange(ndx, ndy) && !visited[check_index] && selected[check_index]){
                    line++;
                    visited[check_index] = true;
                    q.offer(new Seat(ndx, ndy));
                }
            }
        }
        if(line == 7) count++;
        return;
    }

    public static boolean inRange(int x, int y){
        if(x >= 0 && y >=0 && x < 5 && y < 5) return true;
        return false;
    }

    static class Seat{
        int x;
        int y;

        public Seat(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
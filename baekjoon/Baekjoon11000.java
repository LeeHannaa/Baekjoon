/*
수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다. 
김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다. 
참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)
수강신청 대충한 게 찔리면, 선생님을 도와드리자!
*/
/*
1. n 입력받고 n개의 강의 시간 입력받기
2. 각 수업의 시작은 빠르게 끝나는 시간은 느리게 해서 sorting
3. ClassRoom (시작, 끝, 몇번째 classroom인지)을 생성하면서 범위 안에 들어가지 않는 수업이 있다면 새로운 ClassRoom 생성 (우선순위큐)
    3-1. 새로운 수업이 들어오기 위해서는 기존 수업 끝시간 삭제 -> 새로운 수업 넣기
4. ClassRoom 개수 출력
*/

import java.io.*;
import java.util.*;

public class Baekjoon11000 {
    
    static int n;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(s, t);
        }
        
        Arrays.sort(lectures);
        
        PriorityQueue<Integer> classRooms = new PriorityQueue<>();
        Lecture first = lectures[0];
        classRooms.add(first.end);
        for (int i = 1; i < n; i++) {
            if (lectures[i].start >= classRooms.peek()) {
                classRooms.poll();
            }
            classRooms.add(lectures[i].end);
        }

        System.out.println(classRooms.size());
        br.close();
    }  

    public static class Lecture implements Comparable<Lecture>{
        int start;
        int end;
        
        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Lecture l){
            if(this.start != l.start) return this.start - l.start;
            else return l.end - this.end;
        }
    }
}


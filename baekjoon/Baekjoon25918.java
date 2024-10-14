/*
[문제 요약]
북극곰은 O,X를 보면 (), )(로 찢는다.
협이는 밤에 O와 X를 놔두면, 낮에 북극곰이 찢어버린다.
이때 원하는 문자열을 만들기 위해 걸리는 최소 일 수를 구하여라.
*/
/*
1. 괄호 수 n 입력받기
2. 원하는 문자열인 괄호 입력받기 - String text;
3. stack에 text[0] 넣기
3. text - 1 만큼 반복
    3-1. if (!stack.empty() && stack.pop == "(" && text[i] == ")" || stack.pop == ")" && text[i] == "(") stack.pop
    3-2. else stack.push(text[i])
    3-3. 현재 스택 크기와 최대 크기 비교
4. stack에 남은 문자가 있다면 -1, 아니면 최소 일 수 출력
*/

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon25918 {
    public static void main(String[] args){
        int days = 0;
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String texts = sc.nextLine();

        for(char word : texts.toCharArray()){
            if(!stack.isEmpty() && (stack.peek() == '(' && word == ')' || stack.peek() == ')' && word == '(')) stack.pop();
            else stack.push(word);

            days = Math.max(stack.size(), days);
        }

        if(!stack.isEmpty()) System.out.println("-1");
        else System.out.println(days);

        sc.close();
    }
}

// peek : 제일 위에 있는 element 반환
// count : stack의 element 개수 반환
// push(item), pop
// isEmpty

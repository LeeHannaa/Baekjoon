import java.util.Scanner;

/*
이진 검색 트리는 다음과 같은 세 가지 조건을 만족하는 이진 트리이다.

노드의 왼쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 작다.
노드의 오른쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 크다.
왼쪽, 오른쪽 서브트리도 이진 검색 트리이다.

전위 순회 (루트-왼쪽-오른쪽)은 루트를 방문하고, 왼쪽 서브트리, 오른쪽 서브 트리를 순서대로 방문하면서 노드의 키를 출력한다. 
후위 순회 (왼쪽-오른쪽-루트)는 왼쪽 서브트리, 오른쪽 서브트리, 루트 노드 순서대로 키를 출력한다. 
예를 들어, 위의 이진 검색 트리의 전위 순회 결과는 50 30 24 5 28 45 98 52 60 이고, 후위 순회 결과는 5 28 24 45 30 60 52 98 50 이다.

이진 검색 트리를 전위 순회한 결과가 주어졌을 때, 이 트리를 후위 순회한 결과를 구하는 프로그램을 작성하시오. 
*/
/*
1. node 클래스 생성
1-1. variable, left, right
2. 전위 순회로 변수 값을 입력받고 노드 생성
2-1. 이전 변수보다 현재 입력 받은 변수가 작으면 left에 추가
2-2. 이전 변수보다 현재 입력 받은 변수가 크면 right에 추가
3. 후위순회 실행
3-1. left 먼저 수행 -> 출력
3-2. right 수행 -> 출력
3-3. 마지막으로 루트 출력
*/

import java.util.Scanner;

public class Baekjoon5639 {
    static class Node{
        int variable;
        Node left, right;

        Node(int variable){
            this.variable = variable;
        }

        void insert(int variable){
            if(variable < this.variable){
                if(this.left == null) this.left = new Node(variable);
                else this.left.insert(variable);
            }
            else if(variable > this.variable){
                if(this.right == null) this.right = new Node(variable);
                else this.right.insert(variable);
            }
        }

    } 

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String r = sc.nextLine().trim();
        Node root = new Node(Integer.parseInt(r));
        while(sc.hasNextLine()){
            String input = sc.nextLine().trim();
            if(input.isEmpty()) break;
            root.insert(Integer.parseInt(input));
        }
        postOrder(root);

        sc.close();
    }

    public static void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.variable);
    }
    
}

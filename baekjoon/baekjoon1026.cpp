/*
옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
S = A[0] × B[0] + ... + A[N-1] × B[N-1]
S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
S의 최솟값을 출력하는 프로그램을 작성하시오.
*/

/*
그리디 알고리즘 (각 단계에서 최적이라고 생각하는 것을 선택)
1. N과 배열 A, B를 입력받기
2. A를 내림차순, B를 오름차순으로 정렬 후 곱하기
- B의 수가 제일 큰 것과 A의 수가 제일 작은 것 매칭
*/

#include <iostream>
#include <algorithm>
using namespace std;

bool compare (int a, int b) {
    return a > b;
}
int main(){
    int number;
    cin >> number;
    int A[number];
    int B[number];
    for (int i = 0; i < number; i++){
        cin >> A[i];
    }
    for (int i = 0; i < number; i++){
        cin >> B[i];
    }
    
    sort(A, A + number, compare);
    sort(B, B + number);

    int result = 0;
    for(int i = 0; i<number; i++){
        result += A[i]*B[i];
    }
    cout << result << endl;

    return 0;
}
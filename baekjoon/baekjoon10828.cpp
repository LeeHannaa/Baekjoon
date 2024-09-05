/*
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
명령은 총 다섯 가지이다.
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/
/*
1. 명령의 수 입력받기
2. array 배열로 stack 개발 진행
3. 포인터를 중심으로 push, pop, top 결정
4. 각 명령어에 따라 진행
*/

#include<iostream>
#include <vector>

using namespace std;

int main(){
    int number;
    cin >> number;
    vector<int> stackArray(10000);
    int index = -1;
    vector<int> resultArray(number);
    int re_index = 0;
    
    for(int i = 0; i < number; i++){
        string input;
        cin >> input;
        if(input == "push") {
            int input_num;
            cin >> input_num;
            stackArray[++index] = input_num;
        }
        else if(input == "pop") {
            if(index == -1) resultArray[re_index++] = -1;
            else {
                resultArray[re_index++] = stackArray[index];
                index--;
            }
        }
        else if(input == "size") {
            if(index == -1) resultArray[re_index++] = 0;
            else resultArray[re_index++] = index + 1;
        }
        else if(input == "empty") {
            if(index == -1) resultArray[re_index++] = 1;
            else resultArray[re_index++] = 0;
        }
        else if(input == "top") {
            if(index == -1) resultArray[re_index++] = -1;
            else resultArray[re_index++] = stackArray[index];
        }
        else {
            cout << "error" << endl;
        }
    }
    for(int i = 0; i < re_index; i++){
        cout << resultArray[i] << endl;
    }
}
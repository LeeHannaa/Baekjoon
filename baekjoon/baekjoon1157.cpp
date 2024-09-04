/*
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
[출력]
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
*/
/*
아스키코드 : 대문자 65~90
1. 단어를 입력받기
2. 대문자로 통일시키기
3. 알파벳을 담는 배열 생성
4. 입력 받은 단어별로 해당 배열 순서에 알파벳 숫자 증가
5. 최대 숫자가 있는 값을 max로 저장
5-1. max가 동일한게 두개 이상이면 ? 출력
5-2. 아니면 max에 해당하는 인덱스의 알파벳 출력
*/

#include<iostream>
#include <string> 

using namespace std;
int main(){
    string word;
    cin >> word;
    int alpha[26] = {0};

    for(int i = 0; i < word.length(); i ++){
        word[i] = toupper(word[i]);
        alpha[word[i] - 65]++;
    }

    int max = 0;
    int index = -1;
    for(int i = 0; i < 26; i++){
        if(max < alpha[i]) {
            max = alpha[i];
            index = i;
        }
    }
    
    int count = 0;
    for(int i = 0; i < 26; i++){
        if(max == alpha[i]) count++;
    }
    if(count > 1) cout << "?" << endl;
    else cout << char(index + 65) << endl;

    return 0;
}
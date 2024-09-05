/*
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 
예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
*/
/*
아스키코드 소문자 : 97 ~ 122
1. 단어의 수를 입력받기
2. 입력받은 수만큼 단어 입력받기
2-1. 해당 단어에 앞에서 나온 알파벳이 다른 알파벳이 나온 이후 다시 나오는 경우 -> count No
2-2. 해당 단어에 앞에서 나온 알파벳이 다른 알파벳이 나온 이후 다시 나오지 않는 경우 (연속) -> count++
3. count 출력하기
*/

#include<iostream>
#include<string.h>

using namespace std;

int main(){
    int number;
    cin >> number;
    int count = 0;
    for(int i = 0; i < number; i++){
        string word;
        int alpha[26] = {0};
        bool no_word = false;
        cin >> word;
        for(int j = 0; j < word.length(); j++){
            if((j != 0) && (alpha[word[j] - 97] > 0) && (word[j-1] != word[j])) no_word = true;
            else alpha[word[j] - 97] ++;
        }
        if(!no_word) count++;
        
    }
    cout << count << endl;

    return 0;
}
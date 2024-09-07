/*
가이우스 율리우스 카이사르(Gaius Julius Caesar)는 고대 로마 군인이자 정치가였다. 
카이사르는 비밀스럽게 편지를 쓸 때, 'A'를 'D로', 'B'를 'E'로, 'C'를 'F'로... 이런 식으로 알파벳 문자를 3개씩 건너뛰어 적었다고 한다.
26개의 대문자 알파벳으로 이루어진 단어를 카이사르 암호 형식으로 3문자를 옮겨 겹치지 않게 나열하여 얻은 카이사르 단어가 있다. 이 카이사르 단어를 원래 단어로 돌려놓는 프로그램을 작성하시오.
각 문자별로 변환 전과 변환 후를 나타낸 건 아래와 같다.

변환전    A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 
변환후    D E F G H I J K L M N O P Q R S T U V W X Y Z A B C

예를 들어서, 이 방법대로 단어 'JOI'를 카이사르 단어 형식으로 변환한다면 'MRL'을 얻을 수 있고, 앞의 예와 같은 방법으로 얻은 카이사르 단어 'FURDWLD'를 원래 단어로 고치면 'CROATIA'가 된다.
*/
/*
1. 단어 입력받기
2. 입력받은 단어 기준으로 3개를 건너뛰어 알바펫 지정하기 (아스키코드 대문자 65~90)
3. 90이상이 되면 65 + 현재 단어 아스키코드 + 4 - 90으로 진행
*/

#include <iostream>

using namespace std;

int main(){
    string word;
    cin >> word;
    string result = word;

    for(int i = 0; i < word.length(); i++){
        if(word[i] - 3 >= 65 && word[i] - 3 <= 90) result[i] = char(word[i] - 3);
        else result[i] = char(word[i] - 3 + 26);
    }

    cout << result << endl;

}
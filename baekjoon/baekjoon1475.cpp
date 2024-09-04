/*다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.
다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 
다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
*/
/*
1. 0-8를 담은 배열 basic 생성 (9는 6과 동일)
2. 6과 9는 같은 숫자로 보고 해당 숫자가 반복해서 나올 경우를 확인하기 위한 flag 변수 생성
3-1. 6과 9가 아닌 경우
- basic에 해당 숫자 배열 수 증가
3-2. 6과 9인 경우
- 한번 나온 경우 (패스, flag : true)
- 두번 나온 경우 (해당 숫자 배열 수 증가, flag : false)
4. basic에서 최대값을 가진 수를 필요한 세트의 개수로 판단 (flag가 최종적으로 true이면 +1, 아니면 pass)
*/

#include <iostream> 
#include <string> 
using namespace std;

int basic[9] = {0};
int main() {
    int number;
    int count = 0;
    cin >> number;

    string toNumber = to_string(number);
    bool check = false; 
    if(0 > number || number > 1000000) cout << "error number" << endl;
    else {
        for(int i = 0; i < toNumber.size(); i++){
            int point = number % 10;
            if(point != 6 && point != 9) basic[point]++;
            else{
                if(check) { //두번째 6또는 9
                    basic[6]++;
                    check = false;
                }
                else check = true;
            }
            number /= 10;
        }
    }
    if(check) basic[6]++;

    int max = 0;
    for(int i = 0; i < 9; i++){
        if(max < basic[i]) max = basic[i];
    }
    cout << max << endl;
    return 0;
}
/*
지은이가 건국한 나라인 유애나에 살고 있는 재현이는 너무 단순한 나머지 매일이 기분이 좋은 날, 기분이 싫은 날 두가지로 나누어진다. 
어느 날 지은이는 재현이에 대한 놀라운 사실을 발견했다! 재현이의 오늘의 기분이 내일의 기분에 영향을 준다는 것이었다. 
문득 지은이는 N일 뒤의 재현이의 기분이 어떻게 될지 궁금하였다. 지은이를 위해 N일 뒤 재현이의 기분이 어떨지 알려주는 프로그램을 만들어보자.
[입력]
첫째 줄에 정수 N(1 ≤ N ≤ 100)과 현재 재현이의 기분(좋은 날 0, 싫은 날 1)이 주어진다.
둘째 줄에 차례대로 재현이가 기분이 좋은 날의 다음 날도 기분이 좋은 날일 확률, 다음 날은 기분이 싫은 날일 확률, 
기분이 싫은 날의 다음 날이 기분이 좋은 날일 확률, 다음 날도 기분이 싫은 날일 확률이 주어진다. 확률은 소수점 둘째자리까지 주어진다.
[예시]
2 1
0.70 0.30 0.50 0.50
0 -> 0 : 0.70
0 -> 1 : 0.30
1 -> 0 : 0.50
1 -> 1 : 0.50
[출력]
N일 뒤의 재현이의 기분이 좋은 날일 확률과 싫은 날일 확률에 1,000을 곱해 소수점 첫째자리에서 반올림한 수를 차례대로 출력한다. 절대 오차는 100까지 허용한다.
*/
/*
1. N일과 현재 기분이 좋은지(0) 싫은지(1)를 입력 받기
2. 기분에 따른 확률 입력받기
3. 확률 계산 (확률을 배열에 담고)
- 좋음 = 전날 좋음 * 계속 좋음 + 전날 나쁨 * 좋음
- 나쁨 = 전날 나쁨 * 계속 나쁨 + 전날 좋음 * 나쁨
*/

#include<iostream>
#include<math.h>
using namespace std;
int main(){
    int feeling;
    int days;
    double probability[4];
    cin >> days >> feeling;

    for(int i = 0; i < 4; i++) {
        cin >> probability[i];
    }

    double preH[days], preS[days];
    if(feeling == 0) {
        preH[0] = probability[0];
        preS[0] = probability[1];
    }
    else {
        preH[0] = probability[2];
        preS[0] = probability[3];
    }
    for(int i = 1; i < days; i++){
        preH[i] = preH[i-1] * probability[0] + preS[i-1] * probability[2];
        preS[i] = preH[i-1] * probability[1] + preS[i-1] * probability[3] ;
    }

    preH[days-1] = preH[days-1] * 1000;
    preS[days-1] = preS[days-1] * 1000;

    cout << round(preH[days-1]) << endl << round(preS[days-1]) << endl;
}
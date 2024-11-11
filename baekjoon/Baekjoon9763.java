/*
세 마을의 좌표가 (x1, y1, z1), (x2, y2, z2), (x3, y3, z3)이라고 가정해보자. 이때, 세 마을을 친밀도는 아래와 같이 구할 수 있다.
친밀도 = d12 + d23 (dij = |xi - xj| + |yi - yj| + |zi - zj|)
마을이 주어졌을 때, 가장 작은 세 마을의 친밀도를 구하는 프로그램을 작성하시오.
*/
/*
[BruteForce]
1. 마을 수 n 입력받기
2. 두개의 마을을 선택
    2-1. 두 마을의 거리 구하기
    2-2. 최소 거리 두개를 선택하는데 마을의 거리가 최소 거리에 해당하면 변경
    2-3. 새로운 최소거리와 기존 최소거리 비교 후 업데이트
3. 최소거리 출력
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baekjoon9763 {
    static int n;
    static City[] cities;
    static int min_distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cities = new City[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer location = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(location.nextToken());
            int y = Integer.parseInt(location.nextToken());
            int z = Integer.parseInt(location.nextToken());
            cities[i] = new City(x, y, z);
        }

        min_distance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int result1 = Integer.MAX_VALUE;
            int result2 = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int distance = distance(cities[i], cities[j]);
                    if (distance < result1) {
                        result2 = result1;
                        result1 = distance;
                    } else if (distance < result2) {
                        result2 = distance;
                    }
                }
            }

            min_distance = Math.min(min_distance, result1 + result2);
        }

        System.out.println(min_distance);
    }

    public static int distance(City c1, City c2) {
        return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y) + Math.abs(c1.z - c2.z);
    }

    static class City {
        int x, y, z;

        public City(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}

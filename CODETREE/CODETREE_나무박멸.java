package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CODETREE_나무박멸 {

    static int n, m, k, c;
    static int[][] map, subMap;
    static List<Kill> killList;
    static int answer = 0;


    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        input();

        for (int t = 0; t < m; t++) {

            //제초제 제거
            delete();


            subMapClear();

            //나무가 있는 칸의 수만큼 나무가 성장한다.
            step1();

            step2();


            //서브맵 복사
            mapCopy();

            killList = new ArrayList<>();


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] <= 0) continue;
                    bfs(i, j);
                }
            }

            if (killList.isEmpty()) continue;

            Collections.sort(killList);

            killBfs(killList.get(0));

        }

        System.out.println(answer);
    }

    private static void subMapClear() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(subMap[i], 0);
        }
    }


    private static void delete() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] < -1) {
                    if (map[i][j] == -2) {
                        map[i][j] = 0;
                        continue;
                    }
                    map[i][j]++;
                }
            }
        }
    }

    private static void killBfs(Kill kill) {
        int row = kill.row;
        int col = kill.col;

        map[row][col] = -2 - c;


        int drow, dcol;
        for (int d = 0; d < 4; d++) {
            for (int i = 1; i <= k; i++) {
                drow = (fr[d] * i) + row;
                dcol = (fc[d] * i) + col;

                //범위를 벗어나면 break;
                if (drow < 0 || drow >= n || dcol < 0 || dcol >= n) break;

                //벽돌이면 break;
                if (map[drow][dcol] == -1) break;

                if (map[drow][dcol] == 0){
                    map[drow][dcol] = -2 -c;
                    break;
                }

                //제초제이면 map[drow][dcol] = -2 -c 적용하고 break;
                if (map[drow][dcol] < -1) {
                    map[drow][dcol] = -2 - c;
                    break;
                }

                //아니면 map[drow][dcol] = -2 -c 적용하고 계속
                map[drow][dcol] = -2 - c;
            }
        }

        answer += kill.total;
    }

    static int[] fr = {1, 1, -1, -1};
    static int[] fc = {1, -1, 1, -1};

    static class Kill implements Comparable<Kill> {
        int row, col;
        int total;

        public Kill(int row, int col, int total) {
            this.row = row;
            this.col = col;
            this.total = total;
        }

        @Override
        public int compareTo(Kill o) {

            if (this.total == o.total) {

                if (this.row == o.row) {

                    return Integer.compare(this.col, o.col);
                }

                return Integer.compare(this.row, o.row);
            }

            return -Integer.compare(this.total, o.total);
        }
    }

    private static void bfs(int row, int col) {
        int total = 0;

        total = total + map[row][col];

        int drow, dcol;
        for (int d = 0; d < 4; d++) {
            for (int i = 1; i <= k; i++) {
                drow = row + fr[d] * i;
                dcol = col + fc[d] * i;

                //범위 벗어나면 for break;
                if (drow < 0 || drow >= n || dcol < 0 || dcol >= n) break;

                //나무가 없거나 제초제이면 break;
                if (map[drow][dcol] <= 0) break;

                //아니면 total에 더 해준다
                total += map[drow][dcol];
            }
        }

        killList.add(new Kill(row, col, total));

    }

    private static void mapCopy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] += subMap[i][j];
            }
        }
    }

    private static void step2() {
        int drow, dcol;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= 0) continue;

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    drow = i + dr[d];
                    dcol = j + dc[d];

                    if (drow < 0 || drow >= n || dcol < 0 || dcol >= n) continue;
                    //아무것도 없지 않으면 건너뜀
                    if (map[drow][dcol] != 0) continue;
                    cnt++;
                }

                if (cnt == 0) continue;

                for (int d = 0; d < 4; d++) {
                    drow = i + dr[d];
                    dcol = j + dc[d];

                    if (drow < 0 || drow >= n || dcol < 0 || dcol >= n) continue;
                    if (map[drow][dcol] != 0) continue;
                    subMap[drow][dcol] += (map[i][j] / cnt);
                }

            }
        }
    }

    private static void step1() {
        int drow, dcol;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //나무가 없으면 건너뜀
                if (map[i][j] <= 0) continue;

                int cnt = 0;

                for (int d = 0; d < 4; d++) {
                    drow = dr[d] + i;
                    dcol = dc[d] + j;

                    if (drow < 0 || drow >= n || dcol < 0 || dcol >= n) continue;

                    // 나무가 없는 칸 건너 뜀
                    if (map[drow][dcol] <= 0) continue;
                    cnt++;
                }

                map[i][j] = map[i][j] + cnt;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        k = Integer.parseInt(in[2]);
        c = Integer.parseInt(in[3]);

        map = new int[n][n];
        subMap = new int[n][n];

        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(in[j]);
            }
        }
    }
}

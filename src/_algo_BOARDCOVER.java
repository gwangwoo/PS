import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _algo_BOARDCOVER {
    private static final int[][][] NEXT_GRID = { // 4 3 2
            {{0, 0}, {0, 1}, {1, 1}}, // ㄱ
            {{0, 0}, {1, 0}, {1, 1}}, // ㄴ
            {{0, 0}, {0, 1}, {1, 0}}, // reverse ㄱ
            {{0, 0}, {1, 0}, {1, -1}}  // reverse ㄴ
    };
    private static char[][] map;
    private static int N, M, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            int count = 0;
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '.') {
                        count++;
                    }
                }
            }
            if (count % 3 != 0) {   // 3의 배수가 아니면 답이 될 수 없음.
                System.out.println(0);
                continue;
            }

            int answer = cover();
            System.out.println(answer);
        }

    }
    static int cover() {
        int y = -1, x = -1;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (map[i][j] == '.') {
                    y = i;
                    x = j;
                    break;
                }
            }
            if (y != -1) {
                break;
            }
        }

        if (y == -1) {
            return 1;
        }
        int ret = 0;
        for (int k = 0 ; k < 4 ; k++) {
            if (isCover(y, x, k)) {
                ret += cover();
                marking(y, x, k, '.');
            }
        }
        return ret;
    }

    private static boolean isCover(int y, int x, int k) {
        boolean ok = true;
        for (int l = 0 ; l < 3 ; l++) {
            int nr = y + NEXT_GRID[k][l][0];
            int nc = x + NEXT_GRID[k][l][1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != '.') {
                ok = false;
                break;
            }
        }
        if (ok) {
            marking(y, x, k, 'O');
            return true;
        }
        return ok;
    }

    private static void marking(int y, int x, int k, char mark) {
        for (int l = 0 ; l < 3 ; l++) {
            int nr = y + NEXT_GRID[k][l][0];
            int nc = x + NEXT_GRID[k][l][1];
            map[nr][nc] = mark;
        }
    }
}
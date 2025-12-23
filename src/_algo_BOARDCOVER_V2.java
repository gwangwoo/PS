import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _algo_BOARDCOVER_V2 {
    private static final int[][][] NEXT_GRID = { // 4 3 2
            {{0, 0}, {0, 1}, {1, 1}}, // ㄱ
            {{0, 0}, {1, 0}, {1, 1}}, // ㄴ
            {{0, 0}, {0, 1}, {1, 0}}, // reverse ㄱ
            {{0, 0}, {1, 0}, {1, -1}}  // reverse ㄴ
    };
    private static boolean[][] used;
    private static int N, M, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            used = new boolean[N][M];
            int preCount = 0;
            for (int i = 0 ; i < N ; i++) {
                String str = br.readLine();
                for (int j = 0 ; j < M ; j++) {
                    used[i][j] = str.charAt(j) == '.';
                    preCount += str.charAt(j) == '.' ? 1 : 0;
                }
            }
            if (preCount % 3 != 0) {
                System.out.println(0);
                continue;
            }

            int answer = cover();
            System.out.println(answer);
        }
    }

    private static int cover() {
        int y = -1, x = -1;
        for (int i = 0  ; i < N  ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (used[i][j]) {
                    y = i;
                    x = j;
                    break;
                }
            }
            if (y != -1) {
                break;
            }
        }

        if (y == -1) { // base
            return 1;
        }
        int ret = 0;
        for (int k = 0 ; k < 4 ; k++) {
            if (set(y, x, k)) {
                mark(y, x, k, false);
                ret += cover();
                mark(y, x, k, true); // 재귀 호출 후 지우기
            }
        }
        return ret;
    }

    private static boolean set(int y, int x, int k) {
        boolean isOk = true;
        for (int i = 0 ; i < 3 ; i++) {
            int nr = y + NEXT_GRID[k][i][0];
            int nc = x + NEXT_GRID[k][i][1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || !used[nr][nc]) {
                isOk = false;
                break;
            }
        }
        return isOk;
    }

    private static void mark(int y, int x, int k, boolean mark) {
        for (int i = 0 ; i < 3 ; i++) {
            int nr = y + NEXT_GRID[k][i][0];
            int nc = x + NEXT_GRID[k][i][1];
            used[nr][nc] = mark;
        }
    }
}

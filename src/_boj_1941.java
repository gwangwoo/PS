import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _boj_1941 {
    public static int[] dr = {-1,0,1,0};
    public static int[] dc = {0,1,0,-1};
    public static char[][] map;
    public static int N = 5;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        go(0, new ArrayList<>(), 0);
        System.out.println(answer);
    }

    private static void go(int idx, List<Integer> pickList, int sCount) {
        if (pickList.size() == 7) {
            if (sCount >= 4 && connected(pickList)) {
                answer++;
            }
            return;
        }
        if (idx == 25) {
            return;
        }
        pickList.add(idx);
        int r = idx / 5;
        int c = idx % 5;
        int nextS = sCount + (map[r][c] == 'S' ? 1 : 0);
        go(idx + 1, pickList, nextS);
        pickList.remove(pickList.size() - 1);
        // 안 고르는 경우
        go(idx + 1, pickList, sCount);
    }

    private static boolean connected(List<Integer> pickList) {
        int idx = pickList.stream().findFirst().get();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N*N];
        q.add(idx);
        visited[idx] = true;
        int count = 1;
        while(!q.isEmpty()) {
            idx = q.poll();
            int r = idx / 5;
            int c = idx % 5;
            for (int k = 0 ; k < 4 ; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                int nextIdx = nr * 5 + nc;
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nextIdx]) {
                    continue;
                }
                if (pickList.contains(nextIdx)) {
                    visited[nextIdx] = true;
                    q.add(nextIdx);
                    count++;
                }

            }
        }
        return count == 7;
    }
}

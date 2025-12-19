import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boj_15650 {
    static int N,M;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        go("", 0, 0);
    }

    private static void go(String result, int pickCount, int index) {
        if (pickCount == M) {
            System.out.println(result);
            return;
        }

        for (int i = index ; i < N ; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            go(result + (i+1) + " ", pickCount + 1, i+1);
            visited[i] = false;
        }
    }
}

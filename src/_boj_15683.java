import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _boj_15683 {
    private static final int[][][] FIRST_CAMERA = {{{1, 0}}, {{0, 1}}, {{-1, 0}}, {{0, -1}}}; // type y x
    private static final int[][][] SECOND_CAMERA = {{{-1, 0}, {1, 0}}, {{0, 1}, {0, -1}}};
    private static final int[][][] THIRD_CAMERA = {{{-1, 0}, {0, 1}},   // 위 + 오른쪽
            {{0, 1}, {1, 0}},    // 오른쪽 + 아래
            {{1, 0}, {0, -1}},   // 아래 + 왼쪽
            {{0, -1}, {-1, 0}}   // 왼쪽 + 위
    };
    private static final int[][][] FORTH_CAMERA = {{{-1, 0}, {0, -1}, {0, 1}}, {{-1, 0}, {0, 1}, {1, 0}}, {{0, -1}, {1, 0}, {0, 1}}, {{0, -1}, {-1, 0}, {1, 0}}};
    private static final int[][][] FIFTH_CAMERA = {{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}};

    private static int N, M;
    private static int[][] map;
    private static int answer = Integer.MAX_VALUE;
    private static List<Point> cameras;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cameras = new ArrayList<>();
        Map<Integer, int[][][]> cameraTypeMap = new HashMap<>();
        cameraTypeMap.put(1, FIRST_CAMERA);
        cameraTypeMap.put(2, SECOND_CAMERA);
        cameraTypeMap.put(3, THIRD_CAMERA);
        cameraTypeMap.put(4, FORTH_CAMERA);
        cameraTypeMap.put(5, FIFTH_CAMERA);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cameras.add(new Point(i, j, map[i][j], 0, cameraTypeMap.get(map[i][j])));
                }
            }
        }

        doBruteForce(0);    // index, minimumCount
        System.out.println(answer);
    }

    private static void doBruteForce(int index) {
        if (index == cameras.size()) {
            answer = Math.min(answer, check(cameras));
            return;
        }

        Point camera = cameras.get(index);
        for (int dir = 0; dir < camera.getCameraType().length; dir++) {
            camera.setCameraStatus(dir);
            doBruteForce(index + 1);
        }
    }

    private static int check(List<Point> cameras) {
        int[][] cloneMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, cloneMap[i], 0, M);
        }
        cameras.stream().forEach(camera -> {
            int[][][] cameraType = camera.getCameraType();
            int status = camera.getCameraStatus();
            for (int k = 0; k < cameraType[status].length; k++) {
                int nr = camera.r;
                int nc = camera.c;
                while (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 6) {
                    cloneMap[nr][nc] = camera.cameraNo;
                    nr += cameraType[status][k][0];
                    nc += cameraType[status][k][1];
                }
            }
        });
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cloneMap[i][j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

    static class Point {
        int r;
        int c;
        int cameraNo;
        int cameraStatus;
        int[][][] cameraType;

        Point(int r, int c, int cameraNo, int cameraStatus, int[][][] cameraType) {
            this.r = r;
            this.c = c;
            this.cameraNo = cameraNo;
            this.cameraStatus = cameraStatus;
            this.cameraType = cameraType;
        }

        public int[][][] getCameraType() {
            return cameraType;
        }

        public int getCameraStatus() {
            return this.cameraStatus;
        }

        public void setCameraStatus(int status) {
            this.cameraStatus = status;
        }
    }
}

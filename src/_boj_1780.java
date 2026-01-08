import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _boj_1780 {
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int firstAnswer = findPaper(0,0,N,N,-1);
        int secondAnswer = findPaper(0,0,N,N,0);
        int thirdAnswer = findPaper(0,0,N,N,1);

        System.out.println(firstAnswer);
        System.out.println(secondAnswer);
        System.out.println(thirdAnswer);
    }

    private static int findPaper(int sr, int sc, int er, int ec, int color) {
        if (check(sr,sc,er,ec,color)) {
            return 1;
        }

        if (er - sr == 1 && ec - sc == 1) {
            return 0;
        }

        int len = er - sr;
        int third = len / 3;

        int oneThirdRow = sr + third;
        int oneThirdCol = sc + third;
        int twoThirdRow = sr + third * 2;
        int twoThirdCol = sc + third * 2;

        int answer = 0;
        answer += findPaper(sr, sc, oneThirdRow, oneThirdCol, color);
        answer += findPaper(sr, oneThirdCol, oneThirdRow, twoThirdCol, color);
        answer += findPaper(sr, twoThirdCol, oneThirdRow, ec, color);
        answer += findPaper(oneThirdRow, sc, twoThirdRow, oneThirdCol, color);
        answer += findPaper(oneThirdRow, oneThirdCol, twoThirdRow, twoThirdCol, color);
        answer += findPaper(oneThirdRow, twoThirdCol, twoThirdRow, ec, color);
        answer += findPaper(twoThirdRow, sc, er, oneThirdCol, color);
        answer += findPaper(twoThirdRow, oneThirdCol, er, twoThirdCol, color);
        answer += findPaper(twoThirdRow, twoThirdCol, er, ec, color);
        return answer;
    }

    private static boolean check(int sr, int sc, int er, int ec, int color) {
        for (int i = sr ; i < er ; i++) {
            for (int j = sc ; j < ec ; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}

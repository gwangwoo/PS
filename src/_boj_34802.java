import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _boj_34802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> now = Arrays.stream(br.readLine().split(":")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> startTime = Arrays.stream(br.readLine().split(":")).map(Integer::parseInt).collect(Collectors.toList());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int diffSecond = toDiff(now, startTime);
        if (diffSecond < 0) {
            System.out.println(0);
            return;
        }
        int result = (int)(t * ((100 - k) / 100d));
        if (result > diffSecond) {
            System.out.println(0);
            return;
        }
        System.out.println(1);
    }

    private static int toDiff(List<Integer> now, List<Integer> startTime) {
        int nowSecond = 0;
        int startSecond = 0;
        int second = 1;
        for (int i = 2 ; i >= 0 ; i--) {
            nowSecond += now.get(i) * second;
            startSecond += startTime.get(i) * second;
            second *= 60;
        }
        second /= 60;
        return startSecond - nowSecond;
    }
}

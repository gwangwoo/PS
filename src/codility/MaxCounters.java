package codility;

// lazy sum
public class MaxCounters {
    public static void main(String[] args) {
        int[] arr = solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] solution(int N, int[] A) {
        int[] arr = new int[N];
        int M = A.length;
        int maxCnt = 0;
        int commonCnt = 0;
        for (int idx : A) {
            if (idx == N + 1) {
                commonCnt = maxCnt;
                continue;
            }
            if (arr[idx - 1] < commonCnt) {
                arr[idx - 1] = commonCnt + 1;
            } else {
                arr[idx - 1]++;
            }
            maxCnt = Math.max(maxCnt, arr[idx - 1]);
        }
        for (int i = 0; i < N; i++) {
            if (arr[i] < commonCnt) {
                arr[i] = commonCnt;
            }
        }
        return arr;
    }
}

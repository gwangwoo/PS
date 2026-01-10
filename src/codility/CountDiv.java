package codility;

public class CountDiv {
    public static void main(String[] args) {
        int A = 6;
        int B = 11;
        int K = 2;
        System.out.println(solution(A, B, K));
    }
    public static int solution(int A, int B, int K) {
        return B / K - A / K + ((A % K) == 0 ? 1 : 0);
    }
}

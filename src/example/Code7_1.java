package example;

// 1부터 n까지의 합을 구하는 분할 정복 알고리즘
public class Code7_1 {
    public static void main(String[] args) {
        System.out.println(fastSum(11));
    }

    static int fastSum(int n) {
        // base case
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 1) {
            return fastSum(n-1) + n;
        }
        return 2 * fastSum(n/2) + (n/2) * (n/2);
    }
}

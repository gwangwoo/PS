import java.util.*;

public class _boj_피보나치수열 {
	static int dp[] = new int[10000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp[1] = 1; dp[0] = 0;
		for(int i =2 ; i <= N ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[N]);
	}

}

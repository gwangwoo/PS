import java.util.*;

public class 피보나치함수_0502 {
	static int dp[] = new int[1000000];
	static long zero_cnt;
	static long one_cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		dp[0] = 0;
		dp[1] = 1;
		while(T-->0) {
			zero_cnt = 0;
			one_cnt = 0;
			int N = sc.nextInt();
			if(N == 0) {
				System.out.println(++zero_cnt + " " + one_cnt);
				continue;
			}
			if(N == 1) {
				System.out.println(zero_cnt + " " + ++one_cnt);
				continue;
			}
			for(int i = 2 ; i <= N ; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
			zero_cnt = dp[N-1];
			one_cnt = dp[N];
			System.out.println(zero_cnt + " " + one_cnt);
		}

	}

}

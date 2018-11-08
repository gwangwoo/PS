import java.util.Scanner;

public class 숫자삼각형_0504 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[][] = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j <= i ; j++) {
				dp[i][j] = sc.nextInt();
			}
		}
		for(int i = 1 ; i < N ; i++) {
			for(int j = 0; j <= i ; j++) {
				if(j == 0) dp[i][j] += dp[i-1][j];
				else if(j == i) dp[i][j] += dp[i-1][j-1];
				else dp[i][j] = Math.max(dp[i][j] + dp[i-1][j], dp[i][j] + dp[i-1][j-1]);
			}
		}
		int max = 0;
		for(int i=0 ; i < N ;i++) {
			if(max < dp[N-1][i]) max = dp[N-1][i];
		}
		System.out.println(max);
	}

}

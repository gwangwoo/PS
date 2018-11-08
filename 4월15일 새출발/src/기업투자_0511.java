import java.util.Scanner;

public class 기업투자_0511 {
	static int arr[][];
	static int dp[][];
	static int fr[][];
	static int N,M;
	static int NX,NM;

	static void f(int x,int y) {
		if(y == 0) return;
		f(fr[x][y], y-1);
		System.out.print(x-fr[x][y] + " ");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		fr = new int[N+1][M+1];
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j <= M ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for(int i = 1 ; i <= M ; i++) {
			for(int j = N ;j > 0; j--) {
				for(int k = 0 ; k <= j ; k++) {
					if(dp[j][i] < dp[j-k][i-1]+arr[k][i]) {
						dp[j][i] = dp[j-k][i-1] + arr[k][i];
						fr[j][i] = j-k;
					}
				}
			}
		}
		System.out.println(dp[N][M]);
		f(N,M);
	}

}

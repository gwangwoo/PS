import java.util.*;

public class 데스스타_0425 {
	static int ans[] = new int[1002];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int map[][] = new int[N+1][N+1];
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				if(i==j) continue;
				ans[i] = Math.max(ans[i], map[i][j] | map[j][i]);
			}
		}
		for(int i = 1; i <= N ; i++) {
			System.out.print(ans[i] + " ");
		}

	}

}

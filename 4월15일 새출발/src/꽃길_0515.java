import java.util.Scanner;

public class 꽃길_0515 {
	static final int dx[] = {-1,0,1,0};
	static final int dy[] = {0,1,0,-1};
	static int N,res;
	static boolean visited[][];
	static int map[][];
	
	
	static void dfs(int i,int j, int n , int cost) {
		if(n == 3) {
			if(cost < res) res = cost;
			return;
		}
		for(int x = 1; x < N ; x++) {
			for(int y = 1 ; y < N ; y++) {
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		res = Integer.MAX_VALUE;
		dfs(1,1,0,0);
		System.out.println(res);
	}

}

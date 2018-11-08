import java.util.*;

/**
 * @problem 14620
 * @author rhkdn5161
 * @date   2018-05-14
 */
public class 꽃길_0514 {
	static final int dx[] = {0,-1,0,1};
	static final int dy[] = {1,0,-1,0};
	static boolean visit[][];
	static int map[][];
	static int N,res;
	
	static int action(int x,int y) {
//		if(check(x,y) == false) return -1;
		
		int sum = 0;
		sum += map[x][y];
		visit[x][y] = true;
		for(int k = 0 ; k < 4 ; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			sum += map[nx][ny];
			visit[nx][ny] = true;
		}
		return sum;
	}
	
	static boolean check(int x,int y) {
		if(visit[x][y]) return false;
		
		for(int k = 0 ; k < 4 ; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny]) return false;
		}
		
		return true;
	}
	
	static void recovery(int x,int y) {
		visit[x][y] = false;
		for(int k = 0 ; k < 4 ; k++) {
			visit[x+ dx[k]][y + dy[k]] = false;
		}
	}
	
	static void dfs(int i,int j,int n,int cost) {
		if(n == 3) {
			if(cost < res) res = cost;
			return;
		}
		if(n >= 3) return;
		
		for(int x = 1 ; x < N ; x++) {
			for(int y = 1 ; y < N ; y++) {
				if(check(x,y) == true) {
					int value = action(x,y);
					dfs(x,y,n+1 , cost + value);
					recovery(x,y);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visit = new boolean[N][N];
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

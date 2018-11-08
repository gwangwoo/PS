import java.util.*;

public class N과M2_0429 {
	static int N,M;
	static int res[] = new int[8];
	static boolean check[] = new boolean[8];
	
	static boolean check() {
		for(int i = 0 ; i < M-1 ; i++) {
			if(res[i] >= res[i+1]) return false;
		}
		return true;
	}
	
	static void dfs(int turn) {
		if(turn == M) {
			if(check()) {
				for(int i = 0 ; i < M ; i++) {
					System.out.print(res[i] + " ");
				}
				System.out.println();
				return;
			}
		}
		for(int i = 0 ; i < N ; i++) {
			if(!check[i]) {
				check[i] = true;
				res[turn] = i+1;
				dfs(turn+1);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		dfs(0);
		
	}

}

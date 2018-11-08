import java.util.Scanner;

public class N과M_0429 {
	static int N,M;
	static boolean visited[] = new boolean[8];
	static int res[] = new int[8];
	static void dfs(int v) {
		if(v ==  M) {
			for(int i = 0 ; i < M ; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				res[v] = i+1;
				dfs(v + 1);
				visited[i] = false;
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

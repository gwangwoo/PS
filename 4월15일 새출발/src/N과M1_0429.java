import java.util.Scanner;

public class N과M1_0429 {
	static int N,M;
	static int res[] = new int[8];
	static boolean check[] = new boolean[8];
	
	static void dfs(int index) {
		if(index == M) {
			for(int i = 0 ; i < M ; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(!check[i]) {
				check[i] = true;
				res[index] = i+1;
				dfs(index+1);
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

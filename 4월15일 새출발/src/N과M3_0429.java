import java.io.*;
import java.util.*;

public class N과M3_0429 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,M;
	static int res[] = new int[7];
	
	static void dfs(int turn) throws IOException {
		if(turn == M) {
			for(int i = 0 ; i < M ; i++) {
				bw.write(res[i] + " ");
			}
			bw.write("\n");
			bw.flush();
			return;
		}
		for(int i = 0 ; i < N ; i++) {
				res[turn] = i+1;
				dfs(turn+1);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dfs(0);
		bw.close();
	}

}

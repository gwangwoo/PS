import java.util.*;

public class 연구소_0426_V2 {
	static int[][] map, tempMap, copyMap;
	static int N,M;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int ans;
	
	// 안전 영역 구하기
	public static void cal() {
	    int cnt = 0;
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	            if (copyMap[i][j] == 0) {
	                ++cnt;
	            }
	        }
	    }
	    if (cnt > ans) {
	        ans = cnt;
	    }
	}
	
	static void paint(int y,int x) {
		for(int k = 0 ; k < 4 ; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(ny >= 0 && ny < N && nx >= 0 && nx < M) {
				if(copyMap[ny][nx] == 0) {
					copyMap[ny][nx] = 2;
					paint(ny,nx);
				}
			}
		}
	}
	
	
	static void dfs(int v, int cnt) {
		int c = v / M ;
		int r = v % M;
		
		if(cnt == 3) {
			copyMap = new int[N][M];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					copyMap[i][j] = tempMap[i][j];
				}
			}
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(copyMap[i][j] == 2) {
						paint(i,j);
					}
				}
			}
			cal();
		}else {
			for(int i = v+1 ; i < N*M ; i++) {
				int cc = i / M;
				int rr = i % M;
				
				if(tempMap[cc][rr] == 0) {
					tempMap[cc][rr] = 1;
					dfs(i,cnt+1);
				}
			}
		}
		tempMap[c][r] = 0;
		--cnt;
	}
	
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		tempMap = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = sc.nextInt();
				tempMap[i][j] = map[i][j];
			}
		}
		
		for(int i = 0; i < N*M; i++) {
			int c = i / M ;
			int r = i % M;
			
			if(tempMap[c][r] == 0) {
				tempMap[c][r] = 1;
				dfs(i,1);
				tempMap[c][r] =0;
			}
		}
		System.out.println(ans);
	}

}

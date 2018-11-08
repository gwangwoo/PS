import java.util.Scanner;

public class 체스판다시칠하기_0428 {
	static char white_chess[][] = new char[8][8];
	static char black_chess[][] = new char[8][8];
	static char map[][];
	static int min_cnt;
	static void make_Chess() {
		for(int i = 0 ; i < 8 ; i++) {
			if(i % 2 == 0) {
				for(int j = 0 ; j < 8 ; j++) {
					if(j % 2 == 0) {
						white_chess[i][j] = 'W';
						black_chess[i][j] = 'B';
					}else {
						white_chess[i][j] = 'B';
						black_chess[i][j] = 'W';
					}
				}
			}else {
				for(int j = 0 ; j < 8 ; j++) {
					if(j % 2 == 0) {
						white_chess[i][j] = 'B';
						black_chess[i][j] = 'W';
					}else {
						white_chess[i][j] = 'W';
						black_chess[i][j] = 'B';
					}
				}
			}
		}
	}

	static int sol(int r,int c) {
		int white_ret = 0, black_ret = 0, ret = 0;
		for(int i = r ; i <= r+7 ; i++) {
			for(int j = c ; j <= c+7 ; j++) {
				if(map[i][j] != white_chess[i-r][j-c]) {
					white_ret++;
				}
				if(map[i][j] != black_chess[i-r][j-c]) {
					black_ret++;
				}
			}
		}
		ret = Math.min(black_ret, white_ret);
		return ret;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		min_cnt = Integer.MAX_VALUE;
		map = new char[M][N];
		for(int i = 0 ; i < M ; i++) {
			String str = sc.next();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		make_Chess();

		for(int i = 0 ; i < M-7 ; i++) {
			for(int j = 0 ; j < N-7 ; j++) {
				min_cnt = Math.min(min_cnt, sol(i,j));
			}
		}
		System.out.println(min_cnt);

	}

}

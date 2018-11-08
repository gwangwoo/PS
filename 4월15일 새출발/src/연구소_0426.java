import java.util.*;

public class 연구소_0426 {
	static final int dx[] = {-1,0,1,0};
	static final int dy[] = {0,1,0,-1};
	static int map[][];
	static boolean check[][];
	static int cnt = 0;
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		int tmp[][] = new int[N][M];
		check = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = sc.nextInt();
				tmp[i][j] = map[i][j];
				if(map[i][j] == 2) {
					q.add(new Point(i,j));
				}
			}
		}
		int door_cnt = 0;
		for(int d1_x = 0 ; d1_x < N ; d1_x++) {
			for(int d1_y = 0 ; d1_y < M ; d1_y++) {
				if(tmp[d1_x][d1_y] != 0) continue;
				else tmp[d1_x][d1_y] = 1;

				for(int d2_x = 0 ; d2_x < N; d2_x++) {
					for(int d2_y = 0 ; d2_y < M ; d2_y++) {
						if(tmp[d2_x][d2_y] != 0) continue;
						else tmp[d2_x][d2_y] = 1;

						for(int d3_x = 0 ; d3_x < N ; d3_x++) {
							for(int d3_y = 0 ; d3_y < M ; d3_y++) {
								if(tmp[d3_x][d3_y] != 0) continue;
								else tmp[d3_x][d3_y] = 1;

								tmp[d1_x][d1_y] = 1;
								tmp[d2_x][d2_y] = 1;
								Queue<Point> tmp_q = new LinkedList<>();
								tmp_q.addAll(q);
								while(!tmp_q.isEmpty()) {
									Point p = tmp_q.poll();
									int x = p.x;
									int y = p.y;
									for(int k = 0 ; k < 4 ; k++) {
										int nx = x + dx[k];
										int ny = y + dy[k];
										if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
										if(tmp[nx][ny] == 0 && check[nx][ny] == false) {
											check[nx][ny] = true;
											tmp[nx][ny] = 2;
											tmp_q.add(new Point(nx,ny));
										}
									}
								}
								for(int i = 0 ; i < N ; i++) {
									for(int j = 0 ; j < M ; j++) {
										System.out.print(tmp[i][j] + " ");
									}
									System.out.println();
								}
								System.out.println();
								int tmp_cnt = 0;
								for(int i = 0 ; i < N ; i++) {
									for(int j = 0 ; j < M ; j++) {
										if(tmp[i][j] == 0) {
											tmp_cnt++;
										}
									}
								}
								if(tmp_cnt > cnt) cnt = tmp_cnt;
								for(int i = 0 ; i < N ; i++) {
									Arrays.fill(check[i], false);
								}
								for(int i = 0 ; i < N ; i++) {
									for(int j = 0 ; j < M ; j++) {
										tmp[i][j] = map[i][j];
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
	static class Point {
		int x,y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

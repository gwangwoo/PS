import java.util.*;

public class 치킨배달_0415 {
	static int N,M;
	static ArrayList<Point> person;		// 사람 좌표담는 어레이리스트
	static ArrayList<Point> company;	// 치킨집 좌표담는 어레이리스트
	static int map[][];
	static int min;
	static ArrayList<Integer> arr1;		// 선택된 치킨집.
	static class Point {
		int x,y;
		Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		min = Integer.MAX_VALUE;
		map = new int[N][N];
		person = new ArrayList<>();
		company = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					person.add(new Point(i,j));
				}else if(map[i][j] == 2) {
					company.add(new Point(i,j));
				}
			}
		}
		for(int i = 0 ; i < (1<<company.size()) ;i++) {		// 치킨집이 될수있는 완탐
			arr1 = new ArrayList<>();
			for(int j = 0 ; j < company.size() ; j++) {
				if((i & (1<<j)) != 0) {
					arr1.add(j);			// 0이아닌 치킨집 선택.
				}
			}
			if(arr1.isEmpty()) continue;	// 공집합 제거.
			if(arr1.size() > M) continue;	// M번 보다 많이 선택되면 안됨 최대 M개 까지 선택가능하므로.
			int res = 0;
			for(int j = 0 ; j < person.size(); j++) {
				int dist = Integer.MAX_VALUE;
				for(int k = 0 ; k < arr1.size(); k++) {
					int tmp = Math.abs(company.get(arr1.get(k)).x - person.get(j).x) + Math.abs(company.get(arr1.get(k)).y - person.get(j).y);
					dist = Math.min(dist,tmp);
				}
				res+=dist;
			}
			min = Math.min(min, res);
		}
		System.out.println(min);

	}
}

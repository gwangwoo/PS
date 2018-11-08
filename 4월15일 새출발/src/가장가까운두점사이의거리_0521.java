import java.util.Comparator;
import java.util.*;

public class 가장가까운두점사이의거리_0521 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Point> list = new ArrayList<>();
		TreeSet<Point> candidate = new TreeSet<Point>(new ComparatorSet());
		int ans = 0;

		for(int i = 0 ; i < N ; i++) {
			list.add(new Point(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(list,new ComparatorDescending());
		for(int i = 0 ; i < N ; i++) {
			System.out.println(list.get(i).x + " " + list.get(i).y);
		}

	}

	static int distance(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}

	static class ComparatorDescending implements Comparator<Point> {
		public int compare(Point p1, Point p2) {
			if(p1.x < p2.x) return -1;
			else if(p1.x == p2.x) return 0;
			else return 1;
		}
	}
	static class ComparatorSet implements Comparator<Point> {
		public int compare(Point p1, Point p2) {
			if(p1.y == p2.y) {
				if(p1.x < p2.x) return -1;
				else if(p1.x == p2.x) return 0;
				else return 1;
			}else {
				return p1.y < p2.y ? 1 : -1;
			}
		}
	}

	static class Point implements Comparable<Point>{
		int x,y;
		Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(Point p) {
			return x < p.y && y > p.y? 1:-1;
		}
	}
}


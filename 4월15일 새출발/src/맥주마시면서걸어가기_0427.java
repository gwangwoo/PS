import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class 맥주마시면서걸어가기_0427 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int N = sc.nextInt();
			Point location[] = new Point[N+2];
			int[] check = new int[N+2];
			Queue<Point> q = new LinkedList<>();
			boolean ok = false;
			// 입력 끝
			for(int i = 0 ; i < N+2 ; i++) {
				location[i] = new Point(sc.nextInt(),sc.nextInt());
			}
			Point start = location[0];
			Point end = location[N+1];
			q.add(start);
			
			while(!q.isEmpty()) {
				Point current = q.poll();
				
				if(current.equals(end)) {
					ok = true;
					break;
				}
				
				for(int i = 1 ; i < N+2 ; i++) {
					if(check[i] == 0 && (Math.abs(current.x - location[i].x) + Math.abs(current.y - location[i].y)) <= 1000) {
						q.add(location[i]);
						check[i] = 1;
					}
				}
			}
			if(ok == true) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
		}

	}
	static class Point {
		int x,y;
		Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
}

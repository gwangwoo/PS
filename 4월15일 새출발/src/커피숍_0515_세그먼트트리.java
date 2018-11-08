import java.util.Scanner;

public class 커피숍_0515_세그먼트트리 {
	static final int MAX = 1000001;
	static long arr[] = new long[MAX];
	static long seg[] = new long[MAX*4];
	static int N;
	
	static long query(int lo, int hi, int node, int x, int y) {
		if(y < lo || x > hi) return 0;
		if(lo <= x && y <= hi) return seg[node];
		int mid = (x + y) >> 1;
		long l = query(lo,hi,node*2 , x, mid);
		long r = query(lo,hi,node*2+1, mid+1 , y);
		return l+r;
	}
	
	static void init(int node, int x,int y) {
		if(x == y) {
			seg[node] = arr[x];
			return;
		}
		int mid = (x + y ) >> 1;
		init(node*2 , x, mid);
		init(node*2+1 , mid+1 , y);
		seg[node] = seg[node*2+1] + seg[node*2]; 
	}
	
	static void update(int pos, int val, int node, int x,int y) {
		if(pos < x || pos > y) return;
		if(x == y) {
			seg[node] = val;
			return;
		}
		int mid = (x + y) /2;
		update(pos, val, node *2 , x, mid);
		update(pos, val, node *2+1, mid+1 , y);
		seg[node] = seg[node*2] + seg[node*2+1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int t = sc.nextInt();
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = sc.nextLong();
		}
		init(1,1,N);
		while(t-->0) {
			int left,right,a,b;
			left = sc.nextInt();
			right = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			if(left > right) {
				int tmp = left;
				left = right;
				right = tmp;
			}
			System.out.println(query(left,right,1,1,N));
			update(a, b, 1,1,N);
		}
		
	}

}

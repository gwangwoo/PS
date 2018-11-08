import java.util.Scanner;

public class 구간합구하기_0515_세그먼트트리 {
	static final int MAX = 1000001;
	static long arr[] = new long[MAX];
	static long seg[] = new long[MAX*4];
	static int N, M ,K;
	
	static long query(int low, int hi , int node, int x, int y) {
		if(y < low || x > hi) return 0;
		if(low <= x && y <= hi) return seg[node];
		int mid = (x+y) /2;
		long l = query(low,hi,node*2 , x , mid);
		long r = query(low,hi,node*2+1, mid+1, y);
		return l+r;
	}
	
	static void init(int node, int x,int y) {
		if(x == y) {
			seg[node] = arr[x];
			return;
		}
		int mid = (x+y) / 2;
		init(node * 2, x,mid);
		init(node *2 + 1, mid+1 , y);
		seg[node] = seg[node * 2] + seg[node * 2 +1];
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
		M = sc.nextInt();
		K = sc.nextInt();
		for(int i = 1 ; i < N+1 ; i++) {
			arr[i] = sc.nextLong();
		}
		init(1,1,N);
		int turn = M + K;
		while(turn-- >0) {
			int a,b,c;
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			if(a == 1) {
				update(b,c,1,1,N);
			}else {
				System.out.println(query(b,c,1,1,N));
			}
		}
		
	}

}

import java.util.*;

public class DSLR_0420 {
	static int visited[] = new int[10000];
	static String how[] = new String[10000];
	static int from[] = new int[10000];
	static int dist[] = new int[10000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			Arrays.fill(visited, 0);
			Arrays.fill(how, null);
			Arrays.fill(from, 0);
			Arrays.fill(dist, 0);
			q.add(start);
			visited[start] = 1;
			dist[start] = 1;
			while(!q.isEmpty()) {
				int now = q.poll();
				int next = (2 * now) % 10000;
				if(visited[next] == 0) {
					q.add(next);
					visited[next] = 1;
					dist[next] = dist[now] + 1;
					from[next] = now;
					how[next] = "D";
				}
				next = now - 1;
				if(now == 0) next = 9999;
				if(visited[next] == 0) {
					q.add(next);
					visited[next] = 1;
					dist[next] = dist[now] + 1;
					from[next] = now;
					how[next] = "S";
				}
				next = (now % 1000)*10 + (now / 1000);
				if(visited[next] == 0) {
					q.add(next);
					visited[next] = 1;
					dist[next] = dist[now] + 1;
					from[next] = now;
					how[next] = "L";
				}
				next = (now % 10)*1000 + (now/10);
				if(visited[next] == 0) {
					q.add(next);
					visited[next] = 1;
					dist[next] = dist[now] + 1;
					from[next] = now;
					how[next] = "R";
				}
			}
			StringBuilder sb = new StringBuilder();
			while(end != start) {
				sb.append(how[end]);
				end = from[end];
			}
			System.out.println(sb.reverse());

		}

	}
}
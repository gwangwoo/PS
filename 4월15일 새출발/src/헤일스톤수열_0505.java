import java.util.*;

public class 헤일스톤수열_0505 {
// 오늘은 어린이날 우리들 세상!!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int N = sc.nextInt();
			int max = N;
			while(N != 1) {
				if(N % 2 == 0) {
					N /= 2;
				}else {
					N = (N * 3) + 1;
				}
				max = Math.max(max, N);
			}
			System.out.println(max);
		}
			
	}

}

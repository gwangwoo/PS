import java.util.*;

public class 분해합_0428 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = 0;
		for(int i = 1; i <= N ; i++) {
			int tmp = i;
			String str = Integer.toString(i);
			for(int j = 0 ; j < str.length(); j++) {
				tmp += str.charAt(j)-'0';
			}
			if(N == tmp) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
		
	}

}

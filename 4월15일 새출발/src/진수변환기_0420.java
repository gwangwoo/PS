import java.util.*;

public class 진수변환기_0420 {
	static int M,N;
	static StringBuilder str;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();	// 10진수 입력
		N = sc.nextInt();	// N 진수 출력.
		str = new StringBuilder(); 
		if(M == 0) { 
			System.out.println(0);
			return;
		}

		while(M > 0) {
			str.insert(0, Integer.toHexString(M%N).toUpperCase());
			M/=N;
		}
		System.out.println(str);
	}
}
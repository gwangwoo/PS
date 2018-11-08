import java.util.*;

public class 유레카이론_0428 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T[] = new int[51];
		int res[] = new int[5000];
		for(int i = 1 ; i < T.length ; i++) {
			T[i] = (i * (i+1))/2;
		}
		for(int i = 1 ; i <=50 ; i++) {
			for(int j = 1 ; j <= 50 ; j++) {
				for(int k = 1; k <= 50 ; k++) {
					res[T[i] + T[j] + T[k]] = 1;
				}
			}
		}
		int tc = sc.nextInt();
		while(tc-->0) {
			if(res[sc.nextInt()] == 1) System.out.println(1);
			else System.out.println(0);
		}
		
		
	}

}

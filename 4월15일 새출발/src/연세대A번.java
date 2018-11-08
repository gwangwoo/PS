import java.util.*;

public class 연세대A번 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[101];
		for(int i = 1 ; i <= 100 ; i++) {
			arr[i] = 1+i+i*i;
		}
		int N = sc.nextInt();
		for(int i = 1 ; i <= 100 ; i++) {
			if(N == arr[i]) {
				System.out.println(i);
				return;
			}
		}
		
	}

}

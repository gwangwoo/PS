import java.util.Arrays;
import java.util.Scanner;

public class 방번호_0514 {
	static int number[] = new int[10];
	static int res = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for(int i = 0 ; i < str.length() ; i++) {
			int now = str.charAt(i)-'0';
			number[now]++;
		}
		int temp = number[6] + number[9];
		number[6] = temp % 2 == 1? temp/2 +1 : temp/2;
		number[9] = temp / 2;
		for(int i = 0 ; i < 10 ; i++) {
			res = Math.max(res, number[i]);
		}
		System.out.println(res);
	}
}
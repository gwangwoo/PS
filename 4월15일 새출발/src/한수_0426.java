import java.util.Scanner;

public class 한수_0426 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;

		for(int i = 1 ; i <= N ; i++) {
			String str = Integer.toString(i);
			int length = str.length();
			int num1 = Integer.parseInt(str.substring(0,1));
			int diff = 10;

			boolean ok = true;
			for(int j = 1 ; j < length ; j++) {
				int num2 = Integer.parseInt(str.substring(j,j+1));
				if(diff == 10) {
					diff = num2 - num1;
				}else {
					if(diff != (num2 - num1)) {
						ok = false;
						break;
					}
				}
				num1 = num2;
			}
			if(ok == true) {
				cnt++;
			}
		}
		System.out.println(cnt);


	}

}

import java.util.*;

public class 이진수연산_0425 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		// & Operation
		StringBuilder sb_and = new StringBuilder();
		for(int i = 0 ; i < str1.length(); i++) {
			int first = str1.charAt(i)-'0';
			int last = str2.charAt(i)-'0';
			if((first & last) != 0) {
				sb_and.append(1);
			}else sb_and.append(0);
		}
		// | Operation
		StringBuilder sb_or = new StringBuilder();
		for(int i = 0 ; i < str1.length(); i++) {
			int first = str1.charAt(i)-'0';
			int last = str2.charAt(i)-'0';
			if((first | last) != 0) {
				sb_or.append(1);
			}else sb_or.append(0);
		}
		// ^ Operation
		StringBuilder sb_to = new StringBuilder();
		for(int i = 0 ; i < str1.length(); i++) {
			int first = str1.charAt(i)-'0';
			int last = str2.charAt(i)-'0';
			if((first ^ last) != 0) {
				sb_to.append(1);
			}else sb_to.append(0);
		}
		// ~A
		StringBuilder sb_Not_A = new StringBuilder();
		for(int i = 0 ; i < str1.length(); i++) {
			int first = str1.charAt(i)-'0';
			if((first & 1) == 0) {
				sb_Not_A.append(1);
			}else sb_Not_A.append(0);
		}
		// ~B
		StringBuilder sb_Not_B = new StringBuilder();
		for(int i = 0 ; i < str2.length(); i++) {
			int last = str2.charAt(i)-'0';
			if((last & 1) == 0) {
				sb_Not_B.append(1);
			}else sb_Not_B.append(0);
		}
		
		
		//sb_and.reverse();
		System.out.println(sb_and);
		System.out.println(sb_or);
		System.out.println(sb_to);
		System.out.println(sb_Not_A);
		System.out.println(sb_Not_B);
	}

}

/** IMPORTS **/
import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import java.lang.Math.*;

public class Solution {
	/** GLOBAL VARIABLES **/
	long times = -1;

	/** MAIN CODE **/
	public void run() throws Exception {
		Scanner file = new Scanner(new File("input.dat".toLowerCase()));
		int[] a = Arrays.stream(file.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
		for (int i = 0; i < a.length;) {
			String s = "" + a[i];
			while (s.length() < 5) s = "0" + s;
			int op = Integer.parseInt(s.substring(3, 5));
			if (op == 99) break;
			else if (op == 1) {
				int sum = 0;
				if (s.charAt(2) == '0') sum += a[a[i + 1]];
				else sum += a[i + 1];
				if (s.charAt(1) == '0') sum += a[a[i + 2]];
				else sum += a[i + 2];
				a[a[i + 3]] = sum;
				i += 4;
			}
			else if (op == 2) {
				int sum = 1;
				if (s.charAt(2) == '0') sum *= a[a[i + 1]];
				else sum *= a[i + 1];
				if (s.charAt(1) == '0') sum *= a[a[i + 2]];
				else sum *= a[i + 2];
				a[a[i + 3]] = sum;
				i += 4;
			}
			else if (op == 3) {
				a[a[i + 1]] = 5;
				i += 2;
			}
			else if (op == 4) {
				if (s.charAt(2) == '0') System.out.println(a[a[i + 1]]);
				else System.out.println(a[i + 1]);
				i += 2;
			}
			else if (op == 5) {
				int nxtparam = s.charAt(2) == '0' ? a[a[i + 1]] : a[i + 1];
				if (nxtparam == 0) {
					i += 3;
				}
				else {
					i = s.charAt(1) == '0' ? a[a[i + 2]] : a[i + 2];
				}
			}
			else if (op == 6) {
				int nxtparam = s.charAt(2) == '0' ? a[a[i + 1]] : a[i + 1];
				if (nxtparam != 0) {
					i += 3;
				}
				else {
					i = s.charAt(1) == '0' ? a[a[i + 2]] : a[i + 2];
				}
			}
			else if (op == 7) {
				int fpos = s.charAt(0) == '0' ? a[i + 3] : i + 3;
				int v1 = s.charAt(2) == '0' ? a[a[i + 1]] : a[i + 1];
				int v2 = s.charAt(1) == '0' ? a[a[i + 2]] : a[i + 2];
				if (v1 < v2) {
					a[fpos] = 1;
				}
				else {
					a[fpos] = 0;
				}
				i += 4;
			}
			else if (op == 8) {
				int fpos = s.charAt(0) == '0' ? a[i + 3] : i + 3;
				int v1 = s.charAt(2) == '0' ? a[a[i + 1]] : a[i + 1];
				int v2 = s.charAt(1) == '0' ? a[a[i + 2]] : a[i + 2];
				if (v1 == v2) {
					a[fpos] = 1;
				}
				else {
					a[fpos] = 0;
				}
				i += 4;
			}
			else {
				System.out.println(i + " " + s);
			}
		}
		file.close();
	}

	/** EXTRAS **/
	public static void main(String[] cows) throws Exception {
		new Solution().run();
	}
}

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
		int a = 136818;
		int b = 685979;
		int ans = 0;
		for (int i = a; i <= b; i++) {
			if (works(i)) ans++;
		}
		System.out.println(ans);
		file.close();
	}
	
	public static boolean works(int n) {
		char[] c = (n + "").toCharArray();
		boolean works = false;
		boolean dec = true;
		for (int i = c.length - 1; i >= 1; i--) {
			if (c[i] < c[i - 1]) dec = false;
			int cnt = 1;
			int j = i - 1;
			while (j >= 0 && c[j] == c[i]) {
				j--;
				cnt++;
			}
			j = i + 1;
			while (j < c.length && c[j] == c[i]) {
				j++;
				cnt++;
			}
			if (cnt == 2) works = true;
		}
		return works && dec;
	}

	/** EXTRAS **/
	public static void main(String[] cows) throws Exception {
		new Solution().run();
	}
}

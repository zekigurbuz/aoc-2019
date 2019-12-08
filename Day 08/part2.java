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
		char[] c = file.next().toCharArray();
		int[] ans = new int[25 * 6];
		Arrays.fill(ans, 2);
		for (int i = 0; i < c.length;) {
			int j = i;
			for (int k = 0; k < 25 * 6; k++, j++) {
				if (c[j] == '2') {
					continue;
				}
				else if (c[j] == '1') {
					ans[j % (25 * 6)] = ans[j % (25 * 6)] == 2 ? 1 : ans[j % (25 * 6)];
				}
				else if (c[j] == '0') {
					ans[j % (25 * 6)] = ans[j % (25 * 6)] == 2 ? 0 : ans[j % (25 * 6)];
				}
			}
			i = j;
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 25; j++) {
				System.out.print(ans[i * 25 + j] == 1 ? 'X' : '.');
			}
			System.out.println();
		}
		file.close();
	}

	/** EXTRAS **/
	public static void main(String[] cows) throws Exception {
		new Solution().run();
	}
}

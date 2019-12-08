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
		int ans = 0;
		int min = 25 * 6;
		for (int i = 0; i < c.length;) {
			int j = i;
			int c0 = 0;
			int c1 = 0;
			int c2 = 0;
			for (int k = 0; k < 25 * 6; k++, j++) {
				if (c[j] == '0') c0++;
				else if (c[j] == '1') c1++;
				else if (c[j] == '2') c2++;
			}
			if (c0 < min) {
				min = c0;
				ans = c1 * c2;
			}
			i = j;
		}
		System.out.println(ans);
		file.close();
	}

	/** EXTRAS **/
	public static void main(String[] cows) throws Exception {
		new Solution().run();
	}
}

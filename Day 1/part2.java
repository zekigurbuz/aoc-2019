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
		int[] b = Arrays.stream(file.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
		for (int x = 0; x <= 99; x++) {
			for (int y = 0; y <= 99; y++) {
				int[] a = b.clone();
				a[1] = x;
				a[2] = y;
				for (int i = 0; i < a.length; i += 4) {
					if (a[i] == 99) break;
					else if (a[i] == 1) {
						a[a[i + 3]] = a[a[i + 1]] + a[a[i + 2]];
					}
					else {
						a[a[i + 3]] = a[a[i + 1]] * a[a[i + 2]];
					}
				}
				if (a[0] == 19690720) {
					System.out.println(a[1] * 100 + a[2]);
				}
			}
			
		}
		file.close();
	}

	/** EXTRAS **/
	public static void main(String[] cows) throws Exception {
		new Solution().run();
	}
}

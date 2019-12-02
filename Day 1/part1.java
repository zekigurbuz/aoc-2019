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
		for (int i = 0; i < a.length; i += 4) {
			if (a[i] == 99)
				break;
			else if (a[i] == 1) {
				a[a[i + 3]] = a[a[i + 1]] + a[a[i + 2]];
			} else {
				a[a[i + 3]] = a[a[i + 1]] * a[a[i + 2]];
			}
		}
		System.out.println(a[0]);
		file.close();
	}

	/** EXTRAS **/
	public static void main(String[] cows) throws Exception {
		new Solution().run();
	}
}

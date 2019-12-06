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
		HashMap<String, HashSet<String>> hm = new HashMap<>();
		HashMap<String, Integer> comp = new HashMap<>();
		int cnt = 0;
		ArrayList<String> al = new ArrayList<>();
		while (file.hasNext()) {
			String s = file.nextLine();
			al.add(s);
			String a = s.substring(0, s.indexOf(")"));
			String b = s.substring(s.indexOf(")") + 1);
			if (!hm.containsKey(a)) {
				hm.put(a, new HashSet<String>());
				comp.put(a, cnt++);
			}
			if (!hm.containsKey(b)) {
				hm.put(b, new HashSet<String>());
				comp.put(b, cnt++);
			}
			hm.get(a).add(b);
			hm.get(b).add(a);
		}
		long ans = 0;
		long[] b = new long[cnt];
		Arrays.fill(b, Long.MAX_VALUE);
		Queue<Object> q = new LinkedList<>();
		q.add("YOU");
		q.add(0L);
		while (!q.isEmpty()) {
			String cur = (String) q.poll();
			long l = (long) q.poll();
			if (b[comp.get(cur)] <= l) continue;
			b[comp.get(cur)] = l;
			for (String s : hm.get(cur)) {
				q.add(s);
				q.add(l + 1);
			}
		}
		ans = b[comp.get("SAN")] - 2;
		System.out.println(ans);
		file.close();
	}

	/** EXTRAS **/
	public static void main(String[] cows) throws Exception {
		new Solution().run();
	}
}

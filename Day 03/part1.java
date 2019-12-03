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
		String[] a = file.nextLine().trim().split(",");
		String[] b = file.nextLine().trim().split(",");
		TreeSet<Pair<Integer, Integer>> c = new TreeSet<>();
		TreeSet<Pair<Integer, Integer>> d = new TreeSet<>();
		int sz = 5000;
		int x = sz/2;
		int y = sz/2;
		HashMap<String, Integer> xm = new HashMap<>();
		HashMap<String, Integer> ym = new HashMap<>();
		xm.put("R", 0);
		xm.put("L", 0);
		xm.put("U", -1);
		xm.put("D", 1);
		ym.put("R", 1);
		ym.put("L", -1);
		ym.put("U", 0);
		ym.put("D", 0);
		for (int i = 0; i < a.length; i++) {
			c.add(new Pair<Integer, Integer>(x, y));
			String di = a[i].substring(0, 1);
			int dist = Integer.parseInt(a[i].substring(1));
			for (int j = 0; j < dist; j++) {
				x += xm.get(di);
				y += ym.get(di);
				c.add(new Pair<Integer, Integer>(x, y));
			}
		}
		x = sz/2;
		y = sz/2;
		for (int i = 0; i < b.length; i++) {
			d.add(new Pair<Integer, Integer>(x, y));
			String di = b[i].substring(0, 1);
			int dist = Integer.parseInt(b[i].substring(1));
			for (int j = 0; j < dist; j++) {
				x += xm.get(di);
				y += ym.get(di);
				d.add(new Pair<Integer, Integer>(x, y));
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < sz; i++) {
			for (int j = 0; j < sz; j++) {
				if (i == sz/2 && j == sz/2) continue;
				if (c.contains(new Pair<Integer, Integer>(i, j)) && d.contains(new Pair<Integer, Integer>(i, j))) {
					ans = Math.min(ans, dist(i, j, sz/2, sz/2));
				}
			}
		}
		System.out.println(ans);
		file.close();
	}
	
	public static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}

	/** EXTRAS **/
	public static void main(String[] cows) throws Exception {
		new Solution().run();
	}
	public static class Pair<A, B> implements Comparable {
		public A fi;
		public B se;

		public Pair(A fi, B se) {
			this.fi = fi;
			this.se = se;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Pair<?, ?> p = (Pair<?, ?>) o;
			if (!fi.equals(p.fi))
				return false;
			return se.equals(p.se);
		}

		@Override
		public int hashCode() {
			return 31 * fi.hashCode() + se.hashCode();
		}

		@Override
		public String toString() {
			return fi.toString() + " " + se.toString();
		}

		public static <A, B> Pair<A, B> of(A a, B b) {
			return new Pair<A, B>(a, b);
		}

		public int compareTo(Object o) {
			Pair<?, ?> p = (Pair<?, ?>) o;
			if (fi.equals(p.fi))
				return ((Comparable) se).compareTo(p.se);
			return ((Comparable) fi).compareTo(p.fi);
		}
	}
}


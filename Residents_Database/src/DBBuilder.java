import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DBBuilder {
	static StringBuilder a = new StringBuilder("");
	static StringBuilder b = new StringBuilder("");
	static StringBuilder c = new StringBuilder("");
	static Bed d;
	static Major e;
	static Enrollment f;
	static Floor g;
	static int h = 0;
	static int i = 0;
	static int j = 0;
	static int k = 0;
	static int l = 0;
	static int m = 0;
	static int n = 0;
	static int o = 0;
	static int p = 0;
	static int q = 0;
	static int r = 0;
	static String s = "";
	static String t = "";
	static String u = "";
	static ArrayList<Hobby> v = new ArrayList<Hobby>();
	static ArrayList<Pet> w = new ArrayList<Pet>();
	static ArrayList<Characteristic> x = new ArrayList<Characteristic>();
	static ArrayList<Characteristic> y = new ArrayList<Characteristic>();
	static GenderPreference z;
	static Random rand = new Random();
	static char[] characters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static void main(String[] args) throws IOException {

		int numRes = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many Residents do you want to test?");
		numRes = scanner.nextInt();
		
		FileWriter outfile = new FileWriter("resdat.txt");
		BufferedWriter bw = new BufferedWriter(outfile);
		bw.write("Header\n");
		
		int num = 0;
		for (int ctr = 0; ctr < numRes; ++ctr) {
			// a
			for (int count = 0; count < 10; ++count) {
				num = rand.nextInt(25);
				a.append(characters[num]);
			}

			// b
			num = rand.nextInt(25);
			b.append(characters[num]);

			// c
			for (int count = 0; count < 10; ++count) {
				num = rand.nextInt(25);
				c.append(characters[num]);
			}

			// d
			num = rand.nextInt(5) + 1;
			d = Bed.fromInt(num);

			// e
			num = rand.nextInt(14) + 1;
			e = Major.fromInt(num);

			// f
			num = rand.nextInt(7) + 1;
			f = Enrollment.fromInt(num);

			// g
			num = rand.nextInt(4);
			g = Floor.fromInt(num);

			// h
			h = rand.nextInt(1);

			// i
			i = rand.nextInt(1);

			// j
			j = rand.nextInt(1);

			// k
			k = rand.nextInt(1);

			// l
			l = rand.nextInt(1);

			// m
			m = rand.nextInt(1);

			// n
			n = rand.nextInt(10) + 1;

			// o
			o = rand.nextInt(10) + 1;

			// p
			p = rand.nextInt(10) + 1;

			// q
			q = rand.nextInt(10) + 1;

			// r
			r = rand.nextInt(10) + 1;

			s = "";
			t = "";
			u = "";

			for (int count = 0; count < 3; ++count) {
				num = rand.nextInt(15) + 1;
				if (!v.contains(Hobby.fromInt(num))) {
					v.add(Hobby.fromInt(num));
				}
			}

			num = rand.nextInt(7) + 1;
			w.add(Pet.fromInt(num));

			for (int count = 0; count < 3; ++count) {
				num = rand.nextInt(18) + 1;
				if (!x.contains(Characteristic.fromInt(num))) {
					x.add(Characteristic.fromInt(num));
				}
			}

			for (int count = 0; count < 3; ++count) {
				num = rand.nextInt(18) + 1;
				if (!y.contains(Characteristic.fromInt(num))) {
					y.add(Characteristic.fromInt(num));
				}
			}
			
			num = rand.nextInt(3);
			z = GenderPreference.fromInt(num);

			String line = a + "," + b + "," + c + "," + d.toString() + "," + e.toString() + "," + f.toString() + ","
					+ g.toString() + "," + h + "," + i + "," + j + "," + k + "," + l + "," + m + "," + n + "," + o + ","
					+ p + "," + q + "," + r + "," + s + "," + t + "," + u + "," + vToReadable() + ",!," + wToReadable()
					+ ",!," + xToReadable() + ",!," + xToReadable() + ",!," + z.toString() + "\n";

			bw.write(line);

			a = new StringBuilder("");
			b = new StringBuilder("");
			c = new StringBuilder("");
			v = new ArrayList<Hobby>();
			w = new ArrayList<Pet>();
			x = new ArrayList<Characteristic>();
			y = new ArrayList<Characteristic>();
			
		}
		bw.newLine();
		bw.close();
		scanner.close();
	}

	public static String vToReadable() {
		String line = "";

		if (v.size() > 0) {
			line = v.get(0).toString();
		} else {
			line = Hobby.OTHER.toString();
		}
		for (int i = 1; i < v.size(); ++i) {
			line += "," + v.get(i).toString();
		}
		return line;
	}

	public static String xToReadable() {
		String line = "";
		if (x.size() > 0) {
			line = x.get(0).toString();
		} else {
			line = Characteristic.OTHER.toString();
		}
		for (int i = 1; i < x.size(); ++i) {
			line += "," + x.get(i).toString();
		}
		return line;
	}

	public static String yToReadable() {
		String line = "";
		if (y.size() > 0) {
			line = y.get(0).toString();
		} else {
			line = Characteristic.OTHER.toString();
		}
		for (int i = 1; i < y.size(); ++i) {
			line += "," + y.get(i).toString();
		}
		return line;
	}

	public static String wToReadable() {
		String line = "";
		if (w.size() > 0) {
			line = w.get(0).toString();
		} else {
			line = Pet.NONE.toString();
		}
		for (int i = 1; i < w.size(); ++i) {
			line += "," + w.get(i).toString();
		}
		return line;
	}
}

package uebung2;

public class Wurzel {

	public static void main(String[] args) {
		int n = 1765;
		int sqr = 0;
		int result;
		do {
			sqr++;
			result = sqr * sqr;
		} while (result < n);
		if (result == n) {
			System.out.println("Die Wurzel aus " + n + " ist " + sqr);
		} else {
			System.out.println("Keine Wurzel f�r " + n + " gefunden.");
			System.out.println("Die n�chst gr��ere Zahl mit einer Wurzel " + "in den nat�rlichen Zahlen ist "
					+ result + " die Wurzel ist " + sqr);
		}
	}

}

package bases;

public class Operadores {
	public static void main(String[] args) {
		var x = 1;

		System.out.println(x++);

		System.out.println(x);

		System.out.println(5 ^ 2); // XOR 101 y 010 = 111 (7)

		System.out.println(Integer.toBinaryString(5));

		System.out.println(Integer.toBinaryString(~5));

		System.out.println(Integer.toBinaryString(-20));

		System.out.println(Integer.toBinaryString(-20 >> 2));
		System.out.println(Integer.toBinaryString(-20 >>> 2));

		boolean b = true;

		System.out.println(b ? "VERDADERO" : "FALSO");

		int n1 = 10, n2 = 7;

		System.out.println(n1 > n2 ? n1 : n2);
	}
}

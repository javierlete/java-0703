package bases;

import java.util.Scanner;

public class LeerConsola {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Dime un número: ");
//		int numero = sc.nextInt();
//		sc.nextLine();
		
		int numero = Integer.parseInt(sc.nextLine());
		
		System.out.println(numero);

		System.out.print("Dime tu nombre: ");
		String nombre = sc.nextLine();
		
		System.out.println("Hola " + nombre);
		
		sc.close();
	}
}

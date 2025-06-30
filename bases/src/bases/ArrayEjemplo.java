package bases;

import java.util.Arrays;

public class ArrayEjemplo {
	public static void main(String[] args) {
		int[] arr;
		
		arr = new int[2];
		
		arr[0] = 5;
		arr[1] = 6;
//		arr[2] = 7; // ArrayIndexOutOfBoundsException
		
		System.out.println(Arrays.toString(arr));
		System.out.println(arr.length);
		
		var tablero = new char[8][8];
		
		tablero[0][0] = 't';
		tablero[1][0] = 'p';
		tablero[6][7] = 'P';
		tablero[7][7] = 'T';
		
		System.out.println(Arrays.toString(tablero[0]));
		System.out.println(Arrays.toString(tablero[1]));
		System.out.println(Arrays.toString(tablero[2]));
		System.out.println(Arrays.toString(tablero[3]));
		System.out.println(Arrays.toString(tablero[4]));
		System.out.println(Arrays.toString(tablero[5]));
		System.out.println(Arrays.toString(tablero[6]));
		System.out.println(Arrays.toString(tablero[7]));
	}
}

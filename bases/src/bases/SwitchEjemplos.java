package bases;

public class SwitchEjemplos {
	public static void main(String[] args) {
		var opcion = 2;

		switch (opcion) {
		case 1:
			System.out.println("UNO");
			break;
		case 2:
			System.out.println("DOS");
			break;
		default:
			System.out.println("OTRA");
		}

		switch (opcion) {
		case 1 -> System.out.println("UNO");
		case 2 -> System.out.println("DOS");
		default -> System.out.println("OTRA");
		}

		var mes = 6;
		int dias;

		switch (mes) {
		case 2:
			dias = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dias = 30;
			break;
		default:
			dias = 31;
		}

		System.out.println(dias);

		switch (mes) {
		case 2 -> dias = 28;
		case 4, 6, 9, 11 -> dias = 30;
		default -> dias = 31;
		}

		System.out.println(dias);

		dias = switch (mes) {
		case 2 -> 28;
		case 4, 6, 9, 11 -> 30;
		default -> 31;
		};

		System.out.println(dias);
	}
}

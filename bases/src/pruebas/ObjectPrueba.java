package pruebas;

public class ObjectPrueba {
	public static void main(String[] args) {
		Object o = new Object();

		System.out.println(o.getClass());
		System.out.println(o.hashCode());
		System.out.println(o.toString());
		System.out.println(o.equals(o));
	}
}

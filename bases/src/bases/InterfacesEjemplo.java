package bases;

import java.util.ArrayList;

public class InterfacesEjemplo {
	public static void main(String[] args) {
		var saco = new ArrayList<Esferico>();
		
		saco.add(new Naranja());
		saco.add(new Balon());
		
		for(var esferico: saco) {
			if(esferico instanceof Comestible comestible) {
				 comestible.comer();
			}
			
			esferico.rodar();
			
			if(esferico instanceof Comestible comestible) {
				comestible.comer();
			}
		}
	}
}

interface Esferico {
	void rodar();
}

interface Comestible {
	void comer();
}

class Fruto {}
class ObjetoDeporte {}

class Balon extends ObjetoDeporte implements Esferico {

	@Override
	public void rodar() {
		System.out.println("Balón rodando");
	}
	
}

class Naranja extends Fruto implements Comestible, Esferico {

	private boolean porElSuelo = false;
	
	@Override
	public void rodar() {
		System.out.println("Naranja rodando");
		porElSuelo = true;
	}

	@Override
	public void comer() {
		if(porElSuelo) {
			System.out.println("Puagh, que asco");
		} else {
			System.out.println("Ñam que rica");
		}
	}
	
}
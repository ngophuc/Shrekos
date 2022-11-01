package Source;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		
		int longeur=12;
		int hauteur=12;
		
		Plateau p = new Plateau(longeur, hauteur);
		
		ArrayList<Integer> coordTresor = new ArrayList<Integer>();
		Tresor t = new Tresor(coordTresor);
		t.positionAleatoire(longeur, hauteur, p.getPlateau());	
		
		ArrayList<Integer> coordMonstre = new ArrayList<Integer>();
		Monstre m = new Monstre(coordMonstre,1,1);
		m.positionAleatoire(longeur, hauteur, p.getPlateau());
		
		ArrayList<Integer> coordHeros = new ArrayList<Integer>();
		Hero h = new Hero(coordHeros,1,1);
		h.positionAleatoire(longeur, hauteur, p.getPlateau());
	
		while (h.getVie()!=0 && !(t.getCoord().equals(h.getCoord()))) {
			System.out.println("Heros : \t"+h.getCoord());
			System.out.println("Monstre : \t"+m.getCoord());
			System.out.println("Tresor : \t"+t.getCoord());
			m.deplacementMonstre(p.getPlateau());
			h.deplacementHero(p.getPlateau());
			if (m.getCoord().equals(h.getCoord())) {
				h.setVie(h.getVie()-m.getAttaque());
				System.out.println("Aie ta vie : \t"+h.getVie());
			}
		}
		
		System.out.println("Heros : \t"+h.getCoord());
		System.out.println("Monstre : \t"+m.getCoord());
		System.out.println("Tresor : \t"+t.getCoord());
				
		if (h.getVie()==0) {
			System.out.println("GAME OVER");
		}
		
		if (t.getCoord().equals(h.getCoord())) {
			System.out.println("WIN");
		}
	}
}


package Source;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// initialisation de la taille du plateau
		int longeur=12;
		int hauteur=12;
		
		// initialisation des objets plateau, monstre, tresor et de leurs coord
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
		
		// on peut jouer tant que le hero a de la vie et qu'il n'est pas sur la case tresor
		while (h.getVie()!=0 && !(t.getCoord().equals(h.getCoord()))) {
			// affichage des coord
			System.out.println("Heros : \t"+h.getCoord());
			System.out.println("Monstre : \t"+m.getCoord());
			System.out.println("Tresor : \t"+t.getCoord());
			// modification des coord de monstre et hero
			m.deplacementMonstre(p.getPlateau());
			h.deplacementHero(p.getPlateau());
			// si les coord de hero sont les memes que monstre alors hero perd de la vie
			if (m.getCoord().equals(h.getCoord())) {
				h.setVie(h.getVie()-m.getAttaque());
				System.out.println("Aie ta vie : \t"+h.getVie());
			}
		}
		
		System.out.println("Heros : \t"+h.getCoord());
		System.out.println("Monstre : \t"+m.getCoord());
		System.out.println("Tresor : \t"+t.getCoord());
		
		// annonce si le hero n'a plus de vie et qu'il a donc perdu
		if (h.getVie()==0) {
			System.out.println("GAME OVER");
		}
		
		// annonce si le hero a les memes coord que tresor et qu'il a donc gagne
		if (t.getCoord().equals(h.getCoord())) {
			System.out.println("WIN");
		}
	}
}


import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {

		// initialisation de la taille du plateau
		int longeur=12;
		int hauteur=12;
		int niveau=3;
		
		// initialisation des objets plateau, monstre, tresor et de leurs coord
		Plateau p = new Plateau(longeur,hauteur,niveau);
		
		ArrayList<List<Integer>> O =p.getObstacles();
		for (List<Integer> e: O) {
			System.out.println(e);
	}
//		System.out.println(p.getPlateau().size());
//		
//		for (List<Integer> e: p.getPlateau()) {
//			System.out.println(e);
//	}
}
}

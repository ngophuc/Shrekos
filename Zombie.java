package Source;

import java.util.ArrayList;
import java.util.List;

public class Zombie extends Monstre {
	
	public Zombie(ArrayList<Integer> coord, int vie, int attaque) {
		super(coord, vie, attaque);
	}

	public void deplacementZombie(ArrayList<List<Integer>> plateau) {
		ArrayList<Integer> testCoord;
		do {
			testCoord=positionMonstre();
		}
		while (mouvPossible(plateau, testCoord)==false);
		setCoord(testCoord);
	}

}

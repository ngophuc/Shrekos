package Source;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hero extends Personnage {
	
	public Hero(ArrayList<Integer> coord, int vie, int attaque) {
		super(coord, vie, attaque);
	}

	public ArrayList<Integer> positionHeros() {
		System.out.print("Saisissez direction heros (z,q,s,d) : ");
		Scanner sc = new Scanner(System.in);
		String cmd = sc.nextLine();
		// sc.close();
		return position(cmd);
	}
	
	public void deplacementHero(ArrayList<List<Integer>> plateau) {
		ArrayList<Integer> tesCoord;
		do {
			tesCoord=positionHeros();
		}
		while (mouvPossible(plateau, tesCoord)==false);
		setCoord(tesCoord);
	}
}

package Source;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
	
	private int longeur; //déifinition de la longueur du plateau
	private int hauteur; //définition de la hauteur du plateau
	
	private ArrayList<List<Integer>> plateau = new ArrayList<List<Integer>>(); //initialisation du plateau

	private ArrayList<List<Integer>> obstacles = new ArrayList<List<Integer>>(); //initialisation des obstacles
	
	public Plateau(int longeur, int hauteur) {
		this.hauteur=hauteur;
		this.longeur=longeur;
		ajoutObstacle();

	}
	
	public void obstacle() { 
		//crÃ©ation de la liste d'obstacle
		obstacles.add(new ArrayList<Integer>());
		obstacles.get(0).add(9);
		obstacles.get(0).add(8);
		obstacles.add(new ArrayList<Integer>());
		obstacles.get(1).add(9);
		obstacles.get(1).add(9);
		obstacles.add(new ArrayList<Integer>());
		obstacles.get(2).add(9);
		obstacles.get(2).add(10);
		obstacles.add(new ArrayList<Integer>());
		obstacles.get(3).add(10);
		obstacles.get(3).add(8);
		obstacles.add(new ArrayList<Integer>());
		obstacles.get(4).add(10);
		obstacles.get(4).add(9);
		obstacles.add(new ArrayList<Integer>());
		obstacles.get(5).add(10);
		obstacles.get(5).add(10);
	}//création de la liste d'obstacles par défaut
		
	public void creationPlateau(){ 	
		int z=0;
		for(int i=1; i<hauteur-1; i++) {			 			//crÃ©ation du plateau avec toutes les valeurs sans obstacle et sans les murs
            for(int j=1; j<longeur-1; j++) {
            	plateau.add(new ArrayList<Integer>());				//initialisation de nouvelles coordonnées
           	 	plateau.get(z).add(i);					//ajout de la coordoonÃ©e x
           	 	plateau.get(z).add(j);					//ajoute de la coordonnÃ©e y
           	 	z+=1;										// comptage de la longeur de la liste plateau
           	}
		}
	}
	
	public void ajoutObstacle(){
		int compteur;
		int reduction=0;
		obstacle();
		creationPlateau();
		//enregistrement des positions dans la liste plateau des obstacles (index)
		List<Integer> enregistreur=new ArrayList<Integer>();
		for (List<Integer> coorObst:obstacles) {
			compteur=0;
			for(List<Integer> coorPlat:plateau){
				if ((coorObst.get(0)==coorPlat.get(0))&&(coorObst.get(1)==coorPlat.get(1))) {
					enregistreur.add(compteur);
				}
					compteur+=1;
			}
		}
		//suppression des positions obstacles sur le plateau en pensant qu'a chaque boucle la liste diminue sa taille de 1
		for (int element:enregistreur) {
			plateau.remove(element-reduction);
			reduction+=1;
		}
	}
	
	public ArrayList<List<Integer>> getPlateau() {
		return plateau;
	}
	
	public ArrayList<List<Integer>> getObstacles() {
		return obstacles;
	}
}
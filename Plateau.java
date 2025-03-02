import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Plateau {
	Random random = new Random();
	int nb1;
	int nb2;
	private int longeur; //deifinition de la longueur du plateau
	private int hauteur; //definition de la hauteur du plateau
	private int niveau; // definition du niveau 1 2 ou 3
	
	private ArrayList<List<Integer>> plateau = new ArrayList<List<Integer>>(); //initialisation du plateau

	private ArrayList<List<Integer>> obstacles = new ArrayList<List<Integer>>(); //initialisation des obstacles
	
	public Plateau(int longeur, int hauteur,int niveau) {
		this.hauteur=hauteur;
		this.longeur=longeur;
		this.niveau=niveau;
		ajoutObstacle();

	}
	
//	public void obstacle() { 
//		//creation de la liste d'obstacle
//		obstacles.add(new ArrayList<Integer>());
//		obstacles.get(0).add(9);
//		obstacles.get(0).add(8);
//		obstacles.add(new ArrayList<Integer>());
//		obstacles.get(1).add(9);
//		obstacles.get(1).add(9);
//		obstacles.add(new ArrayList<Integer>());
//		obstacles.get(2).add(9);
//		obstacles.get(2).add(10);
//		obstacles.add(new ArrayList<Integer>());
//		obstacles.get(3).add(10);
//		obstacles.get(3).add(8);
//		obstacles.add(new ArrayList<Integer>());
//		obstacles.get(4).add(10);
//		obstacles.get(4).add(9);
//		obstacles.add(new ArrayList<Integer>());
//		obstacles.get(5).add(10);
//		obstacles.get(5).add(10);
//	}//creation de la liste d'obstacles par defaut

	
	public void obstacle() { 
		//determination du nombre d'obstacles en fonction du niveau
		int nbObstacles;
		if (niveau==1) {
			nbObstacles=7;
		}
		else if (niveau==2) {
			nbObstacles=15;
		}
		else {
			nbObstacles=20;
		}
		
		//creation de la liste d'obstacle
		ArrayList<Integer> test= new ArrayList<Integer>();
		for (int k=0;k<nbObstacles;k++) {
			//creation des coordonnees d'un obstacle hors des murs + test si il n'est pas deja dans la liste d'obstacle
			obstacles.add(new ArrayList<Integer>());
			nb1=random.nextInt(hauteur-2)+1;
			nb2=random.nextInt(longeur-2)+1;
			test.add(nb1);
			test.add(nb2);
			while (obstacles.contains(test)) {
				//on recherche un couple de coordonnees si celui trouve avant est deja dans la liste
				nb1=random.nextInt(hauteur-2)+1;
				nb2=random.nextInt(longeur-2)+1;
				}
			//on ajoute l'obstacle a la liste obstacles
			obstacles.get(k).add(nb2);
			obstacles.get(k).add(nb1);
		}		
		
		//tri de la liste dans l'ordre croissants des abscisses et ordonnees
        int taille = obstacles.size();  
        List<Integer> tmp = new ArrayList<Integer>();  
        for(int i1=0; i1 < taille; i1++) 
        {
                for(int j1=1; j1 < (taille-i1); j1++)
                {  
                        if((obstacles.get(j1-1).get(0) > obstacles.get(j1).get(0))||((obstacles.get(j1-1).get(0) == obstacles.get(j1).get(0))&&(obstacles.get(j1-1).get(1) > obstacles.get(j1).get(1))))
                        {
                                //echanges des elements
                                tmp = obstacles.get(j1-1);  
                                obstacles.set(j1-1,obstacles.get(j1));  
                                obstacles.set(j1,tmp);  
                        } 
                }
        }
   }

	//creation de la liste plateau par default (le plateau est une liste des coordonnees sur lesquelles les personnages peuvent aller
		
	public void creationPlateau(){ 	
		int z=0;
		for(int i=1; i<hauteur-1; i++) {			 			//creation du plateau avec toutes les valeurs sans obstacle et sans les murs
            for(int j=1; j<longeur-1; j++) {
            	plateau.add(new ArrayList<Integer>());				//initialisation de nouvelles coordonnees
           	 	plateau.get(z).add(i);					//ajout de la coordoonee x
           	 	plateau.get(z).add(j);					//ajoute de la coordonnee y
           	 	z+=1;										// comptage de la longeur de la liste plateau
           	}
		}
	}
	
	//suppression des obstacles au plateau
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

	public int getLongeur() {
		return longeur;
	}

	public int getHauteur() {
		return hauteur;
	}
}
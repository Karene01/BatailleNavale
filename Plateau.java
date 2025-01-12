import java.util.ArrayList;

public class Plateau {
    private Case[][] tabCasePlateau; // Grille de cases
    private ArrayList<Bateau> tabBateau; // Liste des bateaux sur le plateau


    // Getters pour les attributs
    public Case[][] getTabCasePlateau() {
        return tabCasePlateau;
    }

    public ArrayList<Bateau> getTabBateau() {
        return tabBateau;
    }

    /**
     * Constructeur de la classe Plateau.
     * Initialise la grille de cases et la liste des bateaux.
     */
    public Plateau() {
        this.tabCasePlateau = new Case[Configuration.getTailleGrille()][Configuration.getTailleGrille()];
        this.tabBateau = new ArrayList<>();
        initialiserPlateau(); // Initialise la grille
    }

    // Initialise le tableau de cases.
   private void initialiserPlateau() {
       for (int i = 0; i < Configuration.getTailleGrille(); i++) {
           for (int j = 0; j < Configuration.getTailleGrille(); j++) {
               tabCasePlateau[i][j] = new Case(i, j); // Crée une case pour chaque coordonnée
           }
       }
   }

   /**
     * Permet d'accéder à une case du plateau.
     * @param ligne Ligne de la case
     * @param colonne Colonne de la case
     * @return La case correspondante ou null si les coordonnées sont invalides
     */
    public Case getCase(int ligne, int colonne) {
        if (ligne >= 0 && ligne < Configuration.getTailleGrille() && colonne >= 0 && colonne < Configuration.getTailleGrille()) {
            return tabCasePlateau[ligne][colonne];
        }
        return null; // Retourne null si les coordonnées sont invalides
    }

    /**
     * Ajoute un bateau au plateau et met à jour les cases concernées.
     * @param bateau Le bateau à ajouter
     * @return true si le bateau a été ajouté avec succès, false sinon
     */
    public boolean ajoutBateau(Bateau bateau) {
        ArrayList<Case> casesBateau = bateau.getCasesBateau();

        // Vérifie que toutes les cases sont valides et disponibles
        for (Case c : casesBateau) {
            int ligne = c.getNumLigne();
            int colonne = c.getNumColonne();
            if (getCase(ligne, colonne) == null || getCase(ligne, colonne).getIdBateau() != 0) {
                return false; // Case invalide ou déjà occupée
            }
        }

        // Met à jour les cases et ajoute le bateau au tableau
        for (Case c : casesBateau) {
            int ligne = c.getNumLigne();
            int colonne = c.getNumColonne();
            tabCasePlateau[ligne][colonne].setIdBateau(bateau.getIdBateau());
        }
        tabBateau.add(bateau);
        return true;
    }

    /**
     * Vérifie si un tableau de cases aurait des cases voisines occupées dans le plateau.
     * @param casesBateau Liste des cases correspondant à un bateau
     * @return true si des cases voisines sont occupées, false sinon
     */
    public boolean aDesCasesVoisines(ArrayList<Case> casesBateau) {
        for (Case c : casesBateau) {
            int ligne = c.getNumLigne();
            int colonne = c.getNumColonne();

            // Parcourt toutes les cases voisines (y compris diagonales)
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue; // Ignore la case centrale

                    int voisinLigne = ligne + i;
                    int voisinColonne = colonne + j;

                    if (caseValide(voisinLigne, voisinColonne)
                            && tabCasePlateau[voisinLigne][voisinColonne].getIdBateau() != 0) {
                        return true; // Une case voisine est occupée
                    }
                    
                }
            }

        }
        return false; // Aucune case voisine occupée
    }

    /**
     * Vérifie si une case donnée est valide sur le plateau.
     * @param ligne Ligne de la case
     * @param colonne Colonne de la case
     * @return true si la case est dans les limites du plateau, false sinon
     */
    public boolean caseValide(int ligne, int colonne) {
        return ligne >= 0 && ligne < Configuration.getTailleGrille()
                && colonne >= 0 && colonne < Configuration.getTailleGrille();
    }

     /**
     * Vérifie si un tableau de cases est entièrement dans les limites du plateau.
     * @param listeCases Liste des cases correspondant à un bateau
     * @return true si toutes les cases sont dans les limites, false sinon
     */
    public boolean verifCasesDansLimites(ArrayList<Case> listeCases) {
        for (Case c : listeCases) {
            int ligne = c.getNumLigne();
            int colonne = c.getNumColonne();

            // Vérifie que chaque case est dans les limites du plateau
            if (!caseValide(ligne, colonne)) {
                return false; // Une case dépasse les limites
            }
        }
        return true; // Toutes les cases sont valides
    }

    /**
     * Retourne un bateau en fonction de son ID.
     * @param id Identifiant du bateau
     * @return Le bateau correspondant ou null s'il n'existe pas
     */
    public Bateau getBateauById(int id) {
        for (Bateau bateau : tabBateau) {
            if (bateau.getIdBateau() == id) {
                return bateau;
            }
        }
        return null; // Aucun bateau trouvé avec cet ID
    }

     /**
     * Affiche le plateau d’un joueur.
     * Les colonnes sont libellées avec des lettres et les lignes avec des chiffres.
     * Les états des cases sont affichés comme suit :
     * - '.' : case vide
     * - 'B' : case contenant un bateau
     * - 'X' : case touchée
     */
    public void afficherPlateauJoueur() {
        System.out.println("=== Plateau du joueur ===");

        // Affichage des en-têtes de colonnes (lettres)
        System.out.print("  ");
        for (int col = 0; col < Configuration.getTailleGrille(); col++) {
            System.out.print((char) ('A' + col) + " ");
        }
        System.out.println();

        // Affichage des lignes
        for (int ligne = 0; ligne < Configuration.getTailleGrille(); ligne++) {
            // Libellé de la ligne (numéro)
            System.out.print(ligne + " ");

            // Affichage des cases
            for (int col = 0; col < Configuration.getTailleGrille(); col++) {
                Case c = tabCasePlateau[ligne][col];
                if (c.getIdBateau() != 0 && c.isTouche()) {
                    System.out.print("X "); // Case touchée
                } else if (c.getIdBateau() != 0) {
                    System.out.print("B "); // Case contenant un bateau
                } else {
                    System.out.print(". "); // Case vide
                }
            }
            System.out.println();
        }

    }

    /**
 * Affiche les plateaux des deux joueurs côte à côte.
 * Pour chaque joueur, affiche son plateau avec ses bateaux et les tirs reçus.
 * @param joueur1 Premier joueur
 * @param joueur2 Second joueur
 */
/* 
    public void afficherPlateaux(Joueur joueur1, Joueur joueur2) {
        System.out.println("\n=== Plateaux de jeu ===");
        System.out.println(joueur1.getNomJoueur() + " VS " + joueur2.getNomJoueur());
    
        // Affichage des en-têtes de colonnes (lettres)
        System.out.print("  ");
        for (int col = 0; col < Configuration.getTailleGrille(); col++) {
            System.out.print((char) ('A' + col) + " ");
        }
        System.out.print("    |   ");
        for (int col = 0; col < Configuration.getTailleGrille(); col++) {
            System.out.print((char) ('A' + col) + " ");
        }
        System.out.println();
    
        // Affichage des lignes
        for (int ligne = 0; ligne < Configuration.getTailleGrille(); ligne++) {
            // Plateau du joueur 1 (montre ses bateaux)
            System.out.print(ligne + " ");
            for (int col = 0; col < Configuration.getTailleGrille(); col++) {
                Case c = joueur1.getPlateau().getCase(ligne, col);
                if (c.getIdBateau() != 0 && c.isTouche()) {
                    System.out.print("X "); // Bateau touché
                } else if (c.getIdBateau() != 0) {
                    System.out.print("B "); // Son bateau non touché
                } else if (c.isTouche()) {
                    System.out.print("O "); // Tir raté de l'adversaire
                } else {
                    System.out.print(". "); // Case vide
                }
            }
    
            // Séparateur
            System.out.print("    |   ");
    
            // Plateau du joueur 2 (cache ses bateaux, montre seulement les tirs)
            for (int col = 0; col < Configuration.getTailleGrille(); col++) {
                Case c = joueur2.getPlateau().getCase(ligne, col);
                if (c.isTouche()) {
                    if (c.getIdBateau() != 0) {
                        System.out.print("X "); // Tir réussi
                    } else {
                        System.out.print("O "); // Tir raté
                    }
                } else {
                    System.out.print(". "); // Case non découverte
                }
            }
            System.out.println();
        }
    
        System.out.println("\nLégende :");
        System.out.println("B : Votre bateau    X : Touché    O : Raté    . : Inconnu/Vide");
    }
*/
public void afficherPlateaux(Joueur joueurActuel, Joueur joueurAdverse) {
    System.out.println("\n=== Plateaux de jeu ===");
    System.out.println(joueurActuel.getNomJoueur() + " VS " + joueurAdverse.getNomJoueur());

    // Affichage des en-têtes de colonnes (lettres)
    System.out.print("  ");
    for (int col = 0; col < Configuration.getTailleGrille(); col++) {
        System.out.print((char) ('A' + col) + " ");
    }
    System.out.print("    |   ");
    for (int col = 0; col < Configuration.getTailleGrille(); col++) {
        System.out.print((char) ('A' + col) + " ");
    }
    System.out.println();

    // Affichage des lignes
    for (int ligne = 0; ligne < Configuration.getTailleGrille(); ligne++) {
        System.out.print(ligne + " ");
        
        // Plateau du joueur actuel (gauche)
        for (int col = 0; col < Configuration.getTailleGrille(); col++) {
            Case c = joueurActuel.getPlateau().getCase(ligne, col);
            if (c.isTouche()) {
                if (c.getIdBateau() != 0) {
                    System.out.print("X "); // Bateau touché
                } else {
                    System.out.print("O "); // Tir raté
                }
            } else if (c.getIdBateau() != 0) {
                System.out.print("B "); // Vos bateaux non touchés
            } else {
                System.out.print(". "); // Case vide
            }
        }

        System.out.print("    |   ");

        // Plateau de l'adversaire (droite)
        for (int col = 0; col < Configuration.getTailleGrille(); col++) {
            Case c = joueurAdverse.getPlateau().getCase(ligne, col);
            if (c.isTouche()) {
                if (c.getIdBateau() != 0) {
                    System.out.print("X "); // Bateau touché
                } else {
                    System.out.print("O "); // Tir raté
                }
            } else {
                System.out.print(". "); // Case inconnue
            }
        }
        System.out.println();
    }

    System.out.println("\nLégende :");
    System.out.println("B : Votre bateau    X : Touché    O : Raté    . : Inconnu/Vide");
}
}

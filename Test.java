import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        
        // Test de la classe Configuration
        System.out.println("====================== TEST CONFIGURATION ======================");
        // Test de la méthode getTailleGrille
        /* System.out.println("Taille de la grille : " + Configuration.getTailleGrille());

        // Test du nombre de bateaux
        System.out.println("Nombre de bateaux : " + Configuration.getNombreBateaux());

         // Test d'affichage de tous les bateaux
         Configuration.afficherTousBateaux();

        // Test de la méthode getBateau
        // Test si le bateau existe
        try {
            String[] bateau = Configuration.getBateau(2);
            System.out.println("Bateau obtenu : " + Arrays.toString(bateau));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

         // Test si le bateau n'existe pas, avec un indice invalide
          try {
            Configuration.getBateau(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception attendue : " + e.getMessage());
        }

        // Test d'affichage d'un bateau spécifique
        Configuration.afficherBateau(1);
*/
        // Test de la classe Menu
        System.out.println("====================== TEST MENU ========================");
         // Instanciation du menu
        /*  Menu menu = new Menu();

         // Test de la méthode choixJoueur
         System.out.println("\nTest de choixJoueur (interactif, vérifiez les comportements) :");
         menu.choixJoueur();
 
         // Test de la méthode afficherReglesJeu
         System.out.println("\nTest de afficherReglesJeu :");
         menu.afficherReglesJeu();
 
         // Test de la méthode jouerPartie
         System.out.println("\nTest de jouerPartie :");
         menu.jouerPartie();
 
         // Test de la méthode quitter (ne pas appeler pour éviter de quitter le programme)
         System.out.println("\nTest de quitter : (non appelé pour éviter de stopper le test)");
 
         // Nettoyage de la console
         System.out.println("\nTest de nettoyerConsole :");
         menu.nettoyerConsole();

        */
          // Test de la classe Case
        System.out.println("====================== TEST Case ========================");
        // Création d'une case
       /*  Case case1 = new Case(3, 5);
        // Afficher toutes les caractéristiques de la case
        System.out.println(case1.toString());
        // Toucher la case
        case1.setTouche(true);
        System.out.println(case1.toString());
        // Changer l'idBateau
        case1.setIdBateau(2);
        System.out.println(case1.toString());

        // Création d'une autre case
        Case case2 = new Case(5, 3);
        System.out.println("Nouvelle case : " + case2);
      */
         System.out.println("====================== TEST BATEAU ========================");
     // Création d'une liste de cases pour le bateau
    /*  ArrayList<Case> casesBateau = new ArrayList<>();
     casesBateau.add(new Case(0, 0));
     casesBateau.add(new Case(0, 1));
     casesBateau.add(new Case(0, 2));

     // Création d'un bateau
     Bateau bateau = new Bateau(1, "Porte-Avions", casesBateau);

     // Affichage des informations du bateau
     System.out.println("Bateau créé : " + bateau);

     // Vérification de l'état du bateau (non coulé)
     System.out.println("Le bateau est-il coulé ? " + bateau.estCoule());

     // Toucher toutes les cases du bateau
     for (Case c : casesBateau) {
         c.setTouche(true);
     }

     // Vérification de l'état du bateau (coulé)
     System.out.println("Le bateau est-il coulé après avoir touché toutes ses cases ? " + bateau.estCoule());

     // Test de la méthode getCellXY
     System.out.println("Case à la position (0,1) : " + bateau.getCellXY(0, 1));

     // Test de la méthode getPositionCase
     System.out.println("Case à l'indice 2 : " + bateau.getPositionCase(2));

     // Test de la méthode getTaille
     System.out.println("Taille du bateau : " + bateau.getTaille());

     // Test des getters
     System.out.println("ID du bateau : " + bateau.getIdBateau());
     System.out.println("Nom du bateau : " + bateau.getNomBateau());
      */

      System.out.println("====================== TEST PLATEAU ========================");
      Plateau plateau = new Plateau();
/* 
      System.out.println("====================== TEST DE LA MÉTHODE aDesCasesVoisines ========================");

        // Cas 1 : Aucun bateau sur le plateau
        ArrayList<Case> cases1 = new ArrayList<>();
        cases1.add(new Case(3, 3));
        cases1.add(new Case(3, 4));
        cases1.add(new Case(3, 5));

        System.out.println("Cas 1 : Pas de bateau sur le plateau");
        System.out.println("A des cases voisines ? " + plateau.aDesCasesVoisines(cases1)); // Doit retourner false

        // Ajout d'un bateau sur le plateau
        ArrayList<Case> casesBateau1 = new ArrayList<>();
        casesBateau1.add(new Case(2, 2));
        casesBateau1.add(new Case(2, 3));
        casesBateau1.add(new Case(2, 4));
        Bateau bateau1 = new Bateau(1, "Porte-Avions", casesBateau1);
        plateau.ajoutBateau(bateau1);

        // Cas 2 : Test avec un bateau déjà présent
        System.out.println("\nCas 2 : Un bateau est présent sur le plateau");
        System.out.println("A des cases voisines ? " + plateau.aDesCasesVoisines(cases1)); // Doit retourner true

        // Cas 3 : Vérification sur une case éloignée
        ArrayList<Case> casesEloignees = new ArrayList<>();
        casesEloignees.add(new Case(5, 5));
        System.out.println("\nCas 3 : Vérification sur une case éloignée");
        System.out.println("A des cases voisines ? " + plateau.aDesCasesVoisines(casesEloignees)); // Doit retourner false

        // Cas 4 : Vérification sur les bords
        ArrayList<Case> casesBord = new ArrayList<>();
        casesBord.add(new Case(0, 0));
        System.out.println("\nCas 4 : Vérification sur une case en bordure");
        System.out.println("A des cases voisines ? " + plateau.aDesCasesVoisines(casesBord)); // Doit retourner false

        // Ajout d'un bateau proche des bords
        ArrayList<Case> casesBateau2 = new ArrayList<>();
        casesBateau2.add(new Case(1, 1));
        casesBateau2.add(new Case(1, 2));
        casesBateau2.add(new Case(1, 3));
        Bateau bateau2 = new Bateau(2, "Destroyer", casesBateau2);
        plateau.ajoutBateau(bateau2);

        // Cas 5 : Test sur une case voisine du bateau ajouté
        ArrayList<Case> casesVoisines = new ArrayList<>();
        casesVoisines.add(new Case(0, 2));
        System.out.println("\nCas 5 : Vérification sur une case voisine d'un bateau");
        System.out.println("A des cases voisines ? " + plateau.aDesCasesVoisines(casesVoisines)); // Doit retourner true
 */   

 System.out.println("====================== TEST DE LA MÉTHODE caseValide ========================");
/* 
 // Cas 1 : Case valide au centre du plateau
 System.out.println("Case (5, 5) est-elle valide ? " + plateau.caseValide(5, 5)); // Doit retourner true

 // Cas 2 : Case sur la bordure
 System.out.println("Case (0, 0) est-elle valide ? " + plateau.caseValide(0, 0)); // Doit retourner true
 System.out.println("Case (9, 9) est-elle valide ? " + plateau.caseValide(Configuration.getTailleGrille() - 1, Configuration.getTailleGrille() - 1)); // Doit retourner true

 // Cas 3 : Case hors du plateau (négative)
 System.out.println("Case (-1, 5) est-elle valide ? " + plateau.caseValide(-1, 5)); // Doit retourner false
 System.out.println("Case (5, -1) est-elle valide ? " + plateau.caseValide(5, -1)); // Doit retourner false

 // Cas 4 : Case hors du plateau (supérieure à la taille)
 System.out.println("Case (10, 5) est-elle valide ? " + plateau.caseValide(Configuration.getTailleGrille(), 5)); // Doit retourner false
 System.out.println("Case (5, 10) est-elle valide ? " + plateau.caseValide(5, Configuration.getTailleGrille())); // Doit retourner false

 // Cas 5 : Case valide proche de la bordure
 System.out.println("Case (9, 0) est-elle valide ? " + plateau.caseValide(Configuration.getTailleGrille() - 1, 0)); // Doit retourner true
 System.out.println("Case (0, 9) est-elle valide ? " + plateau.caseValide(0, Configuration.getTailleGrille() - 1)); // Doit retourner true

*/

System.out.println("====================== TEST DE LA MÉTHODE verifCasesDansLimites ========================");
/* 
// Cas 1 : Toutes les cases sont dans les limites
ArrayList<Case> casesValides = new ArrayList<>();
casesValides.add(new Case(2, 2));
casesValides.add(new Case(2, 3));
casesValides.add(new Case(2, 4));
System.out.println("Cas 1 : Toutes les cases dans les limites");
System.out.println("Les cases sont-elles dans les limites ? " + plateau.verifCasesDansLimites(casesValides)); // Doit retourner true

// Cas 2 : Une case dépasse les limites (ligne négative)
ArrayList<Case> casesLigneNegative = new ArrayList<>();
casesLigneNegative.add(new Case(-1, 2));
casesLigneNegative.add(new Case(0, 3));
System.out.println("\nCas 2 : Une case avec ligne négative");
System.out.println("Les cases sont-elles dans les limites ? " + plateau.verifCasesDansLimites(casesLigneNegative)); // Doit retourner false

// Cas 3 : Une case dépasse les limites (colonne négative)
ArrayList<Case> casesColonneNegative = new ArrayList<>();
casesColonneNegative.add(new Case(2, -1));
casesColonneNegative.add(new Case(2, 0));
System.out.println("\nCas 3 : Une case avec colonne négative");
System.out.println("Les cases sont-elles dans les limites ? " + plateau.verifCasesDansLimites(casesColonneNegative)); // Doit retourner false

// Cas 4 : Une case dépasse les limites (ligne hors plateau)
ArrayList<Case> casesLigneHorsLimites = new ArrayList<>();
casesLigneHorsLimites.add(new Case(Configuration.getTailleGrille(), 1));
casesLigneHorsLimites.add(new Case(Configuration.getTailleGrille() + 1, 2));
System.out.println("\nCas 4 : Une case avec ligne hors des limites");
System.out.println("Les cases sont-elles dans les limites ? " + plateau.verifCasesDansLimites(casesLigneHorsLimites)); // Doit retourner false

// Cas 5 : Une case dépasse les limites (colonne hors plateau)
ArrayList<Case> casesColonneHorsLimites = new ArrayList<>();
casesColonneHorsLimites.add(new Case(1, Configuration.getTailleGrille()));
casesColonneHorsLimites.add(new Case(2, Configuration.getTailleGrille() + 1));
System.out.println("\nCas 5 : Une case avec colonne hors des limites");
System.out.println("Les cases sont-elles dans les limites ? " + plateau.verifCasesDansLimites(casesColonneHorsLimites)); // Doit retourner false

// Cas 6 : Mélange de cases valides et invalides
ArrayList<Case> casesMelange = new ArrayList<>();
casesMelange.add(new Case(5, 5)); // Valide
casesMelange.add(new Case(-1, 5)); // Invalide
System.out.println("\nCas 6 : Mélange de cases valides et invalides");
System.out.println("Les cases sont-elles dans les limites ? " + plateau.verifCasesDansLimites(casesMelange)); // Doit retourner false
*/
 
System.out.println("====================== TEST DE LA MÉTHODE getBateauById ========================");
/* 
        // Ajout de plusieurs bateaux avec des IDs distincts
        ArrayList<Case> casesBateau1 = new ArrayList<>();
        casesBateau1.add(new Case(0, 0));
        casesBateau1.add(new Case(0, 1));
        casesBateau1.add(new Case(0, 2));
        Bateau bateau1 = new Bateau(1, "Porte-Avions", casesBateau1);
        plateau.ajoutBateau(bateau1);

        ArrayList<Case> casesBateau2 = new ArrayList<>();
        casesBateau2.add(new Case(1, 3));
        casesBateau2.add(new Case(1, 4));
        casesBateau2.add(new Case(1, 5));
        Bateau bateau2 = new Bateau(2, "Destroyer", casesBateau2);
        plateau.ajoutBateau(bateau2);

        ArrayList<Case> casesBateau3 = new ArrayList<>();
        casesBateau3.add(new Case(2, 6));
        casesBateau3.add(new Case(2, 7));
        casesBateau3.add(new Case(2, 8));
        Bateau bateau3 = new Bateau(3, "Sous-Marin", casesBateau3);
        plateau.ajoutBateau(bateau3);

        // Test pour récupérer des bateaux existants
        System.out.println("Recherche du bateau avec ID 1 : " + plateau.getBateauById(1)); // Doit retourner le bateau1
        System.out.println("Recherche du bateau avec ID 2 : " + plateau.getBateauById(2)); // Doit retourner le bateau2
        System.out.println("Recherche du bateau avec ID 3 : " + plateau.getBateauById(3)); // Doit retourner le bateau3

        // Test pour un bateau inexistant
        System.out.println("Recherche du bateau avec ID 4 : " + plateau.getBateauById(4)); // Doit retourner null

        // Test pour un ID négatif
        System.out.println("Recherche du bateau avec ID -1 : " + plateau.getBateauById(-1)); // Doit retourner null
*/  

System.out.println("====================== TEST DE LA MÉTHODE afficherPlateauJoueur ========================");
/* 
       // Ajout de bateaux
       ArrayList<Case> casesBateau1 = new ArrayList<>();
       casesBateau1.add(new Case(0, 0));
       casesBateau1.add(new Case(0, 1));
       casesBateau1.add(new Case(0, 2));
       Bateau bateau1 = new Bateau(1, "Porte-Avions", casesBateau1);
       plateau.ajoutBateau(bateau1);

       ArrayList<Case> casesBateau2 = new ArrayList<>();
       casesBateau2.add(new Case(2, 2));
       casesBateau2.add(new Case(2, 3));
       casesBateau2.add(new Case(2, 4));
       Bateau bateau2 = new Bateau(2, "Destroyer", casesBateau2);
       plateau.ajoutBateau(bateau2);

       // Affichage du plateau
       System.out.println("\nAffichage du plateau après ajout des bateaux :");
       plateau.afficherPlateauJoueur();
*/ 

System.out.println("====================== TEST DE LA CLASSE JOUEURHUMAIN ======================");
System.out.println("=== Simulation d'un combat entre 2 joueurs humains ===\n");
/* 
// Création des joueurs
JoueurHumain joueur1 = new JoueurHumain();
JoueurHumain joueur2 = new JoueurHumain();

// Test 1 : Affichage des plateaux vides
System.out.println("Test 1: Plateaux vides");
joueur1.getPlateau().afficherPlateaux(joueur1, joueur2);

// Test 2 : Placement des bateaux
System.out.println("\nTest 2: Placement des bateaux");
System.out.println("Placement des bateaux pour " + joueur1.getNomJoueur());
joueur1.placerBateaux();

System.out.println("\nPlacement des bateaux pour " + joueur2.getNomJoueur());
joueur2.placerBateaux();

// Affichage après placement
System.out.println("\nAffichage après placement des bateaux :");
joueur1.getPlateau().afficherPlateaux(joueur1, joueur2);

// Test 3 : Simulation de quelques tirs
System.out.println("\nTest 3: Simulation de tirs");

// Quelques tirs du joueur 1 vers joueur 2
System.out.println(joueur1.getNomJoueur() + " tire sur " + joueur2.getNomJoueur());
joueur1.tirer(joueur2);

// Quelques tirs du joueur 2 vers joueur 1
System.out.println("\n" + joueur2.getNomJoueur() + " tire sur " + joueur1.getNomJoueur());
joueur2.tirer(joueur1);

// Affichage final après les tirs
System.out.println("\nAffichage final après les tirs :");
joueur1.getPlateau().afficherPlateaux(joueur1, joueur2);

// Affichage des statistiques des deux joueurs
System.out.println("\n=== Statistiques de la partie ===");
System.out.println("\nStatistiques de " + joueur1.getNomJoueur() + ":");
joueur1.afficherStatistiques();
System.out.println("\nStatistiques de " + joueur2.getNomJoueur() + ":");
joueur2.afficherStatistiques();

System.out.println("\n=== Fin des tests ===");

*/
System.out.println("=== Test du Joueur Ordinateur ===\n");
/* 
// Création des joueurs
JoueurOrdinateur bot1 = new JoueurOrdinateur();
JoueurOrdinateur bot2 = new JoueurOrdinateur();

// Test 1: Vérification des noms
System.out.println("Test 1: Noms des bots");
System.out.println("Bot 1: " + bot1.getNomJoueur());
System.out.println("Bot 2: " + bot2.getNomJoueur());

// Test 2: Placement des bateaux
System.out.println("\nTest 2: Placement des bateaux");
System.out.println("Placement pour " + bot1.getNomJoueur());
bot1.placerBateaux();
System.out.println("Nombre de bateaux placés: " + bot1.getPlateau().getTabBateau().size());

System.out.println("\nPlacement pour " + bot2.getNomJoueur());
bot2.placerBateaux();
System.out.println("Nombre de bateaux placés: " + bot2.getPlateau().getTabBateau().size());

// Affichage des plateaux initiaux
System.out.println("\nPlateaux après placement:");
bot1.getPlateau().afficherPlateaux(bot1, bot2);

// Test 3: Simulation de plusieurs tirs
System.out.println("\nTest 3: Simulation de 5 tours de tirs");
for (int i = 0; i < 5; i++) {
    System.out.println("\nTour " + (i+1) + ":");
    System.out.println("\nTir de " + bot1.getNomJoueur());
    bot1.tirer(bot2);
    
    System.out.println("\nTir de " + bot2.getNomJoueur());
    bot2.tirer(bot1);
}

// Affichage final
System.out.println("\nÉtat final des plateaux:");
bot1.getPlateau().afficherPlateaux(bot1, bot2);

// Affichage des statistiques
System.out.println("\n=== Statistiques finales ===");
System.out.println("\nStatistiques de " + bot1.getNomJoueur() + ":");
bot1.afficherStatistiques();
System.out.println("\nStatistiques de " + bot2.getNomJoueur() + ":");
bot2.afficherStatistiques();

System.out.println("\n=== Fin des tests ===");
*/

System.out.println("=== Test de la classe Partie ===");
/*  
try {
    // Création et initialisation d'une nouvelle partie
    Partie partie = new Partie();
    partie.initPartie();
    
    // Jouer la partie
    partie.jouerPartie();
    
} catch (Exception e) {
    System.out.println("Erreur lors de la partie : " + e.getMessage());
    e.printStackTrace();
}
   */ 
}
}

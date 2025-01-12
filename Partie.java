import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class Partie {
    private Joueur joueur1;
    private Joueur joueur2;
    private int tour; // 1 pour joueur1, 2 pour joueur2
    private String nomVainqueur;
    private BufferedReader reader;
    private boolean partieTerminee;

    public Partie() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.partieTerminee = false;
        this.tour = 1;
    }

    /**
     * Initialise la partie en créant les joueurs selon les choix de l'utilisateur
     */
    /*public void initPartie() throws IOException {
        System.out.println("\n=== Nouvelle Partie ===");
        System.out.println("Types de joueurs disponibles :");
        System.out.println("1. Joueur Humain");
        System.out.println("2. Ordinateur");

        // Choix du premier joueur
        System.out.println("\nChoisir le type du Joueur 1 (1 pour Humain ou 2 pour Ordinateur):");
        joueur1 = creerJoueur(lireChoix());

        // Choix du deuxième joueur
        System.out.println("\nChoisir le type du Joueur 2 (1 pour Humain ou 2 pour Ordinateur):");
        joueur2 = creerJoueur(lireChoix());

        // Placement des bateaux
        System.out.println("\n" + joueur1.getNomJoueur() + " place ses bateaux:");
        joueur1.placerBateaux();

        System.out.println("\n" + joueur2.getNomJoueur() + " place ses bateaux:");
        joueur2.placerBateaux();

        // Tirage au sort du premier joueur
        if (new Random().nextBoolean()) {
            tour = 2;
            System.out.println("\n" + joueur2.getNomJoueur() + " commence!");
        } else {
            System.out.println("\n" + joueur1.getNomJoueur() + " commence!");
        }
    }*/

    public void initPartie() throws IOException {
        System.out.println("\n=== Nouvelle Partie ===");
        System.out.println("Types de joueurs disponibles :");
        System.out.println("1. Joueur Humain");
        System.out.println("2. Ordinateur");
    
        // Choix du premier joueur
        System.out.println("\nChoisir le type du Joueur 1 (1 pour Humain ou 2 pour Ordinateur):");
        joueur1 = creerJoueur(lireChoix());
    
        // Choix du deuxième joueur
        System.out.println("\nChoisir le type du Joueur 2 (1 pour Humain ou 2 pour Ordinateur):");
        joueur2 = creerJoueur(lireChoix());
    
        // Placement des bateaux pour le joueur 1
        System.out.println("\n" + joueur1.getNomJoueur() + " place ses bateaux:");
        joueur1.placerBateaux();
    
        // Si les deux joueurs sont humains, ajouter un écran de transition
        if (joueur1 instanceof JoueurHumain && joueur2 instanceof JoueurHumain) {
            System.out.println("\nAppuyez sur Entrée pour passer au placement des bateaux de " + 
                              joueur2.getNomJoueur() + " (assurez-vous que " + joueur1.getNomJoueur() + 
                              " ne regarde pas)");
            reader.readLine();
            // Ajouter plusieurs lignes vides pour "cacher" le plateau précédent
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    
        // Placement des bateaux pour le joueur 2
        System.out.println("\n" + joueur2.getNomJoueur() + " place ses bateaux:");
        joueur2.placerBateaux();
    
        // Tirage au sort du premier joueur
        if (new Random().nextBoolean()) {
            tour = 2;
            System.out.println("\n" + joueur2.getNomJoueur() + " commence!");
        } else {
            System.out.println("\n" + joueur1.getNomJoueur() + " commence!");
        }
    }

    /**
     * Lit le choix de l'utilisateur
     */
    private int lireChoix() throws IOException {
        int choix = 0;
        while (choix != 1 && choix != 2) {
            try {
                String input = reader.readLine();
                choix = Integer.parseInt(input);
                if (choix != 1 && choix != 2) {
                    System.out.println("Choix invalide. Entrez 1 ou 2:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Entrez 1 ou 2:");
            }
        }
        return choix;
    }

    /**
     * Crée un joueur selon le type choisi
     */
    private Joueur creerJoueur(int type) {
        return (type == 1) ? new JoueurHumain() : new JoueurOrdinateur();
    }

    /**
     * Joue la partie jusqu'à ce qu'il y ait un vainqueur
     */
   /*  public void jouerPartie() {
        while (!partieTerminee) {
            // Affichage des plateaux
            joueur1.getPlateau().afficherPlateaux(joueur1, joueur2);
    
            // Tour du joueur actuel
            Joueur joueurActuel = (tour == 1) ? joueur1 : joueur2;
            Joueur joueurAdverse = (tour == 1) ? joueur2 : joueur1;
    
            System.out.println("\nTour de " + joueurActuel.getNomJoueur());
            joueurActuel.tirer(joueurAdverse);
    
            // Vérifie si le joueur actuel a gagné
            boolean victoire = verifierVictoire(joueurAdverse);
            if (victoire) {
                partieTerminee = true;
                nomVainqueur = joueurActuel.getNomJoueur();
                break;  // Sort immédiatement de la boucle
            }
    
            // Change de joueur
            tour = (tour == 1) ? 2 : 1;
        }
        // Une fois sorti de la boucle, affiche les résultats finaux
        finPartie();
    }*/

    public void jouerPartie() {
        while (!partieTerminee) {
            // Tour du joueur actuel
            Joueur joueurActuel = (tour == 1) ? joueur1 : joueur2;
            Joueur joueurAdverse = (tour == 1) ? joueur2 : joueur1;
    
            System.out.println("\nTour de " + joueurActuel.getNomJoueur());
            // Affichage des plateaux avec l'ordre correct selon qui joue
            // Le plateau du joueur actuel doit toujours être à gauche
            joueur1.getPlateau().afficherPlateaux(joueurActuel, joueurAdverse);
    
            joueurActuel.tirer(joueurAdverse);
    
            // Vérifie si le joueur actuel a gagné
            boolean victoire = verifierVictoire(joueurAdverse);
            if (victoire) {
                partieTerminee = true;
                nomVainqueur = joueurActuel.getNomJoueur();
                break;
            }
    
            // Change de joueur
            tour = (tour == 1) ? 2 : 1;
        }
        finPartie();
    }
    /**
     * Vérifie si tous les bateaux d'un joueur sont coulés
     */
    private boolean verifierVictoire(Joueur joueur) {
        int totalBateaux = joueur.getPlateau().getTabBateau().size();
        int bateauxCoules = 0;
        
        System.out.println("\nVérification des bateaux de " + joueur.getNomJoueur() + ":");
        for (Bateau bateau : joueur.getPlateau().getTabBateau()) {
            if (bateau.estCoule()) {
                bateauxCoules++;
                System.out.println("- " + bateau.getNomBateau() + " est coulé");
            } else {
                System.out.println("- " + bateau.getNomBateau() + " n'est pas coulé");
                // Affichage des cases touchées/non touchées pour ce bateau
                for (Case c : bateau.getCasesBateau()) {
                    System.out.println("  Position (" + c.getNumLigne() + "," + c.getNumColonne() + 
                                     ") - Touchée: " + c.isTouche());
                }
            }
        }
        System.out.println("Bateaux coulés: " + bateauxCoules + "/" + totalBateaux);
        return bateauxCoules == totalBateaux;
    }

    /**
     * Affiche les résultats de la partie
     */
    private void finPartie() {
        System.out.println("\n=== Fin de la partie ===");
        System.out.println("Vainqueur : " + nomVainqueur + " !");
        
        // Affichage final des plateaux
        joueur1.getPlateau().afficherPlateaux(joueur1, joueur2);
        
        // Statistiques
        System.out.println("\nStatistiques de " + joueur1.getNomJoueur() + ":");
        joueur1.afficherStatistiques();
        
        System.out.println("\nStatistiques de " + joueur2.getNomJoueur() + ":");
        joueur2.afficherStatistiques();
    }
}
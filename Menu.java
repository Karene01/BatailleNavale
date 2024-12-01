import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Menu {
    private BufferedReader reader;

    // Constructeur
    public Menu() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    // Méthode principale pour gérer les choix du menu
    public void choixJoueur() {
        // Le joueur doit saisir un nombre valide, si ce n'est pas le cas, il lui sera demandé continuellement
        String input = "";
        do {
            System.out.println("===== Menu Principal =====");
            System.out.println("1. Jouer une partie");
            System.out.println("2. Afficher les règles du jeu");
            System.out.println("3. Quitter");
            System.out.print("Saisissez votre choix : [1, 2 ou 3] ");

            try {
                input = reader.readLine();
            } catch (java.io.IOException e) {
                System.out.println("Une erreur est survenue : " + e);
            }

            // traitement de la demande du joueur selon le chiffre saisi
            if (Pattern.matches("[123]", input)) {
                int choix = Integer.parseInt(input);
                switch (choix) {
                    case 1:
                        jouerPartie();
                        break;
                    case 2:
                        afficherReglesJeu();
                        break;
                    case 3:
                        quitter();
                        break;
                    default:
                        System.out.println("Choix invalide !");
                }
            } else {
                System.out.println("Saisie invalide, veuillez entrer 1, 2 ou 3.");
            }
        } while (true);
    }

    // Méthode pour afficher les règles du jeu
    public void afficherReglesJeu() {
        System.out.println("\n===== Règles du Jeu =====");
        System.out.println("1. Chaque joueur dispose de 5 navires de tailles différentes.");
        System.out.println("2. Les navires sont placés sur une grille.");
        System.out.println("3. À tour de rôle, les joueurs essaient de deviner les positions des navires adverses.");
        System.out.println("4. Le jeu se termine quand tous les navires d'un joueur sont coulés.");
        System.out.println("Appuyez sur Entrée pour retourner au menu.");
        try {
            reader.readLine(); // Attendre une entrée pour revenir au menu
        } catch (java.io.IOException e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        }
        
    }

    // Méthode pour quitter le programme
    public void quitter() {
        System.out.println("Merci d'avoir joué ! À bientôt.");
        System.exit(0);
    }

    // Méthode pour jouer une partie
    public void jouerPartie() {
        System.out.println("Lancement d'une nouvelle partie...");
        // Initialisation des joueurs
       /* Joueur joueur1 = new Humain("Joueur 1");
        Joueur joueur2 = new Ordinateur();
        Partie partie = new Partie(joueur1, joueur2);
        partie.demarrer();*/ 
    }

    // Méthode pour nettoyer la console
    public void nettoyerConsole() {
        try {
            new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
        } catch (final Exception e) {
            System.out.println("Erreur lors du nettoyage de la console : " + e.getMessage());
        }
    }
}

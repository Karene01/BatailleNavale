import java.util.Arrays;

public abstract class Configuration {

    // Tableau des spécifications des bateaux
    private final static String[][] bateaux = {
        {"1", "Porte-avions", "5"},
        {"2", "Cuirasse", "4"},
        {"3", "Croiseur", "3"},
        {"4", "Croiseur", "3"},
        {"5", "Torpimmeur", "2"}
    };

     // Taille de la grille
     private static final int TAILLE_GRILLE = 10;

     // Méthode pour obtenir toutes les spécifications des bateaux
     public static String[][] getBateaux() {
        return bateaux;
    }

    // Méthode pour obtenir la description d'un bateau spécifique par son identifiant
    public static String[] getBateau(int indice) {
        if (indice < 0 || indice >= bateaux.length) {
            throw new IndexOutOfBoundsException("Indice de bateau invalide : " + indice);
        }
        return bateaux[indice]; 
    }

    //Méthode pour afficher les spécifications d'un bateau en utilisant getBateaux()
    public static void afficherBateau(int indice) {
        System.out.println("Bateau " + indice + " : " + Arrays.toString(getBateau(indice)));
    }
    
     // Méthode pour connaître le nombre de bateaux
     public static int getNombreBateaux() {
        return bateaux.length;
    }

    // Méthode pour obtenir la taille de la grille
    public static int getTailleGrille() {
        return TAILLE_GRILLE;
    }
}
public class Test {
    public static void main(String[] args) {
        // Test de la classe Configuration
        System.out.println("===== TEST CONFIGURATION =====");
        // Afficher le nombre de bateaux
        System.out.println("Nombre de bateaux : " + Configuration.getNombreBateaux());
        // Afficher la taille de la grille
        System.out.println("Taille de la grille : " + Configuration.getTailleGrille());

        // Test si le bateau existe
        try {
            Configuration.afficherBateau(3);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

         // Test si le bateau n'existe pas
         try {
            Configuration.afficherBateau(11);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}

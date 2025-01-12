import java.util.ArrayList;

public class Bateau {
    private int idBateau; // Identifiant unique du bateau
    private String nomBateau; // Nom du bateau
    private ArrayList<Case> casesBateau; // Liste des cases occupées par le bateau

    // Constructeur
    public Bateau(int idBateau, String nomBateau, ArrayList<Case> casesBateau) {
        this.idBateau = idBateau;
        this.nomBateau = nomBateau;
        this.casesBateau = casesBateau;
    }

    // Getter pour l'identifiant du bateau
    public int getIdBateau() {
        return idBateau;
    }

    // Getter pour le nom du bateau
    public String getNomBateau() {
        return nomBateau;
    }

      // Méthode pour obtenir la taille du bateau
      public int getTaille() {
        return casesBateau.size();
    }

    /**
     * Retourne la liste des cases occupées par le bateau.
     * @return Liste des cases
     */
    public ArrayList<Case> getCasesBateau() {
        return casesBateau;
    }

     // Méthode pour vérifier si le bateau est coulé
    /*  public boolean estCoule() {
        for (int i = 0; i < casesBateau.size(); i++) {
            if (!casesBateau.get(i).isTouche()) {
                return false;
            }
        }
        return true;
    }*/
    public boolean estCoule() {
        for (Case c : casesBateau) {
            if (!c.isTouche()) {
                return false;
            }
        }
        return true;
    }
    


    // Méthode pour obtenir une case spécifique par ses coordonnées
    public Case getCellXY(int numLigne, int numColonne) {
        for (int i = 0; i < casesBateau.size(); i++) {
            if (casesBateau.get(i).getNumLigne() == numLigne && casesBateau.get(i).getNumColonne() == numColonne) {
                return casesBateau.get(i);
            }
        }
        return null; // Retourne null si aucune case ne correspond
    }

    // Méthode pour obtenir une case par son index dans le tableau
    public Case getPositionCase(int indice) {
        if (indice >= 0 && indice < casesBateau.size()) {
            return casesBateau.get(indice);
        }
        throw new IndexOutOfBoundsException("Indice de case invalide.");
    }

    // Méthode toString pour une représentation lisible
    @Override
    public String toString() {
        return "Bateau[id=" + this.getIdBateau() + ", nom=" + this.getNomBateau() + ", taille=" + getTaille() + "]";
    }
}

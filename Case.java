/**
 * Classe Case pour représenter une case du plateau.
 */
class Case {
    private int numLigne; // Numéro de la ligne de la case
    private int numColonne; // Numéro de la colonne de la case
    private int idBateau; // Identifiant du bateau présent sur cette case (0 si aucun)
    private boolean touche; // État de la case : true si touchée, false sinon

    /**
     * Constructeur de la classe Case.
     * Initialise les coordonnées et les attributs par défaut.
     * @param numLigne Ligne de la case
     * @param numColonne Colonne de la case
     */
    public Case(int numLigne, int numColonne) {
        this.numLigne = numLigne;
        this.numColonne = numColonne;
        this.idBateau = 0; // Par défaut, aucun bateau sur la case
        this.touche = false; // Par défaut, la case n'est pas touchée
    }

    // Getters et Setters

    /**
     * Retourne le numéro de ligne de la case.
     * @return Numéro de ligne
     */
    public int getNumLigne() {
        return numLigne;
    }

    
    // Retourne le numéro de colonne de la case.
    public int getNumColonne() {
        return numColonne;
    }

    
    // Retourne l'identifiant du bateau présent sur la case.
    public int getIdBateau() {
        return idBateau;
    }

    /**
     * Retourne l'état de la case (touchée ou non).
     * @return true si la case est touchée, false sinon
     */
    public boolean isTouche() {
        return touche;
    }

    
    // Modifie l'état de la case (touchée ou non).
    public void setTouche(boolean touche) {
        this.touche = touche;
    }

    
     // Associe un identifiant de bateau à la case.
     
    public void setIdBateau(int idBateau) {
        this.idBateau = idBateau;
    }

    
    // Retourne les informations de la case.
    @Override
    public String toString() {
        return "Case[ligne=" + this.getNumLigne() + ", colonne=" + this.getNumColonne() + ", idBateau=" + this.getIdBateau() + ", touche=" + this.isTouche() + "]";
    }
}

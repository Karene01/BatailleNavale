public abstract class Joueur {
    protected String nomJoueur;
    protected Plateau monPlateau;
    protected Case derniere_frappe;
    protected int frappeTotal;
    protected int frappeReussie;
    protected int nbBateauCoule;

    /**
     * Constructeur de la classe Joueur
     * @param nom Nom du joueur
     */
    public Joueur(String nom) {
        this.nomJoueur = nom;
        this.monPlateau = new Plateau();
        this.derniere_frappe = new Case(-1, -1); // Initialisation à (-1, -1)
        this.frappeTotal = 0;
        this.frappeReussie = 0;
        this.nbBateauCoule = 0;
    }

    // Getters
    public String getNomJoueur() {
        return this.nomJoueur;
    }

    public Plateau getPlateau() {
        return this.monPlateau;
    }

    public Case getDerniereFrappe() {
        return this.derniere_frappe;
    }

    public int getFrappeTotal() {
        return this.frappeTotal;
    }

    public int getFrappeReussie() {
        return this.frappeReussie;
    }

    public int getBateauCoule() {
        return this.nbBateauCoule;
    }

    /**
     * Met à jour la dernière frappe effectuée
     * @param ligne Ligne de la frappe
     * @param colonne Colonne de la frappe
     */
    public void setDerniereFrappe(int ligne, int colonne) {
        this.derniere_frappe = new Case(ligne, colonne);
    }

    /**
     * Incrémente le compteur de frappes totales
     */
    public void incrementerFrappeTotal() {
        this.frappeTotal++;
    }

    /**
     * Incrémente le compteur de frappes réussies
     */
    public void incrementerFrappeReussie() {
        this.frappeReussie++;
    }

    /**
     * Incrémente le compteur de bateaux coulés
     */
    public void incrementerBateauCoule() {
        this.nbBateauCoule++;
    }

    /**
     * Affiche les statistiques du joueur
     */
    public void afficherStatistiques() {
        System.out.println("\n=== Statistiques de " + nomJoueur + " ===");
        System.out.println("Nombre total de tirs : " + frappeTotal);
        System.out.println("Nombre de tirs réussis : " + frappeReussie);
        System.out.println("Nombre de bateaux coulés : " + nbBateauCoule);
    }

    /**
     * Vérifie si tous les bateaux du joueur sont coulés
     * @return true si tous les bateaux sont coulés, false sinon
     */
    public boolean tousLesBateauxCoules() {
        for (Bateau bateau : monPlateau.getTabBateau()) {
            if (!bateau.estCoule()) {
                return false;
            }
        }
        return true;
    }

    // Méthodes abstraites à implémenter dans les classes filles
    public abstract void placerBateaux();
    public abstract void tirer(Joueur adversaire);
    protected abstract void initNom();
}
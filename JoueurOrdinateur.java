import java.util.Random;
import java.util.ArrayList;

public class JoueurOrdinateur extends Joueur {
    private Random random;

    public JoueurOrdinateur() {
        super("");
        this.random = new Random();
        initNom();
    }

    @Override
    protected void initNom() {
        this.nomJoueur = "Bot-" + (random.nextInt(900) + 100); // Génère un nombre entre 100 et 999
    }

    @Override
    public void placerBateaux() {
        for (int i = 0; i < Configuration.getNombreBateaux(); i++) {
            String[] specsBateau = Configuration.getBateau(i);
            int idBateau = Integer.parseInt(specsBateau[0]);
            String nomBateau = specsBateau[1];
            int tailleBateau = Integer.parseInt(specsBateau[2]);

            boolean placement_reussi = false;
            while (!placement_reussi) {
                // Génère des coordonnées aléatoires
                int ligne = random.nextInt(Configuration.getTailleGrille());
                int colonne = random.nextInt(Configuration.getTailleGrille());
                boolean horizontal = random.nextBoolean();

                ArrayList<Case> casesBateau = new ArrayList<>();
                boolean casesValides = true;

                // Vérifie si le bateau peut être placé à partir de ce point
                for (int j = 0; j < tailleBateau; j++) {
                    int nouvelleLigne = horizontal ? ligne : ligne + j;
                    int nouvelleColonne = horizontal ? colonne + j : colonne;

                    // Vérifie si les coordonnées sont dans les limites
                    if (!monPlateau.caseValide(nouvelleLigne, nouvelleColonne)) {
                        casesValides = false;
                        break;
                    }
                    casesBateau.add(new Case(nouvelleLigne, nouvelleColonne));
                }

                if (casesValides && !monPlateau.aDesCasesVoisines(casesBateau)) {
                    // Crée et ajoute le bateau
                    Bateau nouveauBateau = new Bateau(idBateau, nomBateau, casesBateau);
                    if (monPlateau.ajoutBateau(nouveauBateau)) {
                        placement_reussi = true;
                    }
                }
            }
        }
    }

    @Override
public void tirer(Joueur adversaire) {
    boolean tir_valide = false;
    
    while (!tir_valide) {
        // Génère des coordonnées de tir aléatoires
        int ligne = random.nextInt(Configuration.getTailleGrille());
        int colonne = random.nextInt(Configuration.getTailleGrille());
        
        Case caseVisee = adversaire.getPlateau().getCase(ligne, colonne);
        
        // Vérifie si la case n'a pas déjà été ciblée
        if (!caseVisee.isTouche()) {
            // Met à jour les statistiques et l'état du jeu
            this.incrementerFrappeTotal();
            caseVisee.setTouche(true);
            setDerniereFrappe(ligne, colonne);
            
            // Vérifie le résultat du tir
            if (caseVisee.getIdBateau() != 0) {
                this.incrementerFrappeReussie();
                Bateau bateauTouche = adversaire.getPlateau().getBateauById(caseVisee.getIdBateau());
                
                // Marquer la case comme touchée dans le bateau
                for (Case c : bateauTouche.getCasesBateau()) {
                    if (c.getNumLigne() == ligne && c.getNumColonne() == colonne) {
                        c.setTouche(true);
                        break;
                    }
                }
                
                System.out.println(nomJoueur + " : Touché !");
                
                if (bateauTouche.estCoule()) {
                    this.incrementerBateauCoule();
                    System.out.println(nomJoueur + " : Coulé ! Le " + bateauTouche.getNomBateau() + 
                                     " a été détruit !");
                }
            } else {
                System.out.println(nomJoueur + " : Raté !");
            }
            
            tir_valide = true;
        }
    }
}
}
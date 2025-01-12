import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class JoueurHumain extends Joueur {
    private BufferedReader reader;

    public JoueurHumain() {
        super("");  // Le nom sera initialisé dans initNom()
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        initNom();
    }

    @Override
    protected void initNom() {
        try {
            System.out.print("Entrez votre nom : ");
            String nom = reader.readLine().trim();
            while (nom.isEmpty()) {
                System.out.print("Le nom ne peut pas être vide. Réessayez : ");
                nom = reader.readLine().trim();
            }
            this.nomJoueur = nom;
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du nom : " + e.getMessage());
            this.nomJoueur = "Joueur Humain";
        }
    }

    @Override
    public void placerBateaux() {
        System.out.println("\n=== Placement des bateaux pour " + nomJoueur + " ===");
        Configuration.afficherTousBateaux();
        
        for (int i = 0; i < Configuration.getNombreBateaux(); i++) {
            String[] specsBateau = Configuration.getBateau(i);
            int idBateau = Integer.parseInt(specsBateau[0]);
            String nomBateau = specsBateau[1];
            int tailleBateau = Integer.parseInt(specsBateau[2]);
            
            boolean placement_reussi = false;
            while (!placement_reussi) {
                try {
                    monPlateau.afficherPlateauJoueur();
                    System.out.println("\nPlacement du " + nomBateau + " (taille " + tailleBateau + ")");
                    
                    // Saisie des coordonnées de début
                    System.out.print("Entrez la position de début (ex: A0) : ");
                    String posDebut = reader.readLine().toUpperCase().trim();
                    
                    // Vérification du format
                    if (!Pattern.matches("^[A-J][0-9]$", posDebut)) {
                        System.out.println("Format invalide ! Utilisez une lettre (A-J) suivie d'un chiffre (0-9)");
                        continue;
                    }
                    
                    // Conversion des coordonnées
                    int colonne = posDebut.charAt(0) - 'A';
                    int ligne = Character.getNumericValue(posDebut.charAt(1));
                    
                    // Saisie de la direction
                    System.out.print("Choisissez la direction (H: horizontal, V: vertical) : ");
                    String direction = reader.readLine().toUpperCase().trim();
                    
                    if (!direction.matches("[HV]")) {
                        System.out.println("Direction invalide ! Utilisez H ou V");
                        continue;
                    }
                    
                    // Création de la liste des cases pour le bateau
                    ArrayList<Case> casesBateau = new ArrayList<>();
                    for (int j = 0; j < tailleBateau; j++) {
                        if (direction.equals("H")) {
                            if (colonne + j >= Configuration.getTailleGrille()) {
                                throw new IllegalArgumentException("Le bateau dépasse du plateau !");
                            }
                            casesBateau.add(new Case(ligne, colonne + j));
                        } else {
                            if (ligne + j >= Configuration.getTailleGrille()) {
                                throw new IllegalArgumentException("Le bateau dépasse du plateau !");
                            }
                            casesBateau.add(new Case(ligne + j, colonne));
                        }
                    }
                    
                    // Vérification des cases voisines
                    if (monPlateau.aDesCasesVoisines(casesBateau)) {
                        System.out.println("Erreur : Un bateau se trouve à proximité !");
                        continue;
                    }
                    
                    // Création et ajout du bateau
                    Bateau nouveauBateau = new Bateau(idBateau, nomBateau, casesBateau);
                    if (monPlateau.ajoutBateau(nouveauBateau)) {
                        placement_reussi = true;
                        System.out.println(nomBateau + " placé avec succès !");
                    } else {
                        System.out.println("Erreur lors du placement du bateau. Réessayez.");
                    }
                    
                } catch (IOException e) {
                    System.out.println("Erreur de saisie. Réessayez.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("\nTous les bateaux ont été placés !");
    }

@Override
public void tirer(Joueur adversaire) {
    boolean tir_valide = false;
    
    while (!tir_valide) {
        try {
            System.out.println("\nC'est à " + nomJoueur + " de tirer");
            System.out.print("Entrez les coordonnées de tir (ex: A0) : ");
            String posTir = reader.readLine().toUpperCase().trim();
            
            // Vérification du format
            if (!Pattern.matches("^[A-J][0-9]$", posTir)) {
                System.out.println("Format invalide ! Utilisez une lettre (A-J) suivie d'un chiffre (0-9)");
                continue;
            }
            
            // Conversion des coordonnées
            int colonne = posTir.charAt(0) - 'A';
            int ligne = Character.getNumericValue(posTir.charAt(1));
            
            // Vérification si la case a déjà été ciblée
            Case caseVisee = adversaire.getPlateau().getCase(ligne, colonne);
            if (caseVisee.isTouche()) {
                System.out.println("Cette case a déjà été ciblée !");
                continue;
            }
            
            // Mise à jour des statistiques et de l'état du jeu
            this.incrementerFrappeTotal();
            caseVisee.setTouche(true);
            setDerniereFrappe(ligne, colonne);
            
            // Vérification du résultat du tir
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
                
                System.out.println("Touché !");
                
                if (bateauTouche.estCoule()) {
                    this.incrementerBateauCoule();
                    System.out.println("Coulé ! Le " + bateauTouche.getNomBateau() + " a été détruit !");
                }
            } else {
                System.out.println("Raté !");
            }
            
            tir_valide = true;
            
        } catch (IOException e) {
            System.out.println("Erreur de saisie. Réessayez.");
        }
    }
}

}
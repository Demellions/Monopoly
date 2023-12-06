import java.awt.*;
import java.util.List;
import javax.swing.JOptionPane;

public class Pions extends Frame {
    private String name;
    private int epiCoins;
    private int x = 10;
    private int y = 10;
    private boolean inIonis;
    private DeckMystere mystereDeck;
    private DeckChance chanceDeck;
    protected Image image;
    private int position;
    private List<Cases> tableau;
    private Projets projetsInstance;

    public Pions(String name, int rank) {
        this.name = name;
        this.epiCoins = 1500;
        this.x = 10;
        this.y = 10;
        this.inIonis = false;
        this.image = Toolkit.getDefaultToolkit().getImage("Ressources/cavalerie" + rank + ".png");
        this.position = 0;
        System.out.println("Pion " + this.name + " created");
    }

    public Pions(List<Cases> tableau) {
        // Initialize Mystere and Chance decks
        mystereDeck = new DeckMystere();
        chanceDeck = new DeckChance();
        this.tableau = tableau;
    }

    public Image getImage() {
        return this.image;
    }

    public int getEpicoins() {
        return this.epiCoins;
    }

    public void setEpicoins(int epiCoins) {
        if (epiCoins >= 0) {
            this.epiCoins = epiCoins;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isInIonis() {
        return this.inIonis;
    }

    public void setInIonis(boolean inIonis) {
        this.inIonis = inIonis;
    }

    public void move(int num) {
        // Supprimer le pion du panel
        // Plateau.removePionFromPanel(this);
        for (int i = 0; i < num; i++) {
            if (this.getX() == 10 && this.getY() > 0) {
                // Aller vers le haut
                this.setY(this.getY() - 1);
            } else if (this.getX() > 0 && this.getY() == 0) {
                // Aller vers la droite
                this.setX(this.getX() - 1);
            } else if (this.getX() == 0 && this.getY() < 10) {
                // Aller vers le bas
                this.setY(this.getY() + 1);
            } else if (this.getX() < 10 && this.getY() == 10) {
                // Aller vers la gauche
                this.setX(this.getX() + 1);
            }

            if (this.getX() == 10 && this.getY() == 10) {
                System.out.println("Tu es passé par la case départ, tu reçois 500 epiCoins");
                this.setEpicoins(this.getEpicoins() + 500);
            }

        }
        moveTo(this.getX(), this.getY());
        System.out.println(this.getName() + " est maintenant en " + this.getX() + ", " + this.getY()
                + ". Car il a fait " + num + ". Il est donc sur la case "
                + Plateau.allCases.get(this.position).getName() + ".");
    }

    public void moveTo(int x, int y) {

        // Mettre à jour les coordonnées du pion
        this.setX(x);
        this.setY(y);

        // Ajouter le pion au panel

        Plateau.addPionToPanel(this);
    }

    public void numberDe(int num) {
        int position = this.getPosition();
        Cases emplacement = null;

        if (position + num > 39) {
            emplacement = Plateau.allCases.get(position + num - 40);
            this.setPosition(position + num - 40);
        } else {
            emplacement = Plateau.allCases.get(position + num);
            this.setPosition(position + num);
        }

        System.out.println(this.getName() + " est arrivé sur " + emplacement.getName());

        move(num);
        checkCase(emplacement, this);
    }

    public void update() {
        System.out.println("ya");
        List<Projets> listpro = Projets.getAllprojets();
        System.out.println(listpro);
        for (Projets unpro : listpro) {
            System.out.println("ye");
            System.out.println(unpro.getcasesprojet());
            Pions own = this;
            int i = 0;
            for (Cases sacase : unpro.getcasesprojet()) {
                
                System.out.println("ya");
                
                if(own != sacase.getOwner()) {
                    System.out.println("not good owner");
                    break;
                } else {
                    i++;
                    if(i == unpro.getcasesprojet().size()){
                        int option = JOptionPane.showConfirmDialog(null,
                        "Souhaitez-vous effectuer des mises à jour ?",
                        "Mettre à jour",
                        JOptionPane.YES_NO_OPTION);
                        if(option == JOptionPane.YES_OPTION){
                            int numbermaj = Integer.parseInt(JOptionPane.showInputDialog("Combien en voulez-vous ?"));
                            JOptionPane.showMessageDialog(null, "Cela vous coutera " + numbermaj * unpro.getMajprice(), "Prix", JOptionPane.INFORMATION_MESSAGE);
                            while(numbermaj > 0) {
                                for (Cases amcase : unpro.getcasesprojet()){
                                    int nmaj = Integer.parseInt(JOptionPane.showInputDialog("Combien de mises à jour souhaitez-vous effectuer sur la case " + amcase.getName() + " ?"));
                                    if(nmaj>numbermaj){
                                        JOptionPane.showMessageDialog(null, "Vous n'avez pas pris assez de maisons", "Prix", JOptionPane.INFORMATION_MESSAGE);

                                    } else if (nmaj > 5){
                                        JOptionPane.showMessageDialog(null, "Vous ne pouvez pas dépasser 5 mises à jour", "Prix", JOptionPane.INFORMATION_MESSAGE);

                                    } else {
                                        numbermaj -= nmaj;
                                        amcase.setState(nmaj);
                                        System.out.println(nmaj);                           
                                        System.out.println(amcase.getState());
                                        System.out.println(amcase.getLevel());
                                        System.out.println(amcase.getLevel().get(nmaj));
                                        amcase.getLevel().get(nmaj);
                                        amcase.setDebt(amcase.getLevel().get(nmaj));
                                        System.out.println(amcase.getDebt());
                                        JOptionPane.showMessageDialog(null, "Vous avez mis à jour la case " + amcase.getName(), "Prix", JOptionPane.INFORMATION_MESSAGE);
                                        System.out.println(amcase.getName() + " mis à jour.");

                                    }
                                    

                                }
                                
                            }

                        } else {
                            System.out.println(getName() + "n'a fait aucune mise à jour pour le projet" + unpro.getTitre());
                        }
                    }
                }
            }
        }
    }
    
    

    public void checkCase(Cases emplacement, Pions pion) {
        if (emplacement.getOwner() == null && emplacement.getPrice() != 0) {
            if (pion.getEpicoins() >= emplacement.getPrice()) {
                System.out.println("Tu peux acheter cette case pour " + emplacement.getPrice() + " epiCoins.");
                int option = JOptionPane.showConfirmDialog(null,
                        "Souhaitez-vous achetez la Case " + emplacement.getName() + " pour la modique somme de "
                                + emplacement.getPrice() + " ?",
                        "Achat Case",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    pion.buyCase(emplacement);
                } else {
                    System.out.println(this.getName() + " n'a pas acheté la case " + emplacement.getName() + ".");
                }
            } else {
                System.out.println(this.getName() + " n'a pas assez d'epicoins pour acheter cette case.");
                JOptionPane.showMessageDialog(null,
                        this.getName() + " n'a pas assez d'épicoins pour pouvoir acheter cette case.",
                        "Achat Case", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (emplacement.getOwner() != null && emplacement.getPrice() != 0) {
            pion.payDebtCase(emplacement);
        } else {
            System.out.println("In Progress.");
        }
    }

    // Next two methods are for draw mystere and chance cards
    public Mystere drawMystereCard() {
        return mystereDeck.drawMystereCard();
    }

    public Chance drawChanceCard() {
        return chanceDeck.drawChanceCard();
    }

    // perform an action based on the type of the current case
    public void performCaseAction(Cases currentCase, List<Cases> tableau) {
        switch (currentCase.getType()) {
            case MYSTERE: // enum CaseType creates in Cases.java
                performMystereCaseAction();
                break;
            case CHANCE:
                performChanceCaseAction();
                break;

        }
    }

    // perform mystere case action
    private void performMystereCaseAction() {
        Mystere drawnCard = drawMystereCard();
        if (drawnCard != null) {
            drawnCard.performAction(this, tableau);
        }
    }

    // perform chance case action
    private void performChanceCaseAction() {
        Chance drawnCard = drawChanceCard();
        if (drawnCard != null) {
            drawnCard.performAction(this, tableau);
        }
    }

    public void payDebt(int number) {
        if (this.getEpicoins() >= number) {
            this.setEpicoins(this.getEpicoins() - number);
            System.out.println(this.getName() + " a été débité de " + number + " epiCoins. Il lui en reste désormais "
                    + this.getEpicoins() + ".");
        } else {
            Plateau.pions.remove(this);
            System.out.println(this.getName() + " n'a pas assez d'epicoins pour payer sa dette. Il est donc éliminé.");
            JOptionPane.showMessageDialog(null,
                    this.getName() + " n'a pas assez d'epicoins pour payer sa dette. Il est donc éliminé.",
                    "Elimination", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void getMoney(int number) {
        this.setEpicoins(this.getEpicoins() + number);
        System.out.println(this.getName() + " a reçu " + number + " epiCoins. Il en a désormais "
                + this.getEpicoins() + ".");
    }

    public void buyCase(Cases obj) {
        if (obj.getOwner() == this) {
            System.out.println(this.getName() + " possède déjà cette case.");
            return;
        }
        if (this.getEpicoins() >= obj.getPrice() && obj.getOwner() == null) {
            this.setEpicoins(this.getEpicoins() - obj.getPrice());
            obj.setOwner(this);

            System.out.println(this.getName() + " a acheté la case " + obj.getName() + " pour " + obj.getPrice()
                    + " epiCoins. Il lui en reste désormais " + this.getEpicoins() + ".");
        } else if (this.getEpicoins() < obj.getPrice() && obj.getOwner() == null) {
            System.out.println(this.getName() + " n'a pas assez d'epicoins pour acheter cette case.");
        } else {
            System.out.println(this.getName() + " ne peut pas acheter cette case car elle est déjà achetée.");
        }
    }

    public void payDebtCase(Cases obj) {
        if (obj.getOwner() != this) {
            System.out.println(
                    this.getName() + " est tombé sur la case " + obj.getName() + " qui appartient à "
                            + obj.getOwner().getName()
                            + ". " + this.getName() + " dois lui payer " + obj.getDebt() + " epiCoins.");
            JOptionPane.showMessageDialog(null,
                    this.getName() + " est tombé sur la case " + obj.getName() + " qui appartient à "
                            + obj.getOwner().getName()
                            + ". " + this.getName() + " dois lui payer " + obj.getDebt() + " epiCoins.",
                    "Paiement de dette", JOptionPane.INFORMATION_MESSAGE);
            this.payDebt(obj.getDebt());
            obj.getOwner().getMoney(obj.getDebt());
        } else {
            System.out.println(this.getName() + " est tombé sur ta propre case.");
        }
    }
}
import java.util.ArrayList;
import java.util.List;

public class DeckMystere {
    private List<Mystere> mystereCards;

    public DeckMystere() {
        mystereCards = new ArrayList<>();
        // Initialize Chance cards here
        initializeMystereCards();
    }

    private void initializeMystereCards() {
        // we can add here the chance cards
        mystereCards.add(new Mystere("Aller en prison. Rendez-vous directement en prison. Ne franchissez pas par la case départ, ne touchez pas Ephicoins", 1));
        mystereCards.add(new Mystere("Amende pour excès de vitesse 200EPC", 2));
        mystereCards.add(new Mystere("Amende pour ivresse 200EPC", 3));
        mystereCards.add(new Mystere("Suite à une attaque informatique, un de vos projets a été volé!", 4));
        mystereCards.add(new Mystere("C'est votre jour de chance ! Un investisseur souhaite payer la phase d'un de vos projets! Va chez qui tu veux", 5));
        mystereCards.add(new Mystere("Le taco que tu a mangé n'était pas en bon état et vous devriez rester à la maison! Tu perds un tour", 6));
        mystereCards.add(new Mystere("C'est ton anniversaire! Les joueurs vous donnent 50 EPC chacun", 7));
        mystereCards.add(new Mystere("La bourse vous a été refusée, vous devez payer le double pendant une période de deux tours", 8));
        mystereCards.add(new Mystere("Vous avez remporté un prix de l'innovation informatique! Vous obtenez 200EPC", 9));
    }
    


    public Mystere drawMystereCard() {
        if (!mystereCards.isEmpty()) {
            int index = (int) (Math.random() * mystereCards.size());
            return mystereCards.remove(index);
        } else {
            System.out.println("The Mystere deck is empty!");
            return null;
        }
    }

    public void performRandomAction(Pions pion, List<Cases> tableau) {
        Mystere drawnCard = drawMystereCard();
        if (drawnCard != null) {
            drawnCard.performAction(pion, tableau);
        } else {
            System.out.println("No mystere card drawn.");
        }
    }
}

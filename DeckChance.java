import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class DeckChance {
    private Queue<Chance> chanceCards;

    public DeckChance() {
        chanceCards = new LinkedList<>();
        // Initialize Chance cards here
        initializeChanceCards();
    }

    private void initializeChanceCards() {
        chanceCards.add(new Chance("Pay 50 epiCoins to the bank", 1));
        chanceCards.add(new Chance("Move to the nearest unowned property and buy it", 2));
        chanceCards.add(new Chance("Avancer jusqu'à la case départ", 3));
        chanceCards.add(new Chance("Rendez-vous à l'Avenue TkinterPython. Si vous passez par la case départ, recevez 500 Ephicoin", 4));
        chanceCards.add(new Chance("Avancez au Boulevard de VR. Si vous passez par la case départ, recevez 500 Ephicoin", 5));
        chanceCards.add(new Chance("Il est temps de payer les dettes! Vous devez payer 150 Ephicoin par projet individuel(non terminé) et 500 Ephicoin par projet terminé.", 6));
        chanceCards.add(new Chance("Faites une pause et allez manger à la boulangerie. Si vous passez par le point de départ, recevez 500 Ephicoin", 7));
        chanceCards.add(new Chance("Vous avez passé la moulinette! Recevez 250 Ephicoin", 8));
        chanceCards.add(new Chance("C'est votre jour de chance! vous avez trouvé un billet de 50 Ephicoin!", 9));
        chanceCards.add(new Chance("Vous êtes libéré de prison. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée.", 10));
        chanceCards.add(new Chance("Reculez de trois cases", 11));
    }

    public Chance drawChanceCard() {
        if (!chanceCards.isEmpty()) {
            refillDeck();
        } 
        return chanceCards.poll();
    }

    public void performRandomAction(Pions pion, List<Cases> tableau) {
        Chance drawnCard = drawChanceCard();
        if (drawnCard != null) {
            drawnCard.performAction(pion, tableau);
            chanceCards.offer(drawnCard);
        } else {
            System.out.println("No chance card drawn.");
        }
    }

    // private void refillDeck(){
    //     System.out.println("refilling the chance deck...");
    //     Collections.shuffle(new ArrayList<>(chanceCards));
    // }


    private void refillDeck() {
        System.out.println("Refilling the Chance deck...");
        
        //initialize Chance cards as in the constructor
        initializeChanceCards();
        
        //shuffle the recycled cards
        List<Chance> tempList = new ArrayList<>(chanceCards);
        chanceCards.clear();
        Collections.shuffle(tempList);
        chanceCards.addAll(tempList);
    }
    
}

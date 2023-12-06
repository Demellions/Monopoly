import java.util.ArrayList;
import java.util.List;

public class Mystere extends DeckMystere {
    private String description;
    private int id;

    public Mystere(String description, int id) {
        this.description = description;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void performAction(Pions pion, List<Cases> tableau) {
        switch (id) {
            case 1:
                // "Pay 50 epiCoins to the bank"
                pion.payDebt(50);
                System.out.println("Chance Card Action: Paid 50 epiCoins to the bank.");
                break;

            case 2:
                // "Move to the nearest unowned property and buy it"
                moveToNearestUnownedProperty(pion, tableau);
                System.out.println("");
                break;

            case 3:
                // "move to case depart"
                pion.moveTo(10, 10);
                System.out.println("Chance Card Action: Avancer jusqu'à la case départ. Vous obtenez 200EPC");
                break;

            case 4:
                // "Move to Tkinter"
                pion.moveTo(10, 1);
                pion.getMoney(500);
                System.out.println("Chance Card Action: Rendez-vous à l'Avenue TkinterPython. Si vous passez par la case départ, recevez 500 Ephicoin");
                break;

            case 5:
                // "Move to the Boulevard de VR"
                pion.moveTo(1, 10);
                pion.getMoney(500);
                System.out.println("Chance Card Action: Avancez au Boulevard de VR. Si vous passez par la case départ, recevez 500 Ephicoin");
                break;
        
            case 6:
                // for after
                pion.payDebt();
                System.out.println("Chance Card Action: ");
                break;

            case 7:
                // move to the boulangerie
                pion.moveTo(5, 10);
                //if to add
                   pion.getMoney(500);
                System.out.println("Chance Card Action: Faites une pause et allez manger à la boulangerie. Si vous passez par le point de départ, recevez 500 Ephicoin");
                break;

            case 8:
                // moulinette passed
                System.out.println("Chance Card Action: Vous avez passé la moulinette! Recevez 250 Ephicoin");
                pion.getMoney(250);
                break;

            case 9:
                // Lucky day
                pion.getMoney(50);
                System.out.println("Chance Card Action: C'est votre jour de chance! vous avez trouvé un billet de 50 Ephicoin!");
                break;

            case 10:
                // -3 cases
                pion.moveTo(pion.getX() - 3, pion.getY() - 3);
                System.out.println("Reculez de trois cases");
                break;

            default:
                System.out.println("Unhandled Chance card action with id: " + id);
        }
    }

    private void moveToNearestUnownedProperty(Pions pion, List<Cases> gameBoard) {
        // move to the nearest unowned property and buying it
        Cases nearestUnownedProperty = findNearestUnownedProperty(gameBoard, pion.getX(), pion.getY());

        if (nearestUnownedProperty != null) {
            pion.moveToSpecificCase(nearestUnownedProperty);
        } else {
            System.out.println("No unowned properties nearby.");
        }
    }

    private Cases findNearestUnownedProperty(List<Cases> gameBoard, int currentPlayerX, int currentPlayerY) {
        // find the nearest unowned property (optional)
        
        return null;
    }
}

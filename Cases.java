import java.util.*;
import java.util.List;
import java.awt.*;
import javax.swing.*;

public class Cases {

    private String name;
    private Color color;
    private int price;
    private int state;
    private int base;
    private int planification;
    private int conception;
    private int development;
    private int test;
    private int deployment;
    private Pions owner = null;
    private int debt;
    private int rank;
    private static int nextRank = 1;
    private CaseType type;
    private List<Integer> level;

    // enum Casetype
    public enum CaseType {
        MYSTERE, CHANCE;
    }

    public void setOwner(Pions owner) {
        this.owner = owner;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Pions getOwner() {
        return owner;
    }

    public int getBase() {
        return base;
    }

    public int getConception() {
        return conception;
    }

    public int getDebt() {
        return debt;
    }

    public int getDeployment() {
        return deployment;
    }

    public int getDevelopment() {
        return development;
    }

    public int getPlanification() {
        return planification;
    }

    public int getPrice() {
        return price;
    }

    public int getState() {
        return state;
    }

    public int getTest() {
        return test;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setConception(int conception) {
        this.conception = conception;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public void setDeployment(int deployment) {
        this.deployment = deployment;
    }

    public void setDevelopment(int development) {
        this.development = development;
    }

    public void setPlanification(int planification) {
        this.planification = planification;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public void setState(int state) {
        this.state = state;
    }


    public String getName() {
        return name;
    }

    public List<Integer> getLevel() {
        return level;
    }

    public void setLevel(int base, int planification, int conception, int development, int test, int deployment) {
        this.level = Arrays.asList(base, planification, conception, development, test, deployment);
    }

    public boolean canUpdate(Pions p){
        for (Projets unpro : allprojets) {
            for (Cases sacase : unpro.getcasesprojet()) {
                int i = 1;
                Pions own;
                if(own == null) {
                    own = sacase.getOwner();
                }
                if (own != sacase.getOwner()){
                    break;
                } else {
                    i++;
                    if(i == unpro.getcasesprojet().size()){
                        return true;
                    }
                }
            }
        }
    }

    // public void update(Pions pion) {
    // if (canUpdate) {
    // if (state == 0) {
    // state = base;
    // } else if ((state != level.get(level.size() - 1)) && pion.getEpicoins() >=
    // updateprice) {
    // for (int l : level) {
    // if (state > l) {
    // state = l;
    // break;
    // }

    
    



    public Cases(String name) {
        this.name = name;
        this.rank = nextRank++;
    }

    // Modif for Casetype: incluided for cards chance and mystere
    public Cases(String name, Object projet, int price, CaseType type) {
        this.name = name;
        this.projet = projet;
        this.price = price;
        this.type = type;
        this.rank = nextRank++;
        this.level = Arrays.asList(base, planification, conception, development, test, deployment);

    }

    // Modif for Casetype: incluided for cards chance and mystere
    public Cases(String name, CaseType type) {
        this.name = name;
        this.type = type;
        this.rank = nextRank++;
    }

    public Cases(String name, Object projet, int price) {
        this.name = name;
        this.projet = projet;
        this.price = price;
        this.rank = nextRank++;
        this.level = Arrays.asList(base, planification, conception,development, test, deployment);
        setDebt(base);
    }

    public CaseType getType() {
        return type;
    }

    public int getRank() {
        return rank;
    }

}

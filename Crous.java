import java.awt.Color;

public class Crous extends Cases {
    public Crous() {
        super("Crous", FastFood.class, 1);
        setColor(Color.LIGHT_GRAY);
        setBase(20);
        setPlanification(100);
        setConception(300);
        setDevelopment(900);
        setTest(1600);
        setDeployment(2500);
    }
}
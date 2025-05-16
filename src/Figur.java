import java.util.Random;
import java.awt.Graphics;

public abstract class Figur {
    protected final int factor;
    protected int offsetLeft;
    protected int maxHeightPanel;

    public Figur() {
        Random rand = new Random();
        this.factor = rand.nextInt(10) + 7;
    }

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract void paintOnGraphics(Graphics g);

    public void paintOnGraphics(Graphics g, int offsetLeft, int maxHeightPanel) {
        this.offsetLeft = offsetLeft;
        this.maxHeightPanel = maxHeightPanel;
        paintOnGraphics(g);
    }
}